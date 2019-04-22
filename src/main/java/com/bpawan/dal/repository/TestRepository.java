package com.bpawan.dal.repository;

import com.bpawan.dal.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {
}
