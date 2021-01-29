package com.projectagile.webprojectagile.controller;

import com.projectagile.webprojectagile.entity.Role;
import com.projectagile.webprojectagile.entity.TestClass;
import com.projectagile.webprojectagile.enums.ResultEnum;
import com.projectagile.webprojectagile.service.impl.RoleServiceImpl;
import com.projectagile.webprojectagile.utils.ResultVOUtils;
import com.projectagile.webprojectagile.vo.res.BaseResVO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/role")
// Pour chaque controleur, il faut copier le AllArgsConstructor tel quel
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RoleController {

    private RoleServiceImpl roleService;

    @PostMapping("/insert-role/{roleName}")
    public BaseResVO addRole(@PathVariable String roleName){
        Role role = new Role();
        role.setRoleName(roleName);
        return ResultVOUtils.success(roleService.insertRole(role));
    }
}
