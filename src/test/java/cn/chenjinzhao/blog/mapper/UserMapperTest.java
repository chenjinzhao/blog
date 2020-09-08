package cn.chenjinzhao.blog.mapper;

import cn.chenjinzhao.blog.pojo.po.User;
import cn.hutool.core.lang.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * UserMapperTest
 *
 * @author 陈今朝
 * @date 2020/9/7 17:03
 */
@SpringBootTest
class UserMapperTest {
    @Autowired(required = false)
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        User user = userMapper.selectByEmail("990736382@qq.com");
        Assert.notNull(user);
        System.out.println(user);
    }
    @Test
    void register(){
        System.out.println(("----- register method test ------"));
        User user = new User();
        user.setId(1);
        user.setEmail(new Date().toString());
        user.setPassword("123456");
        System.out.println(
                userMapper.register(user)
        );
        System.out.println(user);
    }
}