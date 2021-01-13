package com.projectagile.webprojectagile.handler;

import com.projectagile.webprojectagile.enums.ResultEnum;
import com.projectagile.webprojectagile.utils.ResultVOUtils;
import com.projectagile.webprojectagile.vo.res.BaseResVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;


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

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public BaseResVO handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
        log.warn(e.getMessage());
        List<String> listError = new ArrayList<String>();
        e.getFieldErrors().forEach(fieldError -> {
            listError.add(fieldError.getDefaultMessage());
        });
        return ResultVOUtils.error(ResultEnum.PARAM_VERIFY_FALL, listError);
    }
}
