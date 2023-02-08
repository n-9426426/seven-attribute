import com.tjetc.dao.UserMapper;
import com.tjetc.service.UserService;
import com.tjetc.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * spring.PACKAGE_NAME.GetBeanTest
 *
 * @author 张奥
 * @date 2023/01/16 星期一 16:31
 * @description
 */
@SpringJUnitConfig(locations = "classpath:applicationContext.xml")
public class GetBeanTest {
    private UserService userService;
    private UserMapper userMapper;
    @Autowired
    public void setUserService(UserServiceImpl userServiceImpl) {
        this.userService = userServiceImpl;
    }
    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    
    @Test
    public void getUserService(){
        //System.out.format("userService = %s\n", userService.list("张",1,3));
        System.out.format("mapper = %s\n", userMapper);
        //mapper.list("张");
    }
}
