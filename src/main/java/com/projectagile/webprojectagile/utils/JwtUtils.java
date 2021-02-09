package com.projectagile.webprojectagile.utils;

import com.projectagile.webprojectagile.security.UserDetails.UserDetailsImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import io.jsonwebtoken.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;

/**
 * jwt
 */
@Slf4j
@Component
public class JwtUtils {



    public String generateToken(Authentication authentication) {

        Key key = generateKey();

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        Long nowMillis = System.currentTimeMillis();
        Long expMillis = nowMillis + 1000*1296000;
        Date exp = new Date(expMillis);

        System.out.println(new Date());
        System.out.println(exp);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject(userDetails.getUid())
                .setIssuedAt(new Date())
                .setExpiration(exp)
                .signWith(signatureAlgorithm, key)
                .compact();
    }



    public String getUidFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(generateKey()).parseClaimsJws(token).getBody().getSubject();
    }

    private static SecretKey generateKey() {
        String stringKey = "projectagile";
        byte[] encodedKey = Base64.decodeBase64(stringKey);
        return new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(generateKey()).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            log.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            log.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            log.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty: {}", e.getMessage());
        }
        return false;
    }
}
