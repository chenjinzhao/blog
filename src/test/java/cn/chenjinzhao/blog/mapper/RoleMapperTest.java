package cn.chenjinzhao.blog.mapper;

import cn.chenjinzhao.blog.pojo.po.Permission;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * RoleMapperTest
 *
 * @author 陈今朝
 * @date 2020/9/7 18:55
 */
@SpringBootTest
class RoleMapperTest {
    @Autowired(required = false)
    PermissionMapper permissionMapper;
    @Autowired(required = false)
    RoleMapper roleMapper;

    @Test
    void selectRidsByUid() {
        List<Integer> admin = roleMapper.selectRidsByUid(1);
        List<Integer> test = roleMapper.selectRidsByUid(8);
        System.out.println(admin);
        System.out.println(test);
        System.out.println(permissionMapper.selectByRids(admin));
    }
}