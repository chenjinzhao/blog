package cn.chenjinzhao.blog.controller.open;

import cn.chenjinzhao.blog.common.api.CommonResult;
import cn.chenjinzhao.blog.common.api.ResultCode;
import cn.chenjinzhao.blog.common.utils.CommonResultUtil;
import cn.chenjinzhao.blog.common.utils.JwtUtil;
import cn.chenjinzhao.blog.pojo.dto.UserLoginParam;
import cn.chenjinzhao.blog.pojo.dto.UserRegisterParam;
import cn.chenjinzhao.blog.service.UserService;
import io.jsonwebtoken.Jwt;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * OpenUserController
 *
 * @author 陈今朝
 * @date 2020/9/7 20:52
 */
@RestController
@Slf4j
@Api(tags = "OpenUserController")
public class OpenUserController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtil jwtUtil;

    @ApiOperation(value = "用户注册")
    @PostMapping("/register")
    public CommonResult register(@RequestBody UserRegisterParam userParam) throws Exception {
        // 参数校验 失败抛出异常
        userParam.verify();
        // 参数校验通过 进行注册
        userService.register(userParam, 0);
        // 成功
        return CommonResultUtil.success();
    }

    @ApiOperation(value = "登录以后返回token")
    @PostMapping(value = "/login")
    @ExceptionHandler
    public CommonResult login(@RequestBody UserLoginParam userLoginParam) {
        String token = userService.login(userLoginParam.getEmail(), userLoginParam.getPassword());
        if (token == null) {
            return CommonResultUtil.error(ResultCode.LOGON_FAILURE);
        }
        Map<String, String> tokenMap = new HashMap<>(2);
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", jwtUtil.getTokenHead());
        return CommonResultUtil.success(tokenMap);
    }
}
