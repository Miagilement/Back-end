package com.projectagile.webprojectagile.security;

import com.projectagile.webprojectagile.utils.JwtUtils;
import com.projectagile.webprojectagile.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class CustomLogoutHandler implements LogoutHandler {

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    RedisUtils redisUtils;

    @Override
    public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) {
        String jwt = parseJwt(httpServletRequest);
        if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
            String uid = jwtUtils.getUidFromJwtToken(jwt);
            if (redisUtils.hasKey(uid) && jwt.equals(redisUtils.get(uid))) {
                redisUtils.del(uid);
                log.info("user: {}  is offline now", uid);
            }
        }
    }

    private String parseJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");
        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7);
        }
        return null;
    }
}
