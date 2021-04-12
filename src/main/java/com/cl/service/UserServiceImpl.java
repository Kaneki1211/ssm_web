package com.cl.service;

import com.cl.dao.UserDao;
import com.cl.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    /**
     * 注册
     * @param user
     * @return 注册成功(用户名没有重复)返回true 否则false
     */
    @Override
    public boolean userRegister(User user) {
        User userReg = userDao.findByName(user.getUsername());
        if(userReg==null) {
            userDao.saveUser(user);
            System.out.println("注册成功！");
            return true;
        }else {
            System.out.println("注册失败！用户名重复！");
            return false;
        }
    }

    /**
     * 登录
     * @param user
     * @return 登录成功返回true失败返回false
     */
    @Override
    public boolean userLogin(User user) {
        User userLog = userDao.findByName(user.getUsername());
        if(userLog == null) {
            System.out.println("用户名密码错误!");
            return false;
        }
        if(userLog.getPassword().equals(user.getPassword())) {
            System.out.println("登录成功！");
            return true;
        }else {
            System.out.println("用户名密码错误！");
            return false;
        }
    }
}
