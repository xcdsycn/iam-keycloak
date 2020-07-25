package com.lxh.iam.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.github.dreamyoung.mprelation.InverseJoinColumn;
import com.github.dreamyoung.mprelation.JoinColumn;
import com.github.dreamyoung.mprelation.JoinTable;
import com.github.dreamyoung.mprelation.ManyToMany;
import com.lxh.iam.entity.Role;
import com.lxh.iam.mapper.UserRoleMapper;
import com.lxh.iam.utils.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author lxh
 * @since 2020-07-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserDto extends BaseEntity implements UserDetails {

    private static final long serialVersionUID = 1L;

    private String username;

    private String password;

    private transient List<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add( new SimpleGrantedAuthority( role.getName()));
        }
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
