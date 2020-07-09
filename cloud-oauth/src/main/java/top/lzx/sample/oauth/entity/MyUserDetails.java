package top.lzx.sample.oauth.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @Author: colin
 * @Date: 2019/3/14 11:18
 * @Description:
 * @Version: V1.0
 */
@Data
public class MyUserDetails implements UserDetails {

    private final String name;
    private final String password;
    private final Collection<? extends GrantedAuthority> authorities;

    public MyUserDetails(
            String name,
            String password,
            Collection<? extends GrantedAuthority> authorities
    ) {
        this.name = name;
        this.password = password;
        this.authorities = authorities;
    }

    @Override
    public String getUsername() {
        return name;
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
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
