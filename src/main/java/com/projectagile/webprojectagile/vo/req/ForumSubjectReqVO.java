package com.projectagile.webprojectagile.vo.req;

import com.projectagile.webprojectagile.entity.ForumSubject;
import lombok.Data;

import javax.validation.Valid;

/**
 * Class pour requetes VO ForumSubject
 * View Object permet de faciliter la récupération de données du front issues de requetes
 */

@Data
public class ForumSubjectReqVO extends BaseReqVO{

    private ForumSubject forumSubject;
}
