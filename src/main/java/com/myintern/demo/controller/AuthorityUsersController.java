package com.myintern.demo.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.myintern.demo.entity.PregnancyHealthReferenceEntity;
import com.myintern.demo.entity.CourseOfPregnancyEntity;
import com.myintern.demo.mapper.CourseOfPregnancyMapper;
import com.myintern.demo.mapper.PregnancyHealthReferenceMapper;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AuthorityUsersController {
  
  @Autowired
  PregnancyHealthReferenceMapper pregnancyHealthReferenceMapper;
  @Autowired
  CourseOfPregnancyMapper courseOfPregnancyMapper;

  @GetMapping(value= "/mypage/{serial_no}/authorityUsers/pregnancyHealthReference")
  public String showHealthPage(Model model, @PathVariable long serial_no) {
    List<PregnancyHealthReferenceEntity> heathStatusList = pregnancyHealthReferenceMapper.findHealthStatus(serial_no);
    model.addAttribute("heathStatusList", heathStatusList);
    model.addAttribute("serial_no", serial_no);
    return "authorityUsers/pregnancyHealthReference";
  }

  @GetMapping(value= "/mypage/{serial_no}/authorityUsers/editPregnancyHealthReference")
  public String showEditHealthPage(Model model, @PathVariable long serial_no) {
    List<PregnancyHealthReferenceEntity> editHeathStatusList = pregnancyHealthReferenceMapper.findHealthStatus(serial_no);
    model.addAttribute("editHeathStatusList", editHeathStatusList);
    return "authorityUsers/editPregnancyHealthReference";
  }

  // 妊婦の健康状態更新処理
  @RequestMapping(value="/authorityUsers/editPregnancyHealthReference/update")
  public String updateHealthPage(PregnancyHealthReferenceEntity pregnancyHealthReferenceEntity) {
    pregnancyHealthReferenceMapper.updateHealthStatus(pregnancyHealthReferenceEntity);
    long serial_no = pregnancyHealthReferenceEntity.getSerial_no();
    return "redirect:/mypage/" + serial_no + "/authorityUsers/pregnancyHealthReference";
  }
 
  @GetMapping(value= "/mypage/{serial_no}/authorityUsers/addPregnancyHealthReference")
  public String showAddHealthPage(@PathVariable long serial_no) {
    return "authorityUsers/addPregnancyHealthReference";
  }

  @RequestMapping(value="/authorityUsers/addPregnancyHealthReference/add")
  public String addHealthPage(PregnancyHealthReferenceEntity pregnancyHealthReferenceEntity) {
    pregnancyHealthReferenceMapper.addHealthStatus(pregnancyHealthReferenceEntity);
    long serial_no = pregnancyHealthReferenceEntity.getSerial_no();
    return "redirect:/mypage/" + serial_no + "/authorityUsers/pregnancyHealthReference";
  }  

  @GetMapping(value= "/mypage/{serial_no}/authorityUsers/courseOfPregnancyPre")
  public String showCoursePrePage(Model model, @PathVariable long serial_no) {
    List<CourseOfPregnancyEntity> courseDateList = courseOfPregnancyMapper.selectCourseExamDate(serial_no);
    model.addAttribute("courseDateList", courseDateList);
    model.addAttribute("serial_no", serial_no);
    return "authorityUsers/courseOfPregnancyPre";
  }

  @GetMapping(value= "/mypage/{serial_no}/authorityUsers/courseOfPregnancy/{exam_date}")
  public String showCoursePage(Model model, @PathVariable long serial_no, @PathVariable Date exam_date) {
    List<CourseOfPregnancyEntity> courseList = courseOfPregnancyMapper.selectCourseByExamDate(exam_date);
    model.addAttribute("courseList", courseList);
    model.addAttribute("serial_no", serial_no);
    return "authorityUsers/courseOfPregnancy";
  }
}