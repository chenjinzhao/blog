package cn.chenjinzhao.blog.mapper;

import cn.chenjinzhao.blog.pojo.po.Permission;
import cn.chenjinzhao.blog.pojo.po.Role;
import cn.chenjinzhao.blog.pojo.po.RolePermission;
import cn.chenjinzhao.blog.pojo.po.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * PermissionMapper
 *
 * @author 陈今朝
 * @date 2020/9/7 18:34
 */
public interface PermissionMapper extends BaseMapper<Permission> {
    /**
     * 根据角色查找权限
     *
     * @param rids 角色id
     * @return 权限集合
     */
    List<Permission> selectByRids(@Param("rids") List<Integer> rids);

}

