package com.projectagile.webprojectagile.controller;

import com.projectagile.webprojectagile.enums.ResultEnum;
import com.projectagile.webprojectagile.utils.ResultVOUtils;
import com.projectagile.webprojectagile.vo.res.BaseResVO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserLoginController {


    @PostMapping("/logout-success")
    public BaseResVO logoutSuccess() {
        return ResultVOUtils.success(null);
    }

    @GetMapping("/login-error")
    public BaseResVO notLoginWarning() {
        return ResultVOUtils.error(ResultEnum.AUTH_FAILED);
    }
}
