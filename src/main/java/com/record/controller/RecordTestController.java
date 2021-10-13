package com.record.controller;

import com.record.dto.Record;
import com.record.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/recordTest")
public class RecordTestController {

    @GetMapping("/{recordTestName}")
    public String getRecord(@PathVariable String recordTestName){
        return "TEST Name: " + recordTestName;
    }

}
