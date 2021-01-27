package com.projectagile.webprojectagile.dao;

import com.projectagile.webprojectagile.entity.ForumComment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ForumCommentDao extends CrudRepository<ForumComment, Integer> {

    @Query(value = "Select * from forum_comment as fc where fc.subject_id = ?1", nativeQuery = true)
    List<ForumComment> findCommentBySubjectId(int subjectId);
}
