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
            return Result.error("101", "账号或密码错误！");
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
                return Result.error("301", "用户名长度不能超过10位！");
            } else if (errorCode.equals("用户名已存在")) {
                return Result.error("302", "用户名已存在！");
            } else if (errorCode.equals("用户名或密码为空")) {
                return Result.error("303", "用户名或密码为空！");
            } else return Result.error("399", "注册失败！");

        }
    }

    @PutMapping("/ChangePassword")

    public Result<User> ChangePasswordController(@RequestParam String uname, @RequestParam String password, @RequestParam String token) {
        User user = userService.putService(uname, password, token);
        if (user.getPassword() != null) {
            return Result.success(user, "密码修改成功！");
        }
        else if(user.getUname().equals("token错误")) {
            return Result.error("401", "token错误！");
        }
        else if (user.getUname().equals("用户名不存在")) {
            return Result.error("402", "用户名不存在！");
        } else {
            return Result.error("499", "密码修改失败！");
        }
    }


    @DeleteMapping("/delete")
    public Result<User> deleteController(@RequestParam String uname,@RequestParam String password, @RequestParam String token) {
        User user = userService.deleteService(uname, password,token);
        if (user == null) {
            return Result.success(user, "删除成功！");
        }
        else if(user.getUname().equals("token错误")) {
            return Result.error("501", "token错误！");
        }
        else if (user.getUname().equals("账号或密码错误")) {
            return Result.error("502", "账号或密码错误！");
        } else {
            return Result.error("503", "删除失败！");
        }
    }
}


