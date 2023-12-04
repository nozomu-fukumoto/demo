package com.myintern.demo.entity;

import lombok.Data;

@Data
public class PregnancyHealthReferenceEntity{

  private long serial_no;
  private int height;
  private int weight;
  private double bmi;
  private int sickening_history_high_blood_pressure;
  private int sickening_history_kidney_disease;
  private int sickening_history_diabetes;
  private int sickening_history_pneumonia;
  private int sickening_history_cardiac_disease;
  private int sickening_history_thyroid;
  private int sickening_history_mental_disorder;
  private String sickening_history_other;
  private int infection_history_rubella;
  private int infection_history_measles;
  private int infection_history_chickenpox;
  private int surgery_history_flag;
  private String surgery_history_type;
  private String regular_use_drug;
  private String allergy_type;
  private int stress_flag;
  private int worry_flag;
  private String worry_other;
  private int smoking_flag;
  private String smoking_status;
  private String smoking_status_living_together_person;
  private int drinking_flag;
  private String drinking_status;
  private int partner_health_flag;
  private String partner_health_state;
}
