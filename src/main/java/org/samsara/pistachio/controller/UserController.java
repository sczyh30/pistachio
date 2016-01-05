package org.samsara.pistachio.controller;

import org.samsara.pistachio.entity.RequestError;
import org.samsara.pistachio.entity.User;
import org.samsara.pistachio.entity.UserToken;
import org.samsara.pistachio.security.TokenGenerator;
import org.samsara.pistachio.service.IUserAuthService;
import org.samsara.pistachio.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import static org.samsara.pistachio.Constant.*;

/**
 * Samsara Pistachio
 * User process controller
 * @author sczyh30
 */
@RestController
public class UserController {

    @Resource
    IUserAuthService service;

    @Resource
    UserService userService;

    /**
     * Route of login
     * @param username username
     * @param password password
     * @param request HttpRequest object
     * @return the json object
     */
    @RequestMapping(value = API_LOGIN, method = RequestMethod.POST)
    public Object login(@RequestParam(value = "username") String username,
                        @RequestParam(value = "password") String password,
                        HttpServletRequest request) {
        //TODO: Decouple this validation logic
        if(request.getSession().getAttribute("temp_token") != null)
            return new RequestError(API_LOGIN_DUPLICATE, "login_duplicate", API_LOGIN);
        // login logic
        if(service.login(username, password)) {
            User user = userService.getUser(username);
            if(user != null) {
                request.getSession().setAttribute("user", user);
                String token = TokenGenerator.generate(user.getBorrowId(), 7899);
                request.getSession().setAttribute("temp_token", token);
                return new UserToken(API_LOGIN_SUCCESS, token, user);
            }
        }
        return new RequestError(API_LOGIN_FAIL, "login_fail_not_correct", API_LOGIN);
    }

    @RequestMapping(value = API_LOGOUT, method = RequestMethod.POST)
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        request.getSession().removeAttribute("temp_token");
        return "logout_success";
    }

    @RequestMapping(value = "/api/user/{uid}", method = RequestMethod.GET)
    public Object getUserTest(@PathVariable(value = "uid") int uid) {
        return userService.getUserById(uid);
    }

}
