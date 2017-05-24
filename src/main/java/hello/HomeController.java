/**
 *  Copyright FUJITSU LIMITED 2017
 */

package hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by PLGrubskiM on 2017-05-24.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String index() {
        return "index.html";
    }

}
