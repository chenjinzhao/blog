package cn.chenjinzhao.blog.pojo.dto;

import lombok.Data;

/**
 * 用户登录传入参数
 *
 * @author 陈今朝
 * @date 2020/8/24 18:44
 */
@Data
public class UserLoginParam {
    private String email;
    private String password;
}