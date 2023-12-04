package com.myintern.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.myintern.demo.entity.BasicInfomationEntity;
import com.myintern.demo.form.GetFormUserList;

@Mapper
public interface BasicInfomationMapper {
  public List<BasicInfomationEntity> findBasic(@Param("username") String username);

  public List<BasicInfomationEntity> findBasicBySerialno(@Param("serial_no") long serial_no);

  public List<BasicInfomationEntity> findBasicAll();

  public List<BasicInfomationEntity> searchBasic(GetFormUserList getFormUserList);  
}
