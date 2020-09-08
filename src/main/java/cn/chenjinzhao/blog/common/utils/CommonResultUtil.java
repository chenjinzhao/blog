package cn.chenjinzhao.blog.common.utils;

import cn.chenjinzhao.blog.common.api.IErrorCode;
import cn.chenjinzhao.blog.common.api.CommonResult;
import cn.chenjinzhao.blog.common.api.ResultCode;

/**
 * Result工具类
 *
 * @author 陈今朝
 * @date 2020/9/6 22:23
 */
public class CommonResultUtil {


    /**
     * 成功但不带数据
     *
     * @return  SuccessResult
     */
    public static CommonResult success(){
        return success(null);
    }

    /**
     * 成功且带数据
     *
     * @return  SuccessResult
     */
    public static CommonResult success(Object o) {
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(ResultCode.SUCCESS.getCode());
        commonResult.setMsg(ResultCode.SUCCESS.getMsg());
        commonResult.setData(o);
        return commonResult;
    }

    /**
     * 根据IErrorCode创建错误
     *
     * @param error 错误类型
     * @return      ErrorResult
     */
    public static CommonResult error(IErrorCode error){
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(error.getCode());
        commonResult.setMsg(error.getMsg());
        return commonResult;
    }

    /**
     * 根据错误码和消息创建错误
     *
     * @param code  错误码
     * @param msg   消息
     * @return      ErrorResult
     */
    public static CommonResult error(Integer code, String msg){
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(code);
        commonResult.setMsg(msg);
        return commonResult;
    }

}
