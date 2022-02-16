package com.sectors.testbackend.converter;


import com.sectors.testbackend.dto.SectorResponseDto;
import com.sectors.testbackend.entity.Sector;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SectorMapper {

    List<SectorResponseDto> convertToDto(List<Sector> sectors);

    @Mapping(target = "parentId", source = "parent.id")
    SectorResponseDto convertToDto(Sector sector);

}
