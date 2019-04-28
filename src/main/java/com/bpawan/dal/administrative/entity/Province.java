package com.bpawan.dal.administrative.entity;

import com.bpawan.dal.entity.AuditModel;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Map;

@Entity
@Table(name = "province")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Province extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String englishName;

    @NotNull
    private String nepaliName;

    @NotNull
    private String normalizedName;

    @NotNull
    private String capitalCity;

    private String website;

    @NotNull
    private Integer districtCount;

    private Double area;

    private Integer areaRank;

    private ProvincePopulation provincePopulation;

    @Type(type = "hstore")
    @Column(columnDefinition = "hstore")
    private Map<String, String> features;
}


