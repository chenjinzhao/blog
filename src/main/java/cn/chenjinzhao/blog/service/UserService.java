package cn.chenjinzhao.blog.service;

import cn.chenjinzhao.blog.pojo.dto.UserRegisterParam;
import cn.chenjinzhao.blog.pojo.po.Permission;
import cn.chenjinzhao.blog.pojo.po.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * UserService
 *
 * @author 陈今朝
 * @date 2020/9/7 14:39
 */
public interface UserService  extends IService<User> {
    /**
     * 根据邮箱获取用户对象
     * @param email 邮箱
     * @return 用户对象
     */
    User getUserByEmail(String email);

    /**
     * 注册
     *
     * @param userParam 用户参数
     * @param roleId 注册用户默认角色
     * @return 注册用户
     */
    void register(UserRegisterParam userParam,Integer roleId) throws Exception;

    /**
     * 登录
     *
     * @param email     用户传入邮箱
     * @param password  用户传入密码
     * @return JwtToken
     */
    String login(String email, String password);
}
