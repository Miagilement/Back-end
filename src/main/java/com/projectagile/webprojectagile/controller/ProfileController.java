package com.projectagile.webprojectagile.controller;

import java.util.List;

import com.projectagile.webprojectagile.entity.Profile;
import com.projectagile.webprojectagile.enums.ResultEnum;
import com.projectagile.webprojectagile.service.impl.ProfileServiceImpl;
import com.projectagile.webprojectagile.utils.ResultVOUtils;
import com.projectagile.webprojectagile.vo.req.ProfileRegisterReqVO;
import com.projectagile.webprojectagile.vo.res.BaseResVO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Le controleur recoit les requêtes du front-end
 */

@RestController
@RequestMapping("/info/particulier")
// Pour chaque controleur, il faut copier le AllArgsConstructor tel quel
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProfileController {
    
    ProfileServiceImpl particulierService;

    @PostMapping("/find-all-particulier")
    public BaseResVO findAllParticulier(){
        List<Profile> profileList = particulierService.findAllProfile();
        if(profileList != null){
            return ResultVOUtils.success(profileList);
        } else {
            return ResultVOUtils.error(ResultEnum.PARAM_VERIFY_FALL);
        }
    }

    //le uid est récupéré dans l'url pour le renvoyer au front-end
    @PostMapping("/find-by-id/{uid}")
    public BaseResVO findParticulierById(@PathVariable String uid){
        Profile profile = particulierService.findProfileById(uid);
        if(profile != null){
            return ResultVOUtils.success(profile);
        } else {
            return ResultVOUtils.error(ResultEnum.PARAM_VERIFY_FALL);
        }
    }

    @PostMapping("/update-user-info")
    public BaseResVO updateUserInfo(@RequestBody ProfileRegisterReqVO profileRegisterReqVO){
        Profile profile = particulierService.updateUserInfo(profileRegisterReqVO.getProfile());
        if(profile != null){
            return ResultVOUtils.success(profile);
        } else {
            return ResultVOUtils.error(ResultEnum.PARAM_VERIFY_FALL);
        }
    }
}
