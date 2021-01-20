package com.projectagile.webprojectagile.dao;

import com.projectagile.webprojectagile.entity.Enterprise;
import com.projectagile.webprojectagile.entity.ForumSubject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ForumSubjectDao extends CrudRepository <ForumSubject, Integer> {
}
