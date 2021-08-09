package com.record.translator;

import com.record.entity.RecordEntity;
import com.record.dto.Record;

public class RecordTranslator {

    public static RecordEntity toEntity (Record record){
        return toEntity(record, new RecordEntity());
    }

    public static RecordEntity toEntity(Record record, RecordEntity recordEntity){
        if(record == null) {
            return null;
        }
        recordEntity.setApplicationNumber(record.getApplicationNumber());
        recordEntity.setProductNumber(record.getProductNumber());
        recordEntity.setManufacturerName(record.getManufacturerName());
        recordEntity.setSubstanceName(record.getSubstanceName());

        return recordEntity;
    }

    public static Record toDomain(RecordEntity recordEntity){
        return toDomain(recordEntity, new Record());
    }

    public static Record toDomain(RecordEntity recordEntity, Record record){
        if(recordEntity == null) {
            return null;
        }
        record.setApplicationNumber(recordEntity.getApplicationNumber());
        record.setProductNumber(recordEntity.getProductNumber());
        record.setManufacturerName(recordEntity.getManufacturerName());
        record.setSubstanceName(recordEntity.getSubstanceName());

        return record;
    }

    public static RecordEntity updateRecord(Record record, RecordEntity existingRecordEntity) {
        if(record ==null) {
            return null;
        }
        existingRecordEntity.setApplicationNumber(record.getApplicationNumber());
        existingRecordEntity.setSubstanceName(record.getSubstanceName());
        existingRecordEntity.setManufacturerName(record.getManufacturerName());
        existingRecordEntity.setProductNumber(record.getProductNumber());

        return existingRecordEntity;
    }
}
