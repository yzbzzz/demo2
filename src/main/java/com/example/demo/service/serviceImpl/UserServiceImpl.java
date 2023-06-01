package com.example.demo.service.serviceImpl;

import com.example.demo.domain.User;
import com.example.demo.domain.User_log;
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
        User user = userDao.findByUnameAndPassword(uname, password);
        if (user != null) {
            return loginPass(user);
        } else {
            return null;
        }
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

    @Override
    public User putService(String uname,String password,String token) {
       User user = userDao.findByUname(uname);
        User errorUser = new User();
       if(user!=null){
           if(user.getToken().equals(token)){
               user.setPassword(password);
               return putPass(user);
           }
           else errorUser.setUname("token错误");
           return errorUser;
       }
       else errorUser.setUname("用户名不存在");
       return errorUser;
    }


    @Override
    public User deleteService(String uname,String password, String token) {
        User user = userDao.findByUnameAndPassword(uname,password);
        User errorUser = new User();
        if(user!=null){
            if(user.getToken().equals(token)){
                userDao.delete(user);
                return null;
            }
            else errorUser.setUname("token错误");
            return errorUser;
        }
        else errorUser.setUname("账号或密码错误");
        return errorUser;
    }



    @Override
    public User loginPass(User user) {
        //返回创建好的用户对象(带uid)
        User_log user_log = new User_log(user.getUid(),user.getUname(),"登录",System.currentTimeMillis()/ 1000);
        String token = createToken(user.getUname());
        user.setToken(token);
        User newUser = userDao.save(user);
        userDao.save(user_log);
        newUser.setPassword("");
        newUser.setToken(token);
        return newUser;
    }
    @Override
    public User registPass(User user) {
        //返回创建好的用户对象(带uid)
        String token = createToken(user.getUname());
        user.setToken(token);
        User newUser = userDao.save(user);
        User_log user_log = new User_log(user.getUid(),user.getUname(),"注册",System.currentTimeMillis()/ 1000);
        userDao.save(user_log);
        newUser.setPassword("");
        newUser.setToken(token);
        return newUser;
    }
    @Override
    public User putPass(User user) {
        //返回创建好的用户对象(带uid)
        User newUser = userDao.save(user);
        newUser.setPassword("");
        newUser.setToken("");
        return newUser;
    }
//    @Override
//    public User deletePass(User user) {
//        //返回创建好的用户对象(带uid)
//        User newUser = userDao.save(user);
//        newUser.setPassword("");
//
//        return newUser;
//    }
    @Override
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

