package com.sectors.testbackend.controller;

import com.sectors.testbackend.dto.SectorResponseDto;
import com.sectors.testbackend.service.SectorService;
import com.sectors.testbackend.util.TestObjectCreator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SectorControllerTest {

    @MockBean
    private SectorService sectorService;

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void getAllSectors() throws Exception {

        SectorResponseDto sectorResponseDto1 = TestObjectCreator.crateRootSectorDto();
        SectorResponseDto sectorResponseDto2 = TestObjectCreator.crateRootSectorDto();
        SectorResponseDto sectorResponseDto3 = TestObjectCreator.crateRootSectorDto();
        List<SectorResponseDto> sectors = List.of(sectorResponseDto1, sectorResponseDto2, sectorResponseDto3);

        when(sectorService.findAllSectors()).thenReturn(sectors);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/sectors")
                .contentType(APPLICATION_JSON);

         mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

}
