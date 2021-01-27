package com.projectagile.webprojectagile.vo.req;

import com.projectagile.webprojectagile.entity.ForumSubject;
import lombok.Data;

import javax.validation.Valid;

@Data
public class ForumSubjectReqVO extends BaseReqVO{

    private ForumSubject forumSubject;
}
