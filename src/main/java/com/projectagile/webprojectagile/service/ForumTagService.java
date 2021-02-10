package com.projectagile.webprojectagile.service;

import com.projectagile.webprojectagile.entity.ForumTag;

import java.util.List;

public interface ForumTagService {
    List<ForumTag> findAllTags();
    ForumTag addTag(String forumTag);
}
