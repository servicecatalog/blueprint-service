package controllers;

import domainobjects.BlueprintRequest;
import org.apache.brooklyn.rest.domain.CatalogEntitySummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import services.BlueprintService;

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
    @RequestMapping(value = "/getBlueprint", method = RequestMethod.POST, consumes = "application/json",produces =
        "application/json")
    public CatalogEntitySummary getBlueprint(@RequestBody BlueprintRequest blueprintRequest) {
        return blueprintService.getYamlTemplate(blueprintRequest);
    }
}
