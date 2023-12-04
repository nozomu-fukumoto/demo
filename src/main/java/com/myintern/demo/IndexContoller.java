package com.myintern.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myintern.demo.auth.CustomUserDetails;
import com.myintern.demo.entity.BasicInfomationEntity;
import com.myintern.demo.form.GetFormUserList;
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

  @GetMapping("/supporter/userlist")
  public String showUserList(Model model) {
    List<BasicInfomationEntity> userlist = basicInfomationMapper.findBasicAll();
    model.addAttribute("getForm", userManagement.initializeForm());
    model.addAttribute("userlist", userlist);
    return "authoritySupporters/userlist";
  }

  @RequestMapping("/supporter/userlist/search")
  public String searchUserList(Model model, @ModelAttribute GetFormUserList getFormUserList) {
    List<BasicInfomationEntity> searchUserList = basicInfomationMapper.searchBasic(getFormUserList);
    model.addAttribute("userlist", searchUserList);
    model.addAttribute("getForm", getFormUserList);
    return "authoritySupporters/userlist";
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
