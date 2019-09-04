package com.example.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("index")
    public String index() {
        logger.info("--------------hello world");
        return "index";
    }

    @RequestMapping("login")
    public String login(String username, String password) {
        logger.info("----------login----------" + username);
        if (username == null || password == null) {
            return "index";
        }
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            logger.info("---------------user:" + username + "登录成功");
            return "success";
        } catch (Exception e) {
            logger.error("-----------登录验证失败：", e);
        }
        return "index";
    }
}