/**
 * Copyright FUJITSU LIMITED 2017
 */

package org.oscm.hello;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.oscm.services.BlueprintService;

/**
 * Created by PLGrubskiM on 2017-05-24.
 */
@RunWith(SpringRunner.class)
@WebAppConfiguration
@WebMvcTest(BlueprintService.class)
@ComponentScan({"org.oscm.services"})
public class ExampleUnitTest {

    @Autowired
    private BlueprintService blueprintService;

    @Test
    public void someUnitTest() {
        Assert.assertTrue(true);
    }

    //@Test
    //public void testGetYaml() {
    //  BlueprintRequest blueprintRequest = new BlueprintRequest();
    //    blueprintRequest.setSymbolicName("name");
    //    blueprintRequest.setVersion("1");
    //    blueprintService.getYamlTemplate(blueprintRequest);
    //}
}
