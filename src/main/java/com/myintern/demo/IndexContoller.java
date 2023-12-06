package com.myintern.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.myintern.demo.auth.CustomUserDetails;
import com.myintern.demo.entity.BasicInfomationEntity;
import com.myintern.demo.form.UserManagement;
import com.myintern.demo.mapper.BasicInfomationMapper;

@Controller
public class IndexContoller {

  @Autowired
  BasicInfomationMapper basicInfomationMapper;

  @Autowired
  UserManagement userManagement;
  
  @GetMapping("/")
  public String index(Model model, @AuthenticationPrincipal CustomUserDetails customUserDetails) {
    List<BasicInfomationEntity> basicInfomation = basicInfomationMapper.findBasic(customUserDetails.getUsername());
    model.addAttribute("basicInfomation", basicInfomation);
    return "index";
  }

  @GetMapping("/mypage/{serial_no}")
  public String showMypage(Model model, @PathVariable long serial_no) {
    List<BasicInfomationEntity> basicInfomation = basicInfomationMapper.findBasicBySerialno(serial_no);
    model.addAttribute("basicInfomation", basicInfomation);
    return "mypage";
  }

  @GetMapping("/login")
  public String showLoginForm() {
    return "login";
  }

  @GetMapping("/logout")
  public String showLogoutForm() {
    return "logout";
  } 
}
