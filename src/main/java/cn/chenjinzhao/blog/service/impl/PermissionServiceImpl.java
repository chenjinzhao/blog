package cn.chenjinzhao.blog.service.impl;

import cn.chenjinzhao.blog.mapper.PermissionMapper;
import cn.chenjinzhao.blog.mapper.RoleMapper;
import cn.chenjinzhao.blog.mapper.UserMapper;
import cn.chenjinzhao.blog.pojo.po.Permission;
import cn.chenjinzhao.blog.pojo.po.User;
import cn.chenjinzhao.blog.service.PermissionService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * PermissionServiceImpl
 *
 * @author 陈今朝
 * @date 2020/9/7 18:33
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

    @Autowired(required = false)
    PermissionMapper permissionMapper;
    @Autowired(required = false)
    RoleMapper roleMapper;


    @Override
    public List<Permission> getPermissionList(Integer userId) {
        List<Integer> rids = roleMapper.selectRidsByUid(userId);
        List<Permission> permissionList = permissionMapper.selectByRids(rids);
        return permissionList;
    }
}
