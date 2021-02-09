package com.projectagile.webprojectagile.security.UserDetails;

import com.projectagile.webprojectagile.entity.Profile;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;

    private String uid;

    private String userEmail;

    private String userPassword;

    private boolean isEnable;

    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.userPassword;
    }

    @Override
    public String getUsername() {
        return this.userEmail;
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
        return this.isEnable;
    }

    public static UserDetailsImpl build(Profile profile) {
        List<GrantedAuthority> authorities = profile.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
                .collect(Collectors.toList());

        return new UserDetailsImpl(
                profile.getUid(),
                profile.getUserEmail(),
                profile.getUserPassword(),
                profile.isEnabled(),
                authorities);
    }
}
