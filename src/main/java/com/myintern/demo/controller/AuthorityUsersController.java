package com.myintern.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.myintern.demo.entity.PregnancyHealthReferenceEntity;
import com.myintern.demo.mapper.PregnancyHealthReferenceMapper;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AuthorityUsersController {
  
  @Autowired
  PregnancyHealthReferenceMapper pregnancyHealthReferenceMapper;

  @GetMapping(value= "/mypage/{serial_no}/authorityUsers/pregnancyHealthReference")
  public String showHealthPage(Model model, @PathVariable long serial_no) {
    List<PregnancyHealthReferenceEntity> heathStatusList = pregnancyHealthReferenceMapper.findHealthStatus(serial_no);
    model.addAttribute("heathStatusList", heathStatusList);
    return "/authorityUsers/pregnancyHealthReference";
  }

  @GetMapping(value= "/mypage/{serial_no}/authorityUsers/editPregnancyHealthReference")
  public String showEditHealthPage(Model model, @PathVariable long serial_no) {
    List<PregnancyHealthReferenceEntity> editHeathStatusList = pregnancyHealthReferenceMapper.findHealthStatus(serial_no);
    model.addAttribute("editHeathStatusList", editHeathStatusList);
    return "/authorityUsers/editPregnancyHealthReference";
  }

  // 妊婦の健康状態更新処理
  @RequestMapping(value="/authorityUsers/editPregnancyHealthReference/update")
  public String updateHealthPage(PregnancyHealthReferenceEntity pregnancyHealthReferenceEntity) {
    pregnancyHealthReferenceMapper.updateHealthStatus(pregnancyHealthReferenceEntity);
    long serial_no = pregnancyHealthReferenceEntity.getSerial_no();
    return "redirect:/mypage/" + serial_no + "/authorityUsers/pregnancyHealthReference";
  }
  
}