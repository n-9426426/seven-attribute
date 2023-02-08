package com.tjetc.dao;

import com.tjetc.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * spring.com.tjetc.dao.UserMapper
 *
 * @author 张奥
 * @date 2023/01/16 星期一 15:47
 * @description
 */
@Repository
public interface UserMapper {
    List<User> list(@Param("name") String find);
    
    int del(@Param("id") int id);
    
    User findUserById(@Param("id") int id);
    
    int update(@Param("user") User user);
    
    int add(@Param("user") User user);
}
