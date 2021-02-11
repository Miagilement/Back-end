package com.projectagile.webprojectagile.dao;

import com.projectagile.webprojectagile.entity.ForumTag;
import org.springframework.data.repository.CrudRepository;

public interface ForumTagDao extends CrudRepository<ForumTag, Long> {
    ForumTag findByTagName(String tagName);

}
