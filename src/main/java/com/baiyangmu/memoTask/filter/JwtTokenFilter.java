//package com.baiyangmu.memotask.filter;
//
//import com.baiyangmu.memotask.entity.User;
//import com.baiyangmu.memotask.service.UserService;
//import com.baiyangmu.memotask.util.JwtTokenUtil;
//import com.baiyangmu.memotask.util.RedisUtil;
//import com.baiyangmu.memotask.vo.UserVo;
//import io.jsonwebtoken.ExpiredJwtException;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Slf4j
//@Component
//public class JwtTokenFilter extends OncePerRequestFilter {
//
//
//    @Autowired
//    private JwtTokenUtil jwtTokenUtil;
//
//    @Autowired
//    private RedisUtil redisUtil;
//
//    @Autowired
//    private UserService service;
//
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//
//
//        final String requestTokenHeader = request.getHeader("Authorization");
//
//
//        String email = null;
//        String jwtToken = null;
//
//        if(requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")){
//            jwtToken = requestTokenHeader.substring(7);
//            try{
//                email = jwtTokenUtil.getEmailFromToken(jwtToken);
//            }catch (IllegalArgumentException e){
//                logger.error("Unable to get JWT Token");
//            }catch (ExpiredJwtException e){
//                logger.error("JWT Token has expired");
//            }
//
//        }else {
//            logger.warn("JWT Token does not begin with Bearer String");
//        }
//        String serverToken = null;
//        if(email != null){
//           serverToken = (String) redisUtil.get(email);
//        }
//
//        if(jwtTokenUtil.validateToken(jwtToken , serverToken)) {
//            UserVo userVo = service.findByEmail(email);
//
//            if (userVo != null) {
//                request.setAttribute("user", userVo);
//            }
//        }
//        else{
//            logger.warn("JWT Token validation failed");
//        }
//
//        filterChain.doFilter(request,response);
//    }
//}
