package com.pard.hw3_crudmysql.laptop.dto;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter

public class LaptopDto {
    private Integer releasedYear;
    private String laptopName;
    private String cpuName;
    private String companyName;
    private String otherDetails;
    //private Integer laptopID;
}
