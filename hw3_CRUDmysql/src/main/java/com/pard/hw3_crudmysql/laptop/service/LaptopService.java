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

    public void save(LaptopRequestDto laptopRequestDto){
        Laptop laptop = Laptop.builder()
                .laptopName(laptopRequestDto.getLaptopName())
                .releasedYear(laptopRequestDto.getReleasedYear())
                .cpuName(laptopRequestDto.getCpuName())
                .companyName(laptopRequesttDto.getCompanyName())
                .otherDetails(laptopRequestDto.getOtherDetails())
                .build();

        laptopRepository.save(laptop);
    }

    public LaptopResponseDto read(Long laptopId){
        Laptop laptop = laptopRepository.findById(laptopId)
                .orElseThrow(() -> new IllegalArgumentException("Laptop not found"));
        return toResponseDto(laptop);

    }

    public List<LaptopResponseDto> readAll(){
//        List<Laptop> laptops = laptopRepository.findAll();
//        List<LaptopDto> laptopDtos = laptops.stream().map(laptop ->
//                LaptopDto.builder()
//                        .laptopName(laptop.getLaptopName())
//                        .releasedYear(laptop.getReleasedYear())
//                        .cpuName(laptop.getCpuName())
//                        .companyName(laptop.getCompanyName())
//                        .otherDetails(laptop.getOtherDetails())
//                        .build()).toList();
//        return laptopDtos;
        return laptopRepository.findAll()
                .stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    public List<LaptopResponseDto> findByReleasedYear(int year){
//        List<Laptop> laptops = laptopRepository.findByReleasedYear(year);
//        List<LaptopDto> laptopDtos = laptops.stream().map(laptop ->
//                LaptopDto.builder()
//                        .laptopName(laptop.getLaptopName())
//                        .releasedYear(laptop.getReleasedYear())
//                        .cpuName(laptop.getCpuName())
//                        .companyName(laptop.getCompanyName())
//                        .otherDetails(laptop.getOtherDetails())
//                        .build()).toList();
//        return laptopDtos;
        return laptopRepository.findByReleasedYear(year)
                .stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    public List<LaptopResponseDto> findByCompanyName(String companyName) {
//        List<Laptop> laptops = laptopRepository.findByCompanyName(companyName);
//        List<LaptopDto> laptopDtos = laptops.stream().map(laptop ->
//                LaptopDto.builder()
//                        .laptopName(laptop.getLaptopName())
//                        .releasedYear(laptop.getReleasedYear())
//                        .cpuName(laptop.getCpuName())
//                        .companyName(laptop.getCompanyName())
//                        .otherDetails(laptop.getOtherDetails())
//                        .build()).toList();
//        return laptopDtos;
        return laptopRepository.findByCompanyName(companyName)
                .stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    public List<LaptopResponseDto> findByCpuName(String cpuName) {
//        List<Laptop> laptops = laptopRepository.findByCpuName(cpuName);
//        List<LaptopDto> laptopDtos = laptops.stream().map(laptop ->
//                LaptopDto.builder()
//                        .laptopName(laptop.getLaptopName())
//                        .releasedYear(laptop.getReleasedYear())
//                        .cpuName(laptop.getCpuName())
//                        .companyName(laptop.getCompanyName())
//                        .otherDetails(laptop.getOtherDetails())
//                        .build()).toList();
//        return laptopDtos;
        return laptopRepository.findByCpuName(cpuName)
                .stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

//    public Long getLaptopNum(String laptopName){
//        Laptop laptop = laptopRepository.findByLaptopName(laptopName);
//        return laptop.getLaptopId();
//    }



    @Transactional
    public void update(Long laptopId, LaptopRequestDto laptopRequestDto)
    {
//        Laptop laptop = laptopRepository.findById(laptopId).get();
//        laptop.updateOtherDetails(laptopRequestDto.getOtherDetails());
//        laptopRepository.save(laptop);
        Laptop laptop = laptopRepository.findById(laptopId)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 노트북이 없습니다: " + laptopId));

        laptop.update(
                laptopRequestDto.getLaptopName(),
                laptopRequestDto.getReleasedYear(),
                laptopRequestDto.getCpuName(),
                laptopRequestDto.getOtherDetails()
        );
    }

    public void delete(Long laptopId){
        laptopRepository.deleteById(laptopId);
    }

    //공통 매핑 함수
    private LaptopResponseDto toResponseDto(Laptop laptop){
        return LaptopResponseDto.builder()
                .id(laptop.getLaptopId())
                .laptopName(laptop.getLaptopName())
                .releasedYear(laptop.getReleasedYear())
                .cpuName(laptop.getCpuName())
                .companyName(laptop.getCompanyName())
                .otherDetails(laptop.getOtherDetails())
                .build();
    }


}

