package com.projectagile.webprojectagile.controller;

import com.projectagile.webprojectagile.enums.ResultEnum;
import com.projectagile.webprojectagile.security.UserDetails.UserDetailsImpl;
import com.projectagile.webprojectagile.utils.JwtUtils;
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

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserLoginController {

    JwtUtils jwtUtils;

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

    @PostMapping("/login")
    public BaseResVO login(@RequestBody UserLoginReqVO userLoginReqVO){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userLoginReqVO.getUserEmail(), userLoginReqVO.getUserPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println(authentication.getPrincipal());
        String jwt = jwtUtils.generateToken(authentication);

//        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//        List<String> roles = userDetails.getAuthorities().stream()
//                .map(item -> item.getAuthority())
//                .collect(Collectors.toList());
        return ResultVOUtils.success(jwt);

    }
}
