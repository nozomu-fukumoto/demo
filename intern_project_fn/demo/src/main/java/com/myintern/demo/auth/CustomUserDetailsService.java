package com.myintern.demo.auth;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.myintern.demo.entity.UserEntity;
import com.myintern.demo.mapper.UserMapper;

@Service
public class CustomUserDetailsService implements UserDetailsService {
  
  @Autowired
  UserMapper userMapper;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserEntity user = userMapper.findByUsername(username);
    if(user == null) {
      throw new UsernameNotFoundException("not found : " + username);
    }
    return (new CustomUserDetails(user, getAuthorities(user)));
  }

  private Collection<GrantedAuthority> getAuthorities(UserEntity user) {
    if(user.getAuthority().equals("SUPPORTER")) {
      return AuthorityUtils.createAuthorityList("ROLE_SUPPORTER");
    } else if (user.getAuthority().equals("OFFICER")) {
      return AuthorityUtils.createAuthorityList("ROLE_OFFICER");
    } else {
      return AuthorityUtils.createAuthorityList("ROLE_USER");
    }
  }
}
