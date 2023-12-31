package com.myintern.demo.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

import com.myintern.demo.entity.UserEntity;

public class CustomUserDetails implements UserDetails{
	private final UserEntity user;
	private final Collection<GrantedAuthority> authorities;
	
	public CustomUserDetails(UserEntity user, Collection<GrantedAuthority> authorities) {
		this.user = user;
		this.authorities = authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		return this.user.getUsername();
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
