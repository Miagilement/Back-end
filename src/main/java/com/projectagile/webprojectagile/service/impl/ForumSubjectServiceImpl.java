package com.projectagile.webprojectagile.service.impl;

import com.projectagile.webprojectagile.dao.ForumSubjectDao;
import com.projectagile.webprojectagile.entity.Enterprise;
import com.projectagile.webprojectagile.entity.ForumSubject;
import com.projectagile.webprojectagile.service.ForumSubjectService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ForumSubjectServiceImpl implements ForumSubjectService {

    ForumSubjectDao forumSubjectDao;

    @Override
    public List<ForumSubject> findAllForumSubject(){
        return (List<ForumSubject>) forumSubjectDao.findAll();
    }
}
