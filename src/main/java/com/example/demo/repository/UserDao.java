package com.example.demo.repository;

import com.example.demo.domain.User;
import com.example.demo.domain.User_log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface UserDao extends JpaRepository<User, Long> {
        User findByUname(String uname); //通过用户名uname查找用户，注意要按照JPA的格式使用驼峰命名法
        User findByUnameAndPassword(String uname, String password);//通过用户名uname和密码查找用户

        User deleteByUname(String uname);//通过用户名删除用户

        User_log save(User_log user_log);
    }


