package com.record.controller;

import com.record.service.RecordService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.record.dto.Record;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class RecordControllerTest {

    @Mock
    private RecordService service;

    @InjectMocks
    private RecordController controller;

    @Before
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }

    public Record makeRecord(Integer number){
        Record record = new Record();
        record.setApplicationNumber(number);
        record.setManufacturerName("man1");
        record.setProductNumber("productN1");
        record.setSubstanceName("subs1");
        return record;
    }

    @Test
    public void testGetRecord_success(){
        Record record = makeRecord(1);
        when(service.getRecord(1)).thenReturn(record);
        ResponseEntity<Record> result = controller.getRecord(1);
        assertEquals(record, result.getBody());
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void testGetRecord_GetALL_success(){
        Record record = makeRecord(1);
        Record record1 = makeRecord(2);
        List<Record> list = Arrays.asList(record, record1);
        when(service.getAllRecords()).thenReturn(list);
        ResponseEntity<List<Record>> result = controller.getAllRecords();
        assertEquals(list, result.getBody());
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void testAddRecord(){
        //TO BE IMPLEMENTED
    }


    @Test
    public void testDeleteRecord(){
        //TO BE IMPLEMENTED
    }




}