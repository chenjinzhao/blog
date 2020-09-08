package cn.chenjinzhao.blog.pojo.dto;

import cn.chenjinzhao.blog.pojo.po.Permission;
import cn.chenjinzhao.blog.pojo.po.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * UserDetails 实现类
 *
 * @author 陈今朝
 * @date 2020/9/7 16:47
 */
public class UserDetailsImpl implements UserDetails {
    private User user;
    private List<Permission> permissionList;

    public UserDetailsImpl(User user, List<Permission> permissionList) {
        this.user = user;
        this.permissionList = permissionList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回当前用户的权限
        return permissionList.stream()
                .filter(permission -> permission.getPermissionName()!=null)
                .map(permission ->new SimpleGrantedAuthority(permission.getPermissionName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    /**
     * @return 帐户是否过期
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * @return 帐户是否被冻结
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    /**
     * @return 帐户密码是否过期，一般有的密码要求性高的系统会使用到，比较每隔一段时间就要求用户重置密码
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    /**
     * @return 帐号是否可用
     */
    @Override
    public boolean isEnabled() {
        return user.getEnabled().equals(1);
    }
}
