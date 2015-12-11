package org.samsara.pistachio.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Samsara Pistachio
 * Admin Interceptor
 * @author sczyh30
 * @since 0.1.42
 */
public class AdminInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object auth_key_s = request.getSession().getAttribute("auth_key");
        if(auth_key_s != null) {
            //if((String)auth_key_s.equals())
            return super.preHandle(request, response, handler);
        }
        response.sendRedirect("../adm1n233/auth");
        System.out.println("test -> haha");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
