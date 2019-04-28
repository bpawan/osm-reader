package com.bpawan.dal.administrative.repository;

import com.bpawan.dal.administrative.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProvinceRepository extends JpaRepository<Province, Long> {
}
