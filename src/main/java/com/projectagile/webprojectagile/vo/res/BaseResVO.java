package com.projectagile.webprojectagile.vo.res;

import lombok.Data;

/**
 * Basic class of returned result
 * @param <T>
 */
@Data
public class BaseResVO<T> {

    private Integer code;

    private String message;

    private T data;
}
