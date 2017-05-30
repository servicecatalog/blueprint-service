/**
 * Copyright FUJITSU LIMITED 2017
 */

package org.oscm.main;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.apache.brooklyn.rest.api.CatalogApi;
import org.apache.brooklyn.rest.domain.CatalogEntitySummary;
import org.junit.Assert;
import org.junit.Test;
import org.oscm.domainobjects.BlueprintRequest;
import org.oscm.services.BlueprintService;

/**
 *  Created by PLGrubskiM on 2017-05-24.
 */
public class ExampleUnitTest {

    @Test
    public void testGetYaml() throws Exception {
        //given
        BlueprintService blueprintService = spy(BlueprintService.class);
        BlueprintRequest blueprintRequest = prepareBlueprintRequest();
        CatalogApi catalogApi = mock(CatalogApi.class);
        doReturn(catalogApi).when(blueprintService).getCatalogApi();
        CatalogEntitySummary catalogEntitySummary = prepareCatalogEntry();
        doReturn(catalogEntitySummary).when(catalogApi).getApplication(anyString(), anyString());

        //when
        CatalogEntitySummary result = blueprintService.getYamlTemplate(blueprintRequest);

        //then
        Assert.assertTrue(result.getPlanYaml().contains("param1_value"));
        Assert.assertFalse(result.getPlanYaml().contains("<param1>"));
        Assert.assertTrue(result.getPlanYaml().contains("param2_value"));
        Assert.assertFalse(result.getPlanYaml().contains("<param2>"));
    }

    private BlueprintRequest prepareBlueprintRequest() {
        BlueprintRequest blueprintRequest = new BlueprintRequest();
        blueprintRequest.setVersion("1.0.0");
        blueprintRequest.setSymbolicName("Blueprint");
        blueprintRequest.setEndpoint("http://192.168.30.211:8081");
        Map<String, String> parameters = new HashMap<>();
        parameters.put("<param1>", "param1_value");
        parameters.put("<param2>", "param2_value");
        blueprintRequest.setParams(parameters);
        return blueprintRequest;
    }

    private CatalogEntitySummary prepareCatalogEntry() {
        CatalogEntitySummary catalogEntitySummary = new CatalogEntitySummary("symbolicName", "version", "name",
            "javaType", "itemType", "name: <param1>, value: <param2>", "description", "iconUrl", new HashSet<>(),
            new HashSet<>(), new HashSet<>(), new HashSet<>(), false, new HashMap<>());
        return catalogEntitySummary;
    }

}
