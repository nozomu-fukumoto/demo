package com.myintern.demo.entity;

import java.sql.Date;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CourseOfPregnancyEntity {
   
  private long id;
  private long serial_no;

  private Date exam_date;
  
  private int week_of_pregnancy_w;
  private int week_of_pregnancy_d;
  private double height_of_uterus;
  private double circumference_of_abdomen;
  private double weight_before_pregnancy;
  private double weight;
  private int blood_pressure_systolic;
  private int blood_pressure_diastolic;
  private int edema;
  private int protein_in_urine;
  private int sugar_in_urine;

  @NotEmpty(message = "名前を入力してください")
  private String other_examinations;

  private String special_notes;
  private String name_of_medical_institution_or_doctor;

}
