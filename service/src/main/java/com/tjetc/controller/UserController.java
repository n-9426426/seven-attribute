package com.tjetc.controller;

import com.github.pagehelper.PageInfo;
import com.tjetc.domain.User;
import com.tjetc.service.UserService;
import com.tjetc.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.UUID;

/**
 * spring.com.tjetc.controller.UserController
 *
 * @author 张奥
 * @date 2023/01/17 星期二 21:05
 * @description
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    //文件保存路径
    private String path = "C:\\Users\\N_9426426\\Desktop\\tempTest";
    
    @Autowired
    public void setUserService(UserServiceImpl userServiceImpl) {
        this.userService = userServiceImpl;
    }
    @RequestMapping("/list")
    protected PageInfo<User> list(
            @RequestParam(defaultValue = "") String find,
            @RequestParam(defaultValue = "1") int curPage,
            @RequestParam(defaultValue = "3") int pageSize
    ) throws ServletException, IOException {
        return userService.list(find,curPage,pageSize);
    }
    @RequestMapping("/del")
    protected boolean del(@RequestParam int id) throws ServletException, IOException {
        return userService.del(id);
    }
    @RequestMapping("/findUserById")
    protected User findUserById(@RequestParam int id) throws ServletException, IOException {
        return userService.findUserById(id);
    }
    @RequestMapping( "/update")
    protected boolean update(MultipartFile photo,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] hobbiesArray = request.getParameterValues("hobby");
        User user = new User();
        user.setId(Integer.valueOf(request.getParameter("id")))
            .setName(request.getParameter("name"))
            .setAge(Integer.valueOf(request.getParameter("age")))
            .setBirthday(Date.valueOf(request.getParameter("birthday")))
            .setHobbies(String.join(",",hobbiesArray))
            .setSex(request.getParameter("sex"));
        if (photo!=null && photo.getSize() > 0){
            //获取文件名
            String fileName = photo.getOriginalFilename();
            //重命名
            fileName ="upload/" + UUID.randomUUID() + fileName.substring(fileName.lastIndexOf("."));
            //写文件保存本地
            photo.transferTo(new File(path,fileName));
            //数据库更新
            user.setPhotopath(fileName);
        }
        return userService.update(user);
    }
    @RequestMapping( "/add")
    protected boolean add(MultipartFile photo,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] hobbiesArray = request.getParameterValues("hobby");
        User user = new User();
        user.setName(request.getParameter("name"))
            .setAge(Integer.valueOf(request.getParameter("age")))
            .setBirthday(Date.valueOf(request.getParameter("birthday")))
            .setHobbies(String.join(",",hobbiesArray))
            .setSex(request.getParameter("sex"));
        //保存路径
        String path = "C:\\Users\\N_9426426\\Desktop\\tempTest";
        //获取文件名
        String fileName = photo.getOriginalFilename();
        //重命名
        fileName ="upload/" + UUID.randomUUID() + fileName.substring(fileName.lastIndexOf("."));
        //写文件保存本地
        photo.transferTo(new File(path,fileName));
        //数据库更新
        user.setPhotopath(fileName);
        return userService.add(user);
    }
}
