package cn.chenjinzhao.blog.component;

import cn.chenjinzhao.blog.common.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * JWT登录授权过滤器
 * 在用户名和密码校验前添加的过滤器，
 * 如果请求中有jwt的token且有效，
 * 会取出token中的用户名，
 * 然后调用SpringSecurity的API进行登录操作。
 *
 * @author 陈今朝
 * @date 2020/9/7 14:33
 */
@Slf4j
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtUtil jwtUtil;


    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = httpServletRequest.getHeader(jwtUtil.getTokenHeader());
        if (authHeader!=null && authHeader.startsWith(jwtUtil.getTokenHead())){
            String authToken = authHeader.substring(jwtUtil.getTokenHead().length());
            String username = jwtUtil.getUserNameFromToken(authToken);
            log.info("checking username:{}",username);
            if (username != null && SecurityContextHolder.getContext().getAuthentication()==null){
                UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
                if (jwtUtil.validateToken(authToken, userDetails)) {
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                    log.info("authenticated user:{}", username);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
