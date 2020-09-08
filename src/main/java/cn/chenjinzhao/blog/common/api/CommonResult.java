package cn.chenjinzhao.blog.common.api;

import lombok.Data;
import lombok.ToString;

/**
 * 通用Result类
 *
 * @author 陈今朝
 * @date 2020/9/6 22:16
 */
@Data
@ToString
public class CommonResult<T> {
    private Integer code;
    private String msg;
    private T data;
}
