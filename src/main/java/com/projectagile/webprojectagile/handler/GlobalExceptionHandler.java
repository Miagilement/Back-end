package com.projectagile.webprojectagile.handler;

import com.projectagile.webprojectagile.enums.ResultEnum;
import com.projectagile.webprojectagile.utils.ResultVOUtils;
import com.projectagile.webprojectagile.vo.res.BaseResVO;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = RuntimeException.class)
    public BaseResVO handlerRuntimeException(RuntimeException e) {
        log.error(e.toString());
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
    public BaseResVO handlerMethodArgumentNotValid(MethodArgumentNotValidException e) {
        log.warn(e.getMessage());
        List<String> listError = new ArrayList<String>();
        e.getFieldErrors().forEach(fieldError -> {
            listError.add(fieldError.getDefaultMessage());
        });
        return ResultVOUtils.error(ResultEnum.PARAM_VERIFY_FALL, listError);
    }


    @ExceptionHandler(value = NoSuchElementException.class)
    public BaseResVO handlerNoSuchElementException(NoSuchElementException e) {
        log.error(e.getMessage());
        return ResultVOUtils.error(ResultEnum.DATA_NOT);
    }

    @ExceptionHandler(value = InternalAuthenticationServiceException.class)
    public BaseResVO handlerInternalAuthenticationServiceException(InternalAuthenticationServiceException e) {
        log.error(e.getMessage());
        return ResultVOUtils.error(ResultEnum.USER_NOT);
    }

    @ExceptionHandler(value = BadCredentialsException.class)
    public BaseResVO handlerBadCredentialsException(BadCredentialsException e){
        log.warn(e.getMessage());
        return ResultVOUtils.error(ResultEnum.USER_WRONG);
    }

    @ExceptionHandler(value = DisabledException.class)
    public BaseResVO handlerDisabledException(DisabledException e){
        log.warn(e.getMessage());
        return ResultVOUtils.error(ResultEnum.USER_EMAIL_NOT);
    }

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public BaseResVO handlerDataIntegrityViolationException(DataIntegrityViolationException e){
        log.warn(e.getMessage());
        return ResultVOUtils.error(ResultEnum.DATA_REPEAT);
    }
}
