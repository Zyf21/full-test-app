package com.sectors.testbackend.controller;

import com.sectors.testbackend.dto.RecordResponseDto;
import com.sectors.testbackend.dto.RecordRequestDto;
import com.sectors.testbackend.service.RecordService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/records")
public class RecordController {

    private final RecordService recordService;

    @Autowired
    public RecordController(final RecordService recordService) {
        this.recordService = recordService;
    }

    @PostMapping
    @Operation(summary = "Save new record")
    public RecordResponseDto saveRecord(@RequestBody RecordRequestDto recordRequestDto) {
         return recordService.saveRecord(recordRequestDto);
    }

    @PutMapping()
    @Operation(summary = "Update record by id")
    public void updateRecord(@RequestBody RecordResponseDto recordResponseDto) {
        recordService.updateRecord(recordResponseDto);
    }
}
