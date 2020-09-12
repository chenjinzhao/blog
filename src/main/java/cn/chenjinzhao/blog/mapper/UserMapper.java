package cn.chenjinzhao.blog.mapper;

import cn.chenjinzhao.blog.pojo.dto.UserRegisterParam;
import cn.chenjinzhao.blog.pojo.po.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * UserMapper
 *
 * @author 陈今朝
 * @date 2020/9/7 17:00
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
    /**
     * 根据email查找user
     * @param email 邮箱
     * @return user
     */
    User selectByEmail(String email);

    /**
     * 注册
     * #{user.email},#{user.nickname},#{user.password},1,#{user.avatars},now(),now()
     * @param user 参数
     * @return 影响行数
     */
    int register(@Param("user") User user);
}
