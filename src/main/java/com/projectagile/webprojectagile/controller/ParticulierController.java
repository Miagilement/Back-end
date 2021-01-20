package com.projectagile.webprojectagile.controller;

import java.util.List;

import com.projectagile.webprojectagile.entity.Particulier;
import com.projectagile.webprojectagile.enums.ResultEnum;
import com.projectagile.webprojectagile.service.impl.ParticulierServiceImpl;
import com.projectagile.webprojectagile.utils.ResultVOUtils;
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
public class ParticulierController {
    
    ParticulierServiceImpl particulierService;

    @PostMapping("/find-all-particulier")
    public BaseResVO findAllParticulier(){
        List<Particulier> particulierList = particulierService.findAllParticulier();
        if(particulierList != null){
            return ResultVOUtils.success(particulierList);
        } else {
            return ResultVOUtils.error(ResultEnum.PARAM_VERIFY_FALL);
        }
    }

    //le uid est récupéré dans l'url pour le renvoyer au front-end
    @PostMapping("/find-by-id/{uid}")
    public BaseResVO findParticulierById(@PathVariable String uid){
        Particulier particulier = particulierService.findByIdParticulier(uid);
        if(particulier != null){
            return ResultVOUtils.success(particulier);
        } else {
            return ResultVOUtils.error(ResultEnum.PARAM_VERIFY_FALL);
        }
    }
}
