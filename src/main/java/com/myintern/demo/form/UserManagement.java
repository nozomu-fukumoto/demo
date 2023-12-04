package com.myintern.demo.form;

import org.springframework.stereotype.Service;

@Service
public class UserManagement {

  public GetFormUserList initializeForm() {
    GetFormUserList form = new GetFormUserList();
    return form;
  }
}
