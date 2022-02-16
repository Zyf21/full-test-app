package com.sectors.testbackend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sectors.testbackend.entity.Record;
import com.sectors.testbackend.reposiories.RecordRepository;
import com.sectors.testbackend.service.RecordService;
import com.sectors.testbackend.util.TestObjectCreator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class RecordControllerTest {

    @MockBean
    private RecordService recordService;

    @MockBean
    private RecordRepository recordRepository;

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void saveRecord() throws Exception {
        Record record = TestObjectCreator.crateRecord();
        when(recordRepository.save(record)).thenReturn(record);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/records")
                .content(objectMapper.writeValueAsString(record))
                .contentType(APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    @Test
    public void updateRecord() throws Exception {
        Record record = TestObjectCreator.crateRecord();
        when(recordRepository.save(record)).thenReturn(record);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/api/records/1")
                .content(objectMapper.writeValueAsString(record))
                .contentType(APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
    }
}