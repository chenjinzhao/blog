package cn.chenjinzhao.blog.service.impl;

import cn.chenjinzhao.blog.mapper.UserMapper;
import cn.chenjinzhao.blog.pojo.po.User;
import cn.chenjinzhao.blog.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * UserServiceImplTest
 *
 * @author 陈今朝
 * @date 2020/9/7 18:13
 */
@SpringBootTest
class UserServiceImplTest {
    @Autowired
    UserService userService;
    @Autowired(required = false)
    UserMapper userMapper;
    @Test
    void getByEmail(){
        User user = new User();
        user.setEmail("s1999@qq.com");
        System.out.println(
                userMapper.register(user)
        );
        System.out.println(user);
    }
}