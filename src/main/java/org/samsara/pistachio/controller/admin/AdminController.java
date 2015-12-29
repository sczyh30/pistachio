package org.samsara.pistachio.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Samsara Pistachio
 * Admin basic controller
 * @author sczyh30
 */
@Controller
public class AdminController {

    @RequestMapping(value = "adm1n666/index.freed0m")
    public String toIndex() {
        return "adm1n/index";
    }
}
