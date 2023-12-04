package com.myintern.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.myintern.demo.entity.UserEntity;

@Mapper
public interface UserMapper {
  public UserEntity findByUsername(@Param("username") String username);

  public List<UserEntity> findAll();

  
}
