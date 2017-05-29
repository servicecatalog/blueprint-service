package org.oscm.controllers;

import org.oscm.domainobjects.BlueprintRequest;
import org.apache.brooklyn.rest.domain.CatalogEntitySummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.oscm.services.BlueprintService;

/**
 * Created by BadziakP on 2017-05-25.
 */
@RestController
public class BlueprintController {

    @Autowired
    private BlueprintService blueprintService;

    /**
     *
     * @param blueprintRequest
     * @return
     */
    @RequestMapping(value = "/blueprints/{name}/{version:.+}", method = RequestMethod.POST,
        consumes = "application/json", produces = "application/json")
    public CatalogEntitySummary getBlueprint(@PathVariable String name,
            @PathVariable String version,
            @RequestBody BlueprintRequest blueprintRequest) throws Exception {
        blueprintRequest.setSymbolicName(name);
        blueprintRequest.setVersion(version);
        return blueprintService.getYamlTemplate(blueprintRequest);
    }
}
