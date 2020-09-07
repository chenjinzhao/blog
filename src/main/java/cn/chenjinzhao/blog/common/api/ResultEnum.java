package cn.chenjinzhao.blog.common.api;

import lombok.Data;

/**
 * Result枚举类
 *
 * @author 陈今朝
 * @date 2020/9/6 22:20
 */
public enum ResultEnum implements IErrorCode {
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    LOGON_FAILURE(401, "登陆失败"),
    FORBIDDEN(403, "没有相关权限"),
    ARTICLE_NOT_FOUND(404, "未找到该文章"),
    VALIDATE_FAILED(404, "参数验证失败");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
