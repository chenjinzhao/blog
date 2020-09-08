package cn.chenjinzhao.blog.service;

import cn.chenjinzhao.blog.pojo.po.Permission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * PermissionService
 *
 * @author 陈今朝
 * @date 2020/9/7 18:33
 */
public interface PermissionService extends IService<Permission> {
    /**
     * 根据用户id获取该用户所有权限
     * @param userId 用户id
     * @return 权限集合
     */
    List<Permission> getPermissionList(Integer userId);
}
