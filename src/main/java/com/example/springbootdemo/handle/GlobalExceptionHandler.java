package com.example.springbootdemo.handle;

import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: GlobalExceptionHandler
 * @Description:
 * @Author: XWZ
 * @Date: 2018-11-24 21:50
 * @Version 1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 用于接受处理所有的Exception，针对不同的异常，做不同的处理
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    private Map<String, Object> exceptionHandler(HttpServletRequest request, Exception e) {
        Map<String, Object> modelMap = new HashMap<>(16);
        modelMap.put("success", false);
        modelMap.put("errMsg", e.getMessage());
        return modelMap;
    }
}
