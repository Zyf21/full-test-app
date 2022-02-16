package com.sectors.testbackend.service;


import com.sectors.testbackend.entity.Record;
import com.sectors.testbackend.reposiories.RecordRepository;
import com.sectors.testbackend.util.TestObjectCreator;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import java.util.Optional;

import static org.mockito.Mockito.when;


@SpringBootTest
class RecordServiceTest {

    @Autowired
    private RecordService recordService;

    @MockBean
    private RecordRepository recordRepository;

    @Test
    public void saveRecord() {
        Record record = TestObjectCreator.crateRecord();
        when(recordRepository.save(record)).thenReturn(record);
    }

    @Test
    public void updateRecord() {
        Long recordId = 1L;
        Record record = TestObjectCreator.crateRecord();
        when(recordRepository.findById(recordId)).thenReturn(Optional.of(record));
        when(recordRepository.save(record)).thenReturn(record);

    }
}