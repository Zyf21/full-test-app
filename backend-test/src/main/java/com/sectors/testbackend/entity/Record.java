package com.sectors.testbackend.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Boolean agree;

    @NotNull
    private String userName;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "record_id")
    private List<SectorName> sectorNames;

}
