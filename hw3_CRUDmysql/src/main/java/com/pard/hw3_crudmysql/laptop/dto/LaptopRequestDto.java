package com.pard.hw3_crudmysql.laptop.dto;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter

public class LaptopRequestDto {
    private Integer laptopId;
    private Integer releasedYear;
    private String laptopName;
    private String cpuName;
    private String companyName;
    private String otherDetails;
}
