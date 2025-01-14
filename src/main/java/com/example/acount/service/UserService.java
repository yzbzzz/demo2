package com.example.acount.service;

import com.example.acount.domain.User;

public interface UserService {
    /**
     * 登录业务逻辑
     * @param uname 账户名
     * @param password 密码
     */
    User loginService(String uname, String password);

    /**
     * 注册业务逻辑
     * @param user 要注册的User对象，属性中主键uid要为空，若uid不为空可能会覆盖已存在的user
     */
    String registService(User user);


    /**
     * 修改账号/密码业务逻辑
     * @param uname 账户名
     * @param password 密码
     * @param token token
     */
    User putService(String uname, String password, String token);



    /**
     * 删除账号业务逻辑
     * @param uname 账户名
     * @param password 密码
     * @param token token
     */
    User deleteService(String uname, String password, String token);



    User loginPass(User user);

    User registPass(User user);

    User putPass(User user);

//    User deletePass(User user);



    String createToken(String uname);

}
