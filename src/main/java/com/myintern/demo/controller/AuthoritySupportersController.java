package com.myintern.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myintern.demo.entity.BasicInfomationEntity;
import com.myintern.demo.entity.CourseOfPregnancyEntity;
import com.myintern.demo.mapper.BasicInfomationMapper;
import com.myintern.demo.mapper.CourseOfPregnancyMapper;

@Controller
public class AuthoritySupportersController {
  
  @Autowired
  CourseOfPregnancyMapper courseOfPregnancyMapper;
  @Autowired
  BasicInfomationMapper basicInfomationMapper;

  @GetMapping("/supporter/userlist/editablelist/{serial_no}")
  public String showSupportersPage(Model model, @PathVariable long serial_no) {
    List<BasicInfomationEntity> basicInfomation = basicInfomationMapper.findBasicBySerialno(serial_no);
    model.addAttribute("basicInfomation", basicInfomation);
    return "/authoritySupporters/editablelistpage";
  }

  @GetMapping("/supporter/userlist/editablelist/{serial_no}/courseOfPregnancy")
  public String showCourseOfPregnancy(Model model, @PathVariable long serial_no) {
    List<CourseOfPregnancyEntity> courseList = courseOfPregnancyMapper.selectCourse(serial_no);
    model.addAttribute("courseList", courseList);
    model.addAttribute("serial_no", serial_no);
    return "/authoritySupporters/courseOfPregnancySup";
  }

  @GetMapping("/supporter/userlist/editablelist/{serial_no}/addCourseOfPregnancy")
  public String showAddCoursePage(Model model, @PathVariable long serial_no) {
    model.addAttribute("serial_no", serial_no);
    model.addAttribute("infoMessage", "初期処理完了");
    return "/authoritySupporters/addCourseOfPregnancy";
  }
  
  @RequestMapping("/supporter/userlist/editablelist/courseOfPregnancy/add")
  public String AddCourseOfPregnancy(Model model, @Validated CourseOfPregnancyEntity courseOfPregnancyEntity, BindingResult result) {
    long serial_no = courseOfPregnancyEntity.getSerial_no();
    if (result.hasErrors()) {
        List<String> errorList = new ArrayList<String>();
        for (ObjectError error : result.getAllErrors()) {
            errorList.add(error.getDefaultMessage());
        }
        model.addAttribute("validationError", errorList);
        return "/authoritySupporters/addCourseOfPregnancy";
    }
    courseOfPregnancyMapper.addCourse(courseOfPregnancyEntity);
    return "redirect:/supporter/userlist/editablelist/" + serial_no + "/courseOfPregnancy";
  }

  @GetMapping("/supporter/userlist/editablelist/{serial_no}/updateCourseOfPregnancy")
  public String showUpdateCoursePage(Model model, @PathVariable long serial_no) {
    List<CourseOfPregnancyEntity> editCourseList = courseOfPregnancyMapper.selectCourse(serial_no);
    model.addAttribute("editCourseList", editCourseList);
    model.addAttribute("infoMessage", "初期処理完了");
    return "/authoritySupporters/editCourseOfPregnancy";
  }

  @RequestMapping("/supporter/userlist/editablelist/courseOfPregnancy/update")
  public String AddCourseOfPregnancy(Model model, @Validated CourseOfPregnancyEntity courseOfPregnancyEntity) {
    long serial_no = courseOfPregnancyEntity.getSerial_no();
    courseOfPregnancyMapper.updateCourse(courseOfPregnancyEntity);
    return "redirect:/supporter/userlist/editablelist/" + serial_no + "/courseOfPregnancy";
  }
}
