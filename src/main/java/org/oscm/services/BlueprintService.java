package org.oscm.services;

import java.util.HashSet;
import java.util.Map;

import org.apache.brooklyn.rest.api.CatalogApi;
import org.apache.brooklyn.rest.client.BrooklynApi;
import org.apache.brooklyn.rest.domain.CatalogEntitySummary;
import org.apache.log4j.Logger;
import org.oscm.common.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import org.oscm.domainobjects.BlueprintRequest;

/**
 * Created by BadziakP on 2017-05-24.
 */
@Service
public class BlueprintService {

    @Autowired
    private Environment environment;

    private final Logger logger = Logger.getLogger(this.getClass());

    public CatalogEntitySummary getYamlTemplate(
            BlueprintRequest blueprintRequest) throws Exception {
        try {
            CatalogEntitySummary catalogEntitySummary = getCatalogApi()
                    .getApplication(blueprintRequest.getSymbolicName(),
                            blueprintRequest.getVersion());

            return createEntityBasedOnTemplate(catalogEntitySummary,
                    blueprintRequest.getParams());
        } catch (Exception e) {
            logger.error("Something went wrong with Brooklyn!!", e);
            throw e;
        }
    }

    private CatalogEntitySummary createEntityBasedOnTemplate(
            CatalogEntitySummary template, Map<String, String> parameters) {
        String planYaml = template.getPlanYaml();
        for (Map.Entry<String, String> param : parameters.entrySet()) {
            planYaml = planYaml.replaceAll(param.getKey(), param.getValue());
        }
        return new CatalogEntitySummary(template.getSymbolicName(),
                template.getVersion(), template.getName(),
                template.getJavaType(), template.getItemType(), planYaml,
                template.getDescription(), template.getIconUrl(),
                new HashSet<>(template.getTags()), template.getConfig(),
                template.getSensors(), template.getEffectors(),
                template.isDeprecated(), template.getLinks());
    }

    public CatalogApi getCatalogApi() {
        String endpoint = environment
                .getProperty(Constants.BROOKLYN_ADDRESS_PROPERTY);
        BrooklynApi api = new BrooklynApi(endpoint, null,
                Constants.BROOKLYN_MAX_POOL_SIZE,
                Constants.BROOKLYN_TIMEOUT_IN_MILIS);
        return api.getCatalogApi();
    }
}
