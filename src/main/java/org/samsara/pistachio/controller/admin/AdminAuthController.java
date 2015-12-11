package org.samsara.pistachio.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Samsara Pistachio
 * Admin Auth Controller
 * @author sczyh30
 */
@Controller
public class AdminAuthController {

    @RequestMapping(value = "adm1n233/auth")
    public String toAuth() {
        return "adm1n/auth";
    }

    @RequestMapping(value = "adm1n233/auth.freed0m")
    public String auth(HttpServletRequest request) {
        return "adm1n/auth";
    }
}
