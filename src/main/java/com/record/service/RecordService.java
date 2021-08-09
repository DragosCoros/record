package com.record.service;

import com.record.dto.Record;
import com.record.entity.RecordEntity;
import com.record.repository.RecordRepositoy;
import com.record.translator.RecordTranslator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
@Slf4j
public class RecordService {

    private RecordRepositoy recordRepositoy;

    public Record getRecord(Integer recordId){
        RecordEntity recordEntity = findById(recordId);
        return RecordTranslator.toDomain(recordEntity);
    }

    private RecordEntity findById(Integer recordId){
        return recordRepositoy.findById(recordId).orElseThrow(() -> new EntityNotFoundException("Missing Record with id : " + recordId));
    }

    @Transactional
    public Record addRecord(Record record) {
        if(recordRepositoy.existsById(record.getApplicationNumber())){
            throw new RuntimeException("Dublicate Record: = " + record.getApplicationNumber());
        }
        RecordEntity recordEntity = RecordTranslator.toEntity(record);
        RecordEntity saved = recordRepositoy.save(recordEntity);
        return RecordTranslator.toDomain(saved);
    }

    @Transactional
    public Record updateRecord(Record record) {
        RecordEntity existingRecordEntity = findById(record.getApplicationNumber());
        RecordEntity entityToSave = RecordTranslator.updateRecord(record, existingRecordEntity);
        RecordEntity saved = recordRepositoy.save(entityToSave);
        return RecordTranslator.toDomain(saved);
    }

    @Transactional
    public void deleteRecord(Integer recordId) {
        if(!recordRepositoy.existsById(recordId)){
            throw new EntityNotFoundException("Missing Record with id : " + recordId);
        }
        recordRepositoy.deleteById(recordId);
    }

    public List<Record> getAllRecords() {
        Iterable<RecordEntity> entities = recordRepositoy.findAll();
        return StreamSupport.stream(entities.spliterator(), false)
                .map(e -> RecordTranslator.toDomain(e))
                .collect(Collectors.toList());

    }
}
