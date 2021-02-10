package com.projectagile.webprojectagile.service.impl;

import com.projectagile.webprojectagile.dao.ForumTagDao;
import com.projectagile.webprojectagile.entity.ForumTag;
import com.projectagile.webprojectagile.service.ForumTagService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ForumTagServiceImpl implements ForumTagService {

    ForumTagDao forumTagDao;

    @Override
    public List<ForumTag> findAllTags() {
        return (List<ForumTag>) forumTagDao.findAll();
    }

    @Override
    public ForumTag addTag(String forumTag) {
        ForumTag tag = new ForumTag();
        tag.setTagName(forumTag);
        return forumTagDao.save(tag);
    }
}
