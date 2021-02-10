package com.projectagile.webprojectagile.controller;

import com.projectagile.webprojectagile.entity.UserLoginInfo;
import com.projectagile.webprojectagile.enums.ResultEnum;
import com.projectagile.webprojectagile.security.UserDetails.UserDetailsImpl;
import com.projectagile.webprojectagile.utils.JwtUtils;
import com.projectagile.webprojectagile.utils.RedisUtils;
import com.projectagile.webprojectagile.utils.ResultVOUtils;
import com.projectagile.webprojectagile.vo.req.UserLoginReqVO;
import com.projectagile.webprojectagile.vo.res.BaseResVO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Controleur pour la connexion des entreprises et particuliers
 * Le controleur recoit les requetes du front et renvoie des réponses
 * Ici : reception des requetes relatives aux formulaire de connexion
 */

@RestController
@RequestMapping("/user")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserLoginController {

    JwtUtils jwtUtils;

    RedisUtils redisUtils;

    AuthenticationManager authenticationManager;

    @PostMapping("/logout-success")
    public BaseResVO logoutSuccess() {
        return ResultVOUtils.success(null);
    }

    @PostMapping("/login-error")
    public BaseResVO notLoginWarning() {
        return ResultVOUtils.error(ResultEnum.AUTH_FAILED);
    }

    @PostMapping( "/login-success")
    public BaseResVO loginSuccess() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        System.out.println(principal);
        return ResultVOUtils.success(null);
    }

    @PostMapping( "/login-failure")
    public BaseResVO loginFailure() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        System.out.println(principal);
        return ResultVOUtils.error(ResultEnum.USER_WRONG);
    }

    @PostMapping("/login-timeout")
    public BaseResVO loginTimeout() {
        return ResultVOUtils.error(ResultEnum.LOGIN_TIMEOUT);
    }

    @PostMapping("/login")
    public BaseResVO login(@RequestBody UserLoginReqVO userLoginReqVO){
        userLoginReqVO.setUserEmail(userLoginReqVO.getUserEmail().toLowerCase());
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userLoginReqVO.getUserEmail(), userLoginReqVO.getUserPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        System.out.println(authentication);
        String jwt = jwtUtils.generateToken(authentication);
        System.out.println(jwtUtils.getUidFromJwtToken(jwt));
        System.out.println();
        redisUtils.set(userDetails.getUid(), jwt, 1296000);
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        return ResultVOUtils.success(new UserLoginInfo(userDetails.getUid(), userDetails.getUsername(), jwt, roles));
    }

}

