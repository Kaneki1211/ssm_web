package com.cl.dao;

import com.cl.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    //插入数据
    @Insert("insert into userinfo(username , password)values(#{username},#{password})")
    void saveUser(User user);

    //根据名字查询
    @Select("select * from userinfo where username=#{username}")
    User findByName(String username);
}
