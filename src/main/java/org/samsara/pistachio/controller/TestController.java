package org.samsara.pistachio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Samsara Pistachio init test
 * @author sczyh30
 */
@Controller
@RequestMapping("/")
public class TestController {
    @RequestMapping(method = RequestMethod.GET)
    public String showMessage(ModelMap model) {
        model.addAttribute("message", "Fucking Scala!");
        return "index";
    }
}
