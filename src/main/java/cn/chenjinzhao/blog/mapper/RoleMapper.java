package cn.chenjinzhao.blog.mapper;

import cn.chenjinzhao.blog.pojo.po.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * RoleMapper
 *
 * @author 陈今朝
 * @date 2020/9/7 18:34
 */
@Repository
public interface RoleMapper extends BaseMapper<Role> {
    /**
     * 根据用户id查找角色集合
     * @param uid   用户id
     * @return      角色id集合
     */
    List<Integer> selectRidsByUid(Integer uid);
}
