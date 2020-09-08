package cn.chenjinzhao.blog.config;

import cn.chenjinzhao.blog.common.api.ResultCode;
import cn.chenjinzhao.blog.component.JwtAuthenticationTokenFilter;
import cn.chenjinzhao.blog.component.RestAuthenticationEntryPoint;
import cn.chenjinzhao.blog.component.RestfulAccessDeniedHandler;
import cn.chenjinzhao.blog.exception.GlobalException;
import cn.chenjinzhao.blog.pojo.dto.UserDetailsImpl;
import cn.chenjinzhao.blog.pojo.po.Permission;
import cn.chenjinzhao.blog.pojo.po.User;
import cn.chenjinzhao.blog.service.PermissionService;
import cn.chenjinzhao.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

/**
 * Spring Security 配置类
 *
 * @author 陈今朝
 * @date 2020/9/7 14:07
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    RestfulAccessDeniedHandler restfulAccessDeniedHandler;
    @Autowired
    RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Autowired
    UserService userService;
    @Autowired
    private PermissionService permissionService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        // 获取登录用户信息
        return email -> {
            User user = userService.getUserByEmail(email);
            if (user != null) {
                List<Permission> permissionList = permissionService.getPermissionList(user.getId());
                return new UserDetailsImpl(user, permissionList);
            }
            throw new UsernameNotFoundException("邮箱或密码错误");
        };
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/static/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 跨域请求会先进行一次options请求
                .antMatchers(HttpMethod.OPTIONS)
                .permitAll()
                // 对后台请求需要鉴权认证
                .antMatchers("/admin/**"
                        , "/user/**"
                )
                .authenticated();
        // JWT，不需要session
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        // 禁用缓存
        http.headers().cacheControl();
        // 禁用csrf
        http.csrf().disable();
        // 添加JWT filter
        http.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        //添加自定义未授权和未登录结果返回
        http.exceptionHandling()
                .accessDeniedHandler(restfulAccessDeniedHandler)
                .authenticationEntryPoint(restAuthenticationEntryPoint);
    }

    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() {
        return new JwtAuthenticationTokenFilter();
    }
}
