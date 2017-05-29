/**
 * Copyright FUJITSU LIMITED 2017
 */

package org.oscm.hello;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.*;
import org.oscm.domainobjects.BlueprintRequest;
import org.oscm.services.BlueprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.BDDMockito.given;

/**
 * Created by PLGrubskiM on 2017-05-24.
 */
@WebAppConfiguration
@ComponentScan({"org.oscm.services"})
@RunWith(MockitoJUnitRunner.class)
public class ExampleUnitTest {

    @Autowired
    private BlueprintService blueprintService;

    @Test
    public void someUnitTest() {
        Assert.assertTrue(true);
    }

    @Test
    public void testGetYaml() {
        //given
        BlueprintRequest blueprintRequest = new BlueprintRequest();
        blueprintRequest.setVersion("1.0.0");
        blueprintRequest.setSymbolicName("Blueprint");
        blueprintRequest.setEndpoint("http://endpoint.com");
        Map<String, String> parameters = new HashMap<>();
        parameters.put("<param1>", "param1_value");
        parameters.put("<param2>", "param2_value");
        blueprintRequest.setParams(parameters);

        //when
        //blueprintService.getYamlTemplate(blueprintRequest);
        //then

    }
}
