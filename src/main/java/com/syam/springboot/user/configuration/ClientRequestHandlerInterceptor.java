package com.syam.springboot.user.configuration;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
@Slf4j
public class ClientRequestHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getHeader("X-origin-app")==null) {
            response.sendError(500,"Header missing");
            return false;
        } else if(!(request.getHeader("host").equals("localhost:8080") && request.getHeader("X-origin-app").equals("test") ||
                request.getHeader("host").equals("localhost:3000") && request.getHeader("X-origin-app").equals("syamapp") ||
                request.getHeader("host").equals("localhost:3001/") && request.getHeader("X-origin-app").equals("syamapp") )) {
            response.sendError(404,"X-origin-app is not valid "+request.getHeader("X-origin-app"));
            return false;
        }


        return true;
    }
}
