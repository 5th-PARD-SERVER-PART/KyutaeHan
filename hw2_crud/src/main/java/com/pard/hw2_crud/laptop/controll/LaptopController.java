package com.pard.hw2_crud.laptop.controll;

import com.pard.hw2_crud.laptop.dto.LaptopDto;
import com.pard.hw2_crud.laptop.service.LaptopService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/laptop")

public class LaptopController {
    private final LaptopService laptopService;

    @PostMapping("")
    public String save(@RequestBody LaptopDto laptopDto){
        laptopService.saveLaptop(laptopDto);
        return "저장완료";
    }

    @GetMapping("/{laptopID}")
    public LaptopDto findByID(@PathVariable Integer laptopID){
        return laptopService.findByID(laptopID);

    }

    @PatchMapping("/{laptopID}")
    public String updateByID(@PathVariable Integer laptopID,
                             @RequestBody LaptopDto laptopDto){
        laptopService.updateByID(laptopID, laptopDto);
        return "수정완료";
    }

    @DeleteMapping("/{laptopID}")
    public String deleteByID(@PathVariable Integer laptopID){
        laptopService.delete(laptopID);
        return "삭제완료";
    }

    @GetMapping("")
    public List<LaptopDto> findAll(){
        return laptopService.findAll();
    }


}
