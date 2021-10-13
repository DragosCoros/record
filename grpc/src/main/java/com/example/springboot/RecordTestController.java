package com.example.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/recordTest")
public class RecordTestController {

    @GetMapping("/{recordTestName}")
    public String getRecord(@PathVariable String recordTestName){
        return "TEST Name: " + recordTestName;
    }

}
