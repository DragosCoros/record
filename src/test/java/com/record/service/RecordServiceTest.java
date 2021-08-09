package com.record.service;

import com.record.repository.RecordRepositoy;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.persistence.EntityNotFoundException;

import static org.mockito.Mockito.when;

public class RecordServiceTest{

    @Mock
    private RecordRepositoy repository;

    @InjectMocks
    private RecordService recordService;

    @Before
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test(expected = EntityNotFoundException.class)
    public void getRecord() {
        when(repository.findById(1)).thenThrow(new EntityNotFoundException());
        recordService.getRecord(1);
    }


/*    @Test
    void addRecord() {
    }

    @Test
    void updateRecord() {
    }

    @Test
    void deleteRecord() {
    }

    @Test
    void getAllRecords() {
    }*/
}