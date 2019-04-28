package com.bpawan.dal.entity;

import com.bpawan.dal.types.PostgresHstoreType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Map;

@Entity
@TypeDef(name = "hstore", typeClass = PostgresHstoreType.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class District extends AuditModel {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Column(name = "vdc_count")
    private Integer numberOfVDCS;

    @Column(name = "municipality_count")
    private Integer numberOfMunicipalities;

    @Type(type = "hstore")
    @Column(columnDefinition = "hstore")
    private Map<String, String> features;
}
