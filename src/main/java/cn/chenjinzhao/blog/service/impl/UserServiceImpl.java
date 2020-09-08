package cn.chenjinzhao.blog.service.impl;

import cn.chenjinzhao.blog.common.api.ResultCode;
import cn.chenjinzhao.blog.common.utils.JwtUtil;
import cn.chenjinzhao.blog.exception.GlobalException;
import cn.chenjinzhao.blog.mapper.UserMapper;
import cn.chenjinzhao.blog.mapper.UserRoleMapper;
import cn.chenjinzhao.blog.pojo.dto.UserRegisterParam;
import cn.chenjinzhao.blog.pojo.po.User;
import cn.chenjinzhao.blog.pojo.po.UserRole;
import cn.chenjinzhao.blog.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * UserService 实现类
 *
 * @author 陈今朝
 * @date 2020/9/7 16:58
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    JwtUtil jwtUtil;

    @Override
    public User getUserByEmail(String email) {
        return baseMapper.selectByEmail(email);
    }

    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    @Override
    public void register(UserRegisterParam userParam,Integer roleId) throws Exception{
        // 检查是否有相同用户名或邮箱的用户
        User user = new User();
        // 密码加密
        userParam.setPassword(passwordEncoder.encode(userParam.getPassword()));
        BeanUtils.copyProperties(userParam,user);
        // 注册
        try {
            baseMapper.register(user);
            // 为其分配默认角色
            userRoleMapper.insert(new UserRole(user.getId(), roleId));
        }catch (Exception e){
            throw new GlobalException(ResultCode.REGISTRATION_FAIL);
        }
    }

    @Override
    public String login(String email, String password) {
        String token = null;
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(email);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            token = jwtUtil.generateToken(userDetails);
        }catch (AuthenticationException e) {
            log.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }

}
