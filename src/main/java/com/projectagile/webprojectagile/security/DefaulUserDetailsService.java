package com.projectagile.webprojectagile.security;

import com.projectagile.webprojectagile.dao.EnterpriseDao;
import com.projectagile.webprojectagile.dao.IndividualDao;
import com.projectagile.webprojectagile.entity.Enterprise;
import com.projectagile.webprojectagile.entity.Individual;
import com.projectagile.webprojectagile.security.UserDetails.UserDetailsImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DefaulUserDetailsService implements UserDetailsService {

    private EnterpriseDao enterpriseDao;
    private IndividualDao individualDao;

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        if (userEmail.isEmpty()) {
            log.info("User：{} does not exist", userEmail);
            throw new UsernameNotFoundException("User：" + userEmail + " does not exist");
        }
        Enterprise enterprise = this.enterpriseDao.findByUserEmailOrSiret(userEmail, null);
        if(enterprise!=null){
            return UserDetailsImpl.build(enterprise);
        } else {
            Individual individual = this.individualDao.findByUserEmail(userEmail);
            return UserDetailsImpl.build(individual);
        }
    }
}
