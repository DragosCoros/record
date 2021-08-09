package com.record.controller;

import com.record.entity.SearchFdaCriteria;
import com.record.service.FdaRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/fda")
public class DrugRecordApiController {

    private FdaRecordService fdaRecordService;

    @Autowired
    public DrugRecordApiController(FdaRecordService fdaRecordService){
        this.fdaRecordService = fdaRecordService;
    }

    @PostMapping("/search")
    public ResponseEntity<String> getRecord(@RequestBody SearchFdaCriteria criteria){
        return new ResponseEntity<String>(fdaRecordService.searchFdaRecords(criteria.getFdaManufacturerName(), criteria.getPageSize()), HttpStatus.OK);
    }
}
