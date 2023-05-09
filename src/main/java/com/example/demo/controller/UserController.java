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
            return Result.success(user, "登录成功！");
        } else {
            return Result.error("123", "账号或密码错误！");
        }
    }

    @PostMapping("/register")
    public Result<User> registController(@RequestBody User newUser) {
        String errorCode = userService.registService(newUser);
        if (errorCode == null) {
            User user1 = userService.registPass(newUser);
            return Result.success(user1, "注册成功！");
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

    @PutMapping("/ChangePassword")

    public Result<User> ChangePasswordController(@RequestParam String uname, @RequestParam String password, @RequestParam String token) {
        User user = userService.putService(uname, password, token);
        if (user.getPassword() != null) {
            return Result.success(user, "密码修改成功！");
        }
        else if(user.getUname().equals("token错误")) {
            return Result.error("400", "token错误！");
        }
        else if (user.getUname().equals("用户名不存在")) {
            return Result.error("401", "用户名不存在！");
        } else {
            return Result.error("402", "密码修改失败！");
        }
    }
}


