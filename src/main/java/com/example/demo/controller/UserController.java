package com.example.demo.controller;


import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/login")
    public Result<User> loginController(@RequestParam String uname, @RequestParam String password) {
        User user = userService.loginService(uname, password);
        if (user != null) {
            return Result.success(user, "登录成功！",userService.createToken(uname));
        } else {
            return Result.error("123", "账号或密码错误！");
        }
    }

    @PostMapping("/register")
    public Result<User> registController(@RequestBody User newUser) {
        String errorCode = userService.registService(newUser);
        if (errorCode == null) {
            User user1 = userService.Pass(newUser);
            return Result.success(user1, "注册成功！",userService.createToken(newUser.getUname()));
        } else {
            if (errorCode.equals("用户名长度不能超过10位")) {
                return Result.error("456", "用户名长度不能超过10位！");
            } else if (errorCode.equals("用户名已存在")) {
                return Result.error("457", "用户名已存在！");
            } else if (errorCode.equals("用户名或密码为空")) {
                return Result.error("458", "用户名或密码为空！");
            } else return Result.error("123", "注册失败！");

        }
    }
}


