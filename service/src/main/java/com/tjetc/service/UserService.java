package com.tjetc.service;

import com.github.pagehelper.PageInfo;
import com.tjetc.domain.User;

/**
 * spring.com.tjetc.service.UserService
 *
 * @author 张奥
 * @date 2023/01/16 星期一 15:46
 * @description
 */
public interface UserService {
    PageInfo<User> list(String find, int curPage, int pageSize);
    
    boolean del(int id);
    
    User findUserById(int id);
    
    boolean update(User user);
    
    boolean add(User user);
}
