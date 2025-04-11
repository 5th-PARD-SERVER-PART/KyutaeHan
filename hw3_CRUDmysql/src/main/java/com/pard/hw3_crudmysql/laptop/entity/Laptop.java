package com.pard.hw3_crudmysql.laptop.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long LaptopId;

    @Column(name = "laptopName", length = 20)
    private String laptopName;

    @Column(name = "companyName", length = 10)
    private String companyName;

    @Column(name = "cpuName", length = 10)
    private String cpuName;

    @Column(name = "releasedYear",length = 4)
    private Integer releasedYear;

    @Column(name = "otherDetails",length = 50)
    private String otherDetails;

    @CreationTimestamp
    private Timestamp laptopUploadTime;

    public void updateOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }
}


