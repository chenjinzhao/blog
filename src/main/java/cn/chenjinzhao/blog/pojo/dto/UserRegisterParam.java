package cn.chenjinzhao.blog.pojo.dto;

import cn.chenjinzhao.blog.common.api.ResultCode;
import cn.chenjinzhao.blog.exception.GlobalException;
import cn.hutool.core.lang.Validator;
import lombok.Data;

/**
 * UserRegisterParam
 *
 * @author 陈今朝
 * @date 2020/9/8 17:28
 */
@Data
public class UserRegisterParam {
    private String email;
    private String nickname;
    private String password;
    private String avatars;

    /**
     * 校验
     * @throws Exception 参数校验失败抛出该异常
     */
    public void verify() throws Exception {
        // 邮箱
        if (Validator.isEmail(email)) {
            // 昵称:1-30位
            if (Validator.isGeneral(nickname,1,30)) {
                // TODO 密码格式验证与头像地址验证
                // 通过校验
                return;
            }
        }
        throw new GlobalException(ResultCode.VALIDATE_FAILED);
    }
}
