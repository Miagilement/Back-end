package com.projectagile.webprojectagile.utils;

import com.projectagile.webprojectagile.enums.ResultEnum;
import com.projectagile.webprojectagile.vo.res.BaseResVO;


/**
 * Util class for BaseResVO
 */
public class ResultVOUtils {

    /**
     * Return successfully with data
     * @param data
     * @return
     */
    public static BaseResVO success(Object data) {
        BaseResVO<Object> baseResVO = new BaseResVO<>();
        baseResVO.setCode(0);
        baseResVO.setMessage("success");
        baseResVO.setData(data);
        return baseResVO;
    }

    /**
     * Return customized error
     * @param code
     * @param message
     * @return
     */
    public static BaseResVO error(Integer code, String message) {
        BaseResVO<Object> baseResVO = new BaseResVO<>();
        baseResVO.setCode(code);
        baseResVO.setMessage(message);
        return baseResVO;
    }


    /**
     * Return defined error
     * @param resultEnum
     * @return
     */
    public static BaseResVO error(ResultEnum resultEnum) {
        return error(resultEnum.getCode(), resultEnum.getMessage());
    }


    /**
     * Return defined error with customized message
     * @param resultEnum
     * @param message
     * @return
     */
    public static BaseResVO error(ResultEnum resultEnum, String message) {
        return error(resultEnum.getCode(), message);
    }


    /**
     * Return default error
     * @return
     */
    public static BaseResVO error() {
        return error(ResultEnum.NOT_NETWORK);
    }

}
