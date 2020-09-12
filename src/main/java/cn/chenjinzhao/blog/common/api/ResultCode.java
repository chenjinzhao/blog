package cn.chenjinzhao.blog.common.api;

/**
 * Result枚举类
 *
 * @author 陈今朝
 * @date 2020/9/6 22:20
 */
public enum ResultCode implements IErrorCode {
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限"),
    ARTICLE_NOT_FOUND(404, "未找到该文章"),
    VALIDATE_FAILED(404, "参数验证失败"),
    REGISTRATION_FAIL(10001,"注册失败"),
    LOGON_FAILURE(40001, "登陆失败"),
    USER_IS_NOT_ENABLE(40002, "用户未启用"),
    UNKNOWN_ERROR(50000,"未知错误");

    private Integer code;
    private String msg;

    ResultCode(Integer code, String msg) {
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
