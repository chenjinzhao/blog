package cn.chenjinzhao.blog.common.utils;

import cn.chenjinzhao.blog.common.api.IErrorCode;
import cn.chenjinzhao.blog.common.api.Result;
import cn.chenjinzhao.blog.common.api.ResultEnum;

/**
 * Result工具类
 *
 * @author 陈今朝
 * @date 2020/9/6 22:23
 */
public class ResultUtil {


    /**
     * 成功但不带数据
     *
     * @return  SuccessResult
     */
    public static Result success(){
        return success(null);
    }

    /**
     * 成功且带数据
     *
     * @return  SuccessResult
     */
    private static Result success(Object o) {
        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setData(o);
        return result;
    }

    /**
     * 根据IErrorCode创建错误
     *
     * @param error 错误类型
     * @return      ErrorResult
     */
    public static Result error(IErrorCode error){
        Result result = new Result();
        result.setCode(error.getCode());
        result.setMsg(error.getMsg());
        return result;
    }

    /**
     * 根据错误码和消息创建错误
     *
     * @param code  错误码
     * @param msg   消息
     * @return      ErrorResult
     */
    public static Result error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

}
