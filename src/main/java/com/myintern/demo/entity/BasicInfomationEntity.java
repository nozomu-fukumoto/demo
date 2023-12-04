package com.myintern.demo.entity;

import java.sql.Date;

import lombok.Data;

@Data
public class BasicInfomationEntity{

  private long serial_no;
  private String username;
  private Date issue_date_ymd;
  private String guardian_name;
  private String guardian_name_kana;
  private String child_name;
  private String child_name_kana;
  private String order_of_birth;
  private Date birthdate_ymd;
  private String sex;

}

