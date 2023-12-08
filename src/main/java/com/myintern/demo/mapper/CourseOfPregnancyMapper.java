package com.myintern.demo.mapper;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.myintern.demo.entity.CourseOfPregnancyEntity;

@Mapper
public interface CourseOfPregnancyMapper {
  
  public List<CourseOfPregnancyEntity> selectCourse(@Param("serial_no") long serial_no);
  public List<CourseOfPregnancyEntity> selectCourseExamDate(@Param("serial_no") long serial_no);
  public List<CourseOfPregnancyEntity> selectCourseByExamDate(@Param("exam_date") Date exam_date);

  public List<CourseOfPregnancyEntity> selectCourseForEdit(@Param("id") long id);

  public void addCourse(CourseOfPregnancyEntity courseOfPregnancyEntity);

  public void updateCourse(CourseOfPregnancyEntity courseOfPregnancyEntity);
}
