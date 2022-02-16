package com.sectors.testbackend.service;

import com.sectors.testbackend.converter.RecordMapper;
import com.sectors.testbackend.dto.RecordRequestDto;
import com.sectors.testbackend.dto.RecordResponseDto;
import com.sectors.testbackend.entity.Record;
import com.sectors.testbackend.exeption.ErrorCodes;
import com.sectors.testbackend.exeption.RestException;
import com.sectors.testbackend.reposiories.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordService {

    private final RecordRepository recordRepository;
    private final RecordMapper recordMapper;

    @Autowired
    public RecordService(final RecordRepository recordRepository,
                         final RecordMapper recordMapper) {
        this.recordRepository = recordRepository;
        this.recordMapper = recordMapper;
    }

    public RecordResponseDto saveRecord(RecordRequestDto recordRequestDto) {
        Record record = recordMapper.convertToEntity(recordRequestDto);
         return recordMapper.convertToDto(recordRepository.save(record));
    }

    public void updateRecord(RecordResponseDto recordResponseDto) {
        Record recordFromDB = recordRepository.findById(recordResponseDto.getId())
                .orElseThrow(() -> new RestException(ErrorCodes.RECORD_NOT_FOUND));
        recordRepository.save(recordMapper.updateEntityByDto(recordFromDB, recordResponseDto));
    }
}
