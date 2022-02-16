package com.sectors.testbackend.controller;

import com.sectors.testbackend.dto.SectorResponseDto;
import com.sectors.testbackend.service.SectorService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/sectors")
public class SectorController {

    private final SectorService sectorService;

    @Autowired
    public SectorController(final SectorService sectorService) {
        this.sectorService = sectorService;
    }

    @GetMapping
    @Operation(summary = "Find all sectors", description = "Provides a structure for creating a multi-level selectbox")
    public List<SectorResponseDto> getAllSectors(){
        return sectorService.findAllSectors();
    }

    @GetMapping("/{sectorId}")
    @Operation(summary = "Get sector by id")
    public SectorResponseDto getSectorById(@PathVariable Long sectorId){
        return sectorService.getSectorById(sectorId);
    }

}
