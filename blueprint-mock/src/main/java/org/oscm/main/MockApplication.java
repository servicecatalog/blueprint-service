/**
 *  Copyright FUJITSU LIMITED 2017
 */

package org.oscm.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by PLGrubskiM on 2017-05-24.
 */
@SpringBootApplication
@ComponentScan({"org.oscm.controllers"})
public class MockApplication {
    public static void main(String[] args) {
        SpringApplication.run(MockApplication.class, args);
    }

}