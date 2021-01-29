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


    private Key key = generateKey();

    public String generateToken(Authentication authentication) {

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        Long nowMillis = System.currentTimeMillis();
        Long expMillis = nowMillis + 1000*2592000;
        Date exp = new Date(expMillis);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(exp)
                .signWith(signatureAlgorithm, this.key)
                .compact();
    }


    public String getUserEmailFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(this.key).parseClaimsJws(token).getBody().getSubject();
    }

    private static SecretKey generateKey() {
        String stringKey = "projectagile";
        byte[] encodedKey = Base64.decodeBase64(stringKey);
        return new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(key).parseClaimsJws(authToken);
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
