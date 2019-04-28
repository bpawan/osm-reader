package com.bpawan.dal.administrative.entity;

import com.bpawan.dal.entity.AuditModel;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "test_district")
public class District extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String englishName;

    private String nepaliName;

    private String normalizeName;
}
