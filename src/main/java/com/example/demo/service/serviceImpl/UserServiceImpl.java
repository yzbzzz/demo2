package com.example.demo.service.serviceImpl;

import com.example.demo.domain.User;
import com.example.demo.repository.UserDao;
import com.example.demo.service.UserService;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.Resource;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.UUID;


@Service
public class UserServiceImpl implements UserService {


    @Resource
    private UserDao userDao;
    private static final long time=1000*60*60*24;

    @Override
    public User loginService(String uname, String password) {

        // 如果账号密码都对则返回登录的用户对象，若有一个错误则返回null
        User user = userDao.findByUnameAndPassword(uname, password);
        // 重要信息置空
        if (user != null) {
            user.setPassword("");
        }
        return user;
    }

    @Override
    public String registService(User user) {
        String username = user.getUname();
        String password = user.getPassword();
        if (username == null || password == null) {
            return "用户名或密码为空";
        }
        String errorMsg;
        //当新用户的用户名已存在时
        if (userDao.findByUname(user.getUname()) != null) {
            errorMsg = "用户名已存在";
            if (username.length() > 10) {
                errorMsg = "用户名长度不能超过10位";
                return errorMsg;
                // 无法注册
            }return errorMsg;
        }
        else return null;
    }

    public User Pass(User user) {
        //返回创建好的用户对象(带uid)
        User newUser = userDao.save(user);
        newUser.setPassword("");

        return newUser;
    }

    public  String createToken(String uname){
        JwtBuilder jwtBuilder= Jwts.builder();
        return jwtBuilder
                //header
                .setHeaderParam("typ","JWT")
                .setHeaderParam("alg","HS256")
                //payload
                .claim("username",uname)
                .claim("role","123456")
                .setSubject("admin-test")
                .setExpiration(new Date(System.currentTimeMillis()+time))
                .setId(UUID.randomUUID().toString())
                //signature
                .signWith(generalKey())
                .compact();
    }

    public static SecretKey generalKey(){
        byte[] encodedKey = Base64.decodeBase64("cuAihCz53DZRjSwabsGcZJ2Ai6At+T142updateJMsk7iQ=");//自定义
        return Keys.hmacShaKeyFor(encodedKey);
    }






}

