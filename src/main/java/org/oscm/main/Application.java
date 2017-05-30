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
@ComponentScan({"org.oscm.services", "org.oscm.controllers", "org.oscm.resources"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}