package cn.chenjinzhao.blog.exception;

import cn.chenjinzhao.blog.common.api.IErrorCode;

/**
 * 自定义异常信息类
 *
 * @author 陈今朝
 * @date 2020/9/8 19:38
 */
public class GlobalException extends RuntimeException{
    private Integer code;

    public GlobalException(IErrorCode iErrorCode) {
        this(iErrorCode.getMsg(), iErrorCode.getCode());
    }

    public GlobalException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
