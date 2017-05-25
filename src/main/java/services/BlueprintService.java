package services;

import domainobjects.BlueprintRequest;
import org.apache.brooklyn.rest.client.BrooklynApi;
import org.apache.brooklyn.rest.domain.CatalogEntitySummary;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by BadziakP on 2017-05-24.
 */
@Service
public class BlueprintService {

    public CatalogEntitySummary getYamlTemplate(BlueprintRequest blueprint) {
        BrooklynApi api = new BrooklynApi(blueprint.getEndpoint(), null, 20, 5000);
        try {
            CatalogEntitySummary catalogEntitySummary =  api.getCatalogApi().getEntity(blueprint.getSymbolicName(),
                blueprint.getVersion());
            blueprint.getParams().entrySet().forEach(e -> catalogEntitySummary.getPlanYaml().replaceAll("<" + e.getKey
                () + ">", e.getValue()));
            return catalogEntitySummary;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String replaceParams(String services, Map.Entry param) {
        services = services.replace("<" + param.getKey() + ">", (CharSequence) param.getValue());
        return services;
    }
}
