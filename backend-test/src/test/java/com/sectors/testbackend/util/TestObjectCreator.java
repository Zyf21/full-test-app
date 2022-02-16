package com.sectors.testbackend.util;


import com.sectors.testbackend.dto.SectorResponseDto;
import com.sectors.testbackend.entity.Record;
import com.sectors.testbackend.entity.Sector;
import com.sectors.testbackend.entity.SectorName;

import java.util.ArrayList;
import java.util.List;

public class TestObjectCreator {

    public static Sector crateRootSector(){
        Sector sector = new Sector();
        sector.setName("root");
        sector.setParent(null);
        sector.setChildren(new ArrayList<>());
        return sector;
    }

    public static SectorResponseDto crateRootSectorDto(){
        SectorResponseDto sector = new SectorResponseDto();
        sector.setName("root");
        sector.setParentId(null);
        sector.setChildren(new ArrayList<>());
        return sector;
    }

    public static Sector crateChildSector(){
        Sector parentSector= new Sector();
        parentSector.setName("root");
        parentSector.setId(1L);
        Sector sector = new Sector();
        sector.setName("child");
        sector.setParent(parentSector);
        sector.setChildren(new ArrayList<>());
        return sector;
    }

    public static Record crateRecord(){
        SectorName sectorName = new SectorName();
        sectorName.setName("recordName");
        Record record = new Record();
        record.setUserName("UserName");
        record.setAgree(true);
        record.setSectorNames(List.of(sectorName));
        return record;
    }



}
