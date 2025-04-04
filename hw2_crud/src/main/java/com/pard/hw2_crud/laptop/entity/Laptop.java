package com.pard.hw2_crud.laptop.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Laptop {
    private Integer releasedYear;
    private String laptopName;
    private String cpuName;
    private String companyName;
    private String otherDetails;
    private Integer laptopID;
}
