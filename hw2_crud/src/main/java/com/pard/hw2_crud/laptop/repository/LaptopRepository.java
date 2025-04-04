package com.pard.hw2_crud.laptop.repository;

import com.pard.hw2_crud.laptop.dto.LaptopDto;
import com.pard.hw2_crud.laptop.entity.Laptop;
import org.springframework.stereotype.Repository;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LaptopRepository {
    private static final Map<Integer, Laptop> handong = new HashMap<>();

    public void save(LaptopDto laptopDto){
        Laptop laptop = Laptop.builder()
                .laptopID(laptopDto.getLaptopID())
                .laptopName(laptopDto.getLaptopName())
                .releasedYear(laptopDto.getReleasedYear())
                .cpuName(laptopDto.getCpuName())
                .companyName(laptopDto.getCompanyName())
                .otherDetails(laptopDto.getOtherDetails())
                .build();
            handong.put(laptopDto.getLaptopID(), laptop);
    }

    public LaptopDto findByID(Integer laptopID) {
        Laptop laptop = handong.get(laptopID);

        return LaptopDto.builder()
                .laptopID(laptop.getLaptopID())
                .laptopName(laptop.getLaptopName())
                .releasedYear(laptop.getReleasedYear())
                .cpuName(laptop.getCpuName())
                .companyName(laptop.getCompanyName())
                .otherDetails(laptop.getOtherDetails())
                .build();

    }

    public void updateByID(Integer laptopID, LaptopDto laptopDto) {
        Laptop laptop = handong.get(laptopID);

        laptop.setLaptopID(laptopDto.getLaptopID());
        laptop.setLaptopName(laptopDto.getLaptopName());
        laptop.setReleasedYear(laptopDto.getReleasedYear());
        laptop.setCpuName(laptopDto.getCpuName());
        laptop.setCompanyName(laptopDto.getCompanyName());
        laptop.setOtherDetails(laptopDto.getOtherDetails());
    }

    public void delete(Integer laptopID){
        handong.remove(laptopID);

    }

    public List<LaptopDto> findAll(){
        return handong.values().stream()
                .map(laptop -> LaptopDto.builder()
                    .laptopID(laptop.getLaptopID())
                    .laptopName(laptop.getLaptopName())
                    .releasedYear(laptop.getReleasedYear())
                    .cpuName(laptop.getCpuName())
                    .companyName(laptop.getCompanyName())
                    .otherDetails(laptop.getOtherDetails())
                    .build()).toList();
    }


}
