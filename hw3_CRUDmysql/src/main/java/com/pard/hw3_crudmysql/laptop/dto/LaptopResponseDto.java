package com.pard.hw3_crudmysql.laptop.dto;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class LaptopResponseDto {
    private Integer releasedYear;
    private String laptopName;
    private String cpuName;
    private String companyName;
    private String otherDetails;
}
