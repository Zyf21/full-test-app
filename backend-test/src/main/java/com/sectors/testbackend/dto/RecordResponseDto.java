package com.sectors.testbackend.dto;

import com.sectors.testbackend.entity.SectorName;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class RecordResponseDto {

    private Long id;

    @NotNull
    private Boolean agree;

    @NotNull
    @NotEmpty
    private String userName;

    @NotNull
    private List<SectorName> sectorNames;
}
