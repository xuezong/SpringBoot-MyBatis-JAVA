package com.example.springbootdemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController  // @responseBody和@controller结合，controller表示接受处理前端传过来的请求
public class Hello {

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String hello() {
      return "Hello SpringBoot!!!";
    }

}
