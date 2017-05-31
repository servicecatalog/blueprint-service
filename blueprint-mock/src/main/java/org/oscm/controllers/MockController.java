package org.oscm.controllers;

import org.apache.brooklyn.rest.domain.CatalogEntitySummary;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by BadziakP on 2017-05-25.
 */
@RestController
public class MockController {

    @RequestMapping(value = "/v1/catalog/applications/entity1/0.1", method = RequestMethod.GET, produces =
        "application/json")
    public CatalogEntitySummary getBlueprint() {
        return new CatalogEntitySummary("entity1", "0.1", "name", "javaType",
                "itemType", "name: <param1>, value: <param2>",
                "some description", "iconUrl", new HashSet<>(), new HashSet<>(),
                new HashSet<>(), new HashSet<>(), false, new HashMap<>());
    }
}
