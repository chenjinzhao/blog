package cn.chenjinzhao.blog.component;

import cn.chenjinzhao.blog.common.api.CommonResult;
import cn.chenjinzhao.blog.common.api.ResultCode;
import cn.chenjinzhao.blog.common.utils.CommonResultUtil;
import cn.chenjinzhao.blog.exception.GlobalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一在这个类中处理异常，全局拦截指定的异常
 *
 * @author 陈今朝
 * @date 2020/9/8 19:03
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandl {
    @ExceptionHandler(value = RuntimeException.class)  //申明捕获那个异常类
    @ResponseBody
    public CommonResult handle(Exception e) {
        if (e instanceof GlobalException) {
            GlobalException globalException = (GlobalException) e;
            return CommonResultUtil.error(globalException.getCode(), globalException.getMessage());
        }
        log.error("[系统异常]", e);
        return CommonResultUtil.error(ResultCode.UNKNOWN_ERROR);
    }

}
