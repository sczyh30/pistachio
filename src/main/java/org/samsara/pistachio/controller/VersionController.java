package org.samsara.pistachio.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.samsara.pistachio.Constant.*;

/**
 * Samsara Pistachio
 * API version controller
 * @author sczyh30
 */
@RestController
public class VersionController {

    @RequestMapping(value = API_GET_VERSION)
    public String getVersion() {
        return API_VERSION;
    }
}
