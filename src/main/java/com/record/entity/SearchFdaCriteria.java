package com.record.entity;

import lombok.Data;

@Data
public class SearchFdaCriteria {

    private Integer pagerNumber;
    private Integer pageSize;
    private String fdaManufacturerName;
    private String fdaBrandName;

}
