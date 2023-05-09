package com.example.demo.service;

import com.example.demo.domain.User;

public interface UserService {
    /**
     * 登录业务逻辑
     * @param uname 账户名
     * @param password 密码
     * @return
     */
    User loginService(String uname, String password);

    /**
     * 注册业务逻辑
     * @param user 要注册的User对象，属性中主键uid要为空，若uid不为空可能会覆盖已存在的user
     * @return
     */
    String registService(User user);


    /**
     * 登录业务逻辑
     * @param uname 账户名
     * @param password 密码
     * @param token token
     * @return
     */
    User putService(String uname, String password, String token);



    /**
     * 登录业务逻辑
     * @param uname 账户名
     * @param password 密码
     * @param token token
     * @return
     */
    User deleteService(String uname, String password, String token);



    User loginPass(User user);

    User registPass(User user);

    User putPass(User user);

//    User deletePass(User user);



    String createToken(String uname);

}
