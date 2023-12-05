package com.myintern.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.myintern.demo.entity.PregnancyHealthReferenceEntity;

@Mapper
public interface PregnancyHealthReferenceMapper {
  public List<PregnancyHealthReferenceEntity> findHealthStatus(long serial_no);

  // 妊婦の健康状態更新(UPDATE)
  public void updateHealthStatus(PregnancyHealthReferenceEntity pregnancyHealthReferenceEntity);

  // 妊婦の健康状態更新(INSERT)
  public void addHealthStatus(PregnancyHealthReferenceEntity pregnancyHealthReferenceEntity);
  
}
