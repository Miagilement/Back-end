package com.projectagile.webprojectagile.vo.req;

import com.projectagile.webprojectagile.entity.ForumTag;
import lombok.Data;

import java.util.List;

@Data
public class TagReqVO {
    List<ForumTag> tagList;
}
