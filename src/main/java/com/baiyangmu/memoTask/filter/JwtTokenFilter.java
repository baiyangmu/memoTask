package com.baiyangmu.memotask.filter;

import com.baiyangmu.memotask.config.UserContext;
import com.baiyangmu.memotask.entity.masterData.User;
import com.baiyangmu.memotask.service.masterData.UserService;
import com.baiyangmu.memotask.util.JwtTokenUtil;
import com.baiyangmu.memotask.util.RedisUtil;
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
        String email = getEmailFromToken(jwtToken, response);
        if (email == null) {
            return;
        }

        String serverToken = getServerToken(email, jwtToken, response);
        if (serverToken == null) {
            return;
        }

        User user = service.findByEmail(email);
        if (user == null) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid token");
            return;
        }
        UserContext.setUser(user);
        filterChain.doFilter(request, response);
    }


    private String getEmailFromToken(String jwtToken, HttpServletResponse response) throws IOException {
        String email;
        try {
            email = jwtTokenUtil.getEmailFromToken(jwtToken);
        } catch (Exception e) {
            logger.error("JWT token validation error", e);
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid token");
            return null;
        }
        return email;
    }


    private String getServerToken(String email, String jwtToken, HttpServletResponse response) throws IOException {
        String serverToken = (String) redisUtil.get(email);
        if (serverToken == null || !jwtTokenUtil.validateToken(jwtToken, serverToken)) {
            logger.warn("JWT Token validation failed");
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
            return null;
        }
        return serverToken;
    }


}
