package com.projectagile.webprojectagile.handler;

import com.projectagile.webprojectagile.enums.ResultEnum;
import com.projectagile.webprojectagile.utils.ResultVOUtils;
import com.projectagile.webprojectagile.vo.res.BaseResVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = RuntimeException.class)
    public BaseResVO handlerRuntimeException(RuntimeException e) {
        log.error(e.getMessage());
        // return the corresponded error
        return ResultVOUtils.error(ResultEnum.NOT_NETWORK);
    }

//    @ExceptionHandler(value = Exception.class)
//    public BaseResVO handlerException(Exception e) {
//        log.error(e.getMessage());
//        // return the corresponded error
//        return ResultVOUtils.error(ResultEnum.NOT_NETWORK);
//    }
}
