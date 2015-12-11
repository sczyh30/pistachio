package org.samsara.pistachio.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by sczyh30 on 15-12-9.
 */
@Controller
public class AdminController {

    @RequestMapping(value = "adm1n666/index.freed0m")
    public String toIndex() {
        return "adm1n/index";
    }
}
