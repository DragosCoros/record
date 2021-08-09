package com.record.controller;

import com.record.dto.Record;
import com.record.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/record")
public class RecordController {

    private RecordService recordService;

    @Autowired
    public RecordController (RecordService recordService){
        this.recordService = recordService;
    }

    @GetMapping("/{recordId}")
    public ResponseEntity<Record> getRecord(@PathVariable Integer recordId){
        return new ResponseEntity<>(recordService.getRecord(recordId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Record> addRecord(@RequestBody Record record) {
        //validate Record if need it
        Record result = recordService.addRecord(record);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{recordId}")
    public ResponseEntity<Record> updateRecord(@RequestBody Record record, @PathVariable Integer recordId) {
        if(!record.getApplicationNumber().equals(recordId)){
            throw new RuntimeException("Record Id in the path Must Match id in the body");
        }
        return new ResponseEntity<>(recordService.updateRecord(record), HttpStatus.OK);

    }

    @DeleteMapping("/{recordId}")
    public ResponseEntity<Record> deleteRecord(@PathVariable Integer recordId){
        recordService.deleteRecord(recordId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Record>> getAllRecords(){
        return new ResponseEntity<>(recordService.getAllRecords(), HttpStatus.OK);
    }
}
