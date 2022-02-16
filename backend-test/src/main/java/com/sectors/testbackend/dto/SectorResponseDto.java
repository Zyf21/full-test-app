package com.sectors.testbackend.dto;

import lombok.Data;

import java.util.List;

@Data
public class SectorResponseDto {
    private Long id;
    private String name;
    private Long parentId;
    private List<SectorResponseDto> children;
}
