package com.baiyangmu.memotask.util;


import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
public class JwtTokenUtil {

    // 从配置文件中获取密钥
    @Value("${jwt.secret}")
    private String secret;

    // 从配置文件中获取过期时间
    @Value("${jwt.expiration}")
    private Long expiration;

    // 生成token
    public String generateToken(String email) {
        // 设置token过期时间
        Date expirationDate = new Date(System.currentTimeMillis() + expiration * 1000);

        // 生成token
        String token = Jwts.builder()
                .setSubject(email)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();

        return token;
    }

    public String getEmailFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token , String serverToken) {
        return token.equals(serverToken);
    }


}
