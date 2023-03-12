package com.baiyangmu.memotask.filter;

import com.baiyangmu.memotask.service.UserService;
import com.baiyangmu.memotask.util.JwtTokenUtil;
import com.baiyangmu.memotask.util.RedisUtil;
import com.baiyangmu.memotask.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class JwtTokenFilter extends OncePerRequestFilter {


    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private UserService service;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String path = request.getRequestURI();
        if (path != null && (path.contains("/user/login") || path.contains("/user/registeredUser"))) {
            filterChain.doFilter(request, response);
            return;
        }

        final String requestTokenHeader = request.getHeader("Authorization");

        if (requestTokenHeader == null || !requestTokenHeader.startsWith("Bearer ")) {
            logger.warn("JWT Token does not begin with Bearer String");
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
            return;
        }

        String jwtToken = requestTokenHeader.substring(7);
        String email = null;
        try {
             email = jwtTokenUtil.getEmailFromToken(jwtToken);
            // continue with the request
        } catch (Exception e) {
            logger.error("JWT token validation error", e);
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid token");
            return;
        }


        String serverToken = null;

        if (email == null) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
            return;
        }
        serverToken = (String) redisUtil.get(email);


        if (serverToken == null || !jwtTokenUtil.validateToken(jwtToken, serverToken)) {
            logger.warn("JWT Token validation failed");
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
            return;
        }


        UserVo userVo = service.findByEmail(email);
        if (userVo != null) {
            request.setAttribute("user", userVo);
        }

        filterChain.doFilter(request, response);
    }
}
