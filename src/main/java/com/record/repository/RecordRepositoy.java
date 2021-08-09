package com.record.repository;

import com.record.entity.RecordEntity;
import org.springframework.data.repository.CrudRepository;

public interface RecordRepositoy extends CrudRepository<RecordEntity, Integer> {

}
