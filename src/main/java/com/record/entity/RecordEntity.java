package com.record.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "Record")
public class RecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ApplicationNumber")
    private Integer applicationNumber;

    @Column(name = "ManufacturerName")
    private String manufacturerName;

    @Column(name = "SubstanceName")
    private String substanceName;

    @Column(name = "ProductNumber")
    private String productNumber;

}
