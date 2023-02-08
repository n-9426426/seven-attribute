package com.tjetc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tjetc.dao.UserMapper;
import com.tjetc.domain.User;
import com.tjetc.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * spring.com.tjetc.service.impl.UserServiceImpl
 *
 * @author 张奥
 * @date 2023/01/16 星期一 15:46
 * @description
 */
@Service
@Transactional(rollbackFor = Exception.class, timeout = 1000)
@MapperScan("com.tjetc.dao")
public class UserServiceImpl implements UserService{
    private UserMapper userMapper;
    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    
    @Override
    public boolean add(User user) {
        return userMapper.add(user) > 0;
    }
    
    @Override
    public boolean update(User user) {
        return userMapper.update(user) > 0;
    }
    
    @Override
    public User findUserById(int id) {
        return userMapper.findUserById(id);
    }
    
    @Override
    public boolean del(int id) {
        return userMapper.del(id) > 0;
    }
    
    @Override
    public PageInfo<User> list(String find, int curPage, int pageSize) {
        try(Page<User> ignore = PageHelper.startPage(curPage,pageSize)){
            List<User> list = userMapper.list(find);
            return new PageInfo<>(list);
        }
    }
}
