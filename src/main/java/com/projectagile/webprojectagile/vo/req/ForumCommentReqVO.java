package com.projectagile.webprojectagile.vo.req;

import com.projectagile.webprojectagile.entity.ForumComment;
import lombok.Data;

/**
 * Class pour requetes VO ForumComment
 * View Object permet de faciliter la récupération de données du front issues de requetes
 */

@Data
public class ForumCommentReqVO extends BaseReqVO {
    private ForumComment forumComment;
}
