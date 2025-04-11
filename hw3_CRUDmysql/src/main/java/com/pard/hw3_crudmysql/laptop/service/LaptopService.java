package com.pard.hw3_crudmysql.laptop.service;


import com.pard.hw3_crudmysql.laptop.dto.LaptopDto;
import com.pard.hw3_crudmysql.laptop.entity.Laptop;
import com.pard.hw3_crudmysql.laptop.repository.LaptopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LaptopService {
    private final LaptopRepository laptopRepository;

    public void save(LaptopDto laptopDto){
        Laptop laptop = Laptop.builder()
                .laptopName(laptopDto.getLaptopName())
                .releasedYear(laptopDto.getReleasedYear())
                .cpuName(laptopDto.getCpuName())
                .companyName(laptopDto.getCompanyName())
                .otherDetails(laptopDto.getOtherDetails())
                .build();

        laptopRepository.save(laptop);
    }

    public LaptopDto read(Long laptopId){
        Laptop laptop = laptopRepository.findById(laptopId).get();
        return LaptopDto.builder()
                .laptopName(laptop.getLaptopName())
                .releasedYear(laptop.getReleasedYear())
                .cpuName(laptop.getCpuName())
                .companyName(laptop.getCompanyName())
                .otherDetails(laptop.getOtherDetails())
                .build();

    }

    public List<LaptopDto> findByReleasedYear(int year){
        List<Laptop> laptops = laptopRepository.findByReleasedYear(year);
        List<LaptopDto> laptopDtos = laptops.stream().map(laptop ->
                LaptopDto.builder()
                        .laptopName(laptop.getLaptopName())
                        .releasedYear(laptop.getReleasedYear())
                        .cpuName(laptop.getCpuName())
                        .companyName(laptop.getCompanyName())
                        .otherDetails(laptop.getOtherDetails())
                        .build()).toList();
        return laptopDtos;
    }

    public List<LaptopDto> findByCompanyName(String companyName) {
        List<Laptop> laptops = laptopRepository.findByCompanyName(companyName);
        List<LaptopDto> laptopDtos = laptops.stream().map(laptop ->
                LaptopDto.builder()
                        .laptopName(laptop.getLaptopName())
                        .releasedYear(laptop.getReleasedYear())
                        .cpuName(laptop.getCpuName())
                        .companyName(laptop.getCompanyName())
                        .otherDetails(laptop.getOtherDetails())
                        .build()).toList();
        return laptopDtos;
    }

    public List<LaptopDto> findByCpuName(String cpuName) {
        List<Laptop> laptops = laptopRepository.findByCpuName(cpuName);
        List<LaptopDto> laptopDtos = laptops.stream().map(laptop ->
                LaptopDto.builder()
                        .laptopName(laptop.getLaptopName())
                        .releasedYear(laptop.getReleasedYear())
                        .cpuName(laptop.getCpuName())
                        .companyName(laptop.getCompanyName())
                        .otherDetails(laptop.getOtherDetails())
                        .build()).toList();
        return laptopDtos;
    }

//    public Long getLaptopNum(String laptopName){
//        Laptop laptop = laptopRepository.findByLaptopName(laptopName);
//        return laptop.getLaptopId();
//    }

    public List<LaptopDto> readAll(){
        List<Laptop> laptops = laptopRepository.findAll();
        List<LaptopDto> laptopDtos = laptops.stream().map(laptop ->
                LaptopDto.builder()
                    .laptopName(laptop.getLaptopName())
                    .releasedYear(laptop.getReleasedYear())
                    .cpuName(laptop.getCpuName())
                    .companyName(laptop.getCompanyName())
                    .otherDetails(laptop.getOtherDetails())
                    .build()).toList();
        return laptopDtos;
    }

    @Transactional
    public void update(Long laptopId, LaptopDto laptopDto)
    {
        Laptop laptop = laptopRepository.findById(laptopId).get();
        laptop.updateOtherDetails(laptopDto.getOtherDetails());
        laptopRepository.save(laptop);
    }

    public void delete(Long laptopId){
        laptopRepository.deleteById(laptopId);
    }



}

