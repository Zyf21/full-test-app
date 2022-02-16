package com.sectors.testbackend.converter;

import com.sectors.testbackend.dto.RecordResponseDto;
import com.sectors.testbackend.dto.RecordRequestDto;
import com.sectors.testbackend.entity.Record;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RecordMapper {

    Record updateEntityByDto(@MappingTarget Record entity, RecordResponseDto recordResponseDto);

    Record convertToEntity(RecordRequestDto request);

    RecordResponseDto convertToDto(Record entity);
}
