package com.tjetc.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.Accessors;

import java.sql.Date;

/**
 * spring.com.tjetc.domain.User
 *
 * @author 张奥
 * @date 2023/01/16 星期一 15:49
 * @description
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class User {
    private Integer id;
    
    private String name;
    
    private Integer age;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birthday;
    
    private String hobbies;
    
    private String sex;
    
    private String photopath;
}
