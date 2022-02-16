package com.sectors.testbackend.service;

import com.sectors.testbackend.dto.SectorResponseDto;
import com.sectors.testbackend.entity.Sector;
import com.sectors.testbackend.reposiories.SectorRepository;
import com.sectors.testbackend.util.TestObjectCreator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class SectorServiceTest {

    @Autowired
    private SectorService sectorService;

    @MockBean
    private SectorRepository sectorRepository;

    @Test
    public void findAllSectors() {

        Long actualSize = 3L;
        Sector sector1 = TestObjectCreator.crateRootSector();
        Sector sector2 = TestObjectCreator.crateRootSector();
        Sector sector3 = TestObjectCreator.crateRootSector();

        List<Sector> sectors = List.of(sector1, sector2, sector3);

        when(sectorRepository.findAllByParentNull()).thenReturn(sectors);
        List<SectorResponseDto> result = sectorService.findAllSectors();

        assertFalse(result.isEmpty());
        assertEquals(result.size(), actualSize);

    }

    @Test
    public void getSectorById() {
        Long sectorId = 1L;
        Sector sector = TestObjectCreator.crateChildSector();
        when(sectorRepository.findById(sectorId)).thenReturn(Optional.of(sector));
        SectorResponseDto sectorResult = sectorService.getSectorById(sectorId);

        assertNotNull(sectorResult);
        assertEquals(sector.getName(), sectorResult.getName());
    }
}
