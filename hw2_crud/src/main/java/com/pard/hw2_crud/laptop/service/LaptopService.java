package com.pard.hw2_crud.laptop.service;

import com.pard.hw2_crud.laptop.dto.LaptopDto;
import com.pard.hw2_crud.laptop.repository.LaptopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LaptopService {
    private final LaptopRepository laptopRepository;

    public void saveLaptop(LaptopDto laptopDto) {
        laptopRepository.save(laptopDto);
    }

    public LaptopDto findByID(Integer laptopID) {
        return laptopRepository.findByID(laptopID);
    }

    public void updateByID(Integer laptopID, LaptopDto laptopDto) {
        laptopRepository.updateByID(laptopID, laptopDto);
    }

    public void delete(Integer laptopID){
        laptopRepository.delete(laptopID);
    }

    public List<LaptopDto> findAll(){
        return laptopRepository.findAll();
    }

}
