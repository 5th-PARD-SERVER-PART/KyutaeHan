package com.pard.hw3_crudmysql.laptop.controll;


import com.pard.hw3_crudmysql.laptop.dto.LaptopDto;
import com.pard.hw3_crudmysql.laptop.dto.LaptopRequestDto;
import com.pard.hw3_crudmysql.laptop.service.LaptopService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/laptop")
public class LaptopController {
    private final LaptopService laptopService;

    @PostMapping("")
    public void save(@RequestBody LaptopRequestDto laptopRequestDto) {
        laptopService.save(laptopRequestDto);
    }

    @GetMapping("/{laptopId}")
    public LaptopDto readById(@PathVariable Long laptopId){
        return laptopService.read(laptopId);
    }


    @GetMapping("")
    public List<LaptopResponseDto> readAll(){
        return laptopService.readAll();
    }

    @GetMapping("/releasedYear")
    public List<LaptopResponseDto> readByReleaseoYear(@RequestParam int releasedYear){
        return laptopService.findByReleasedYear(releasedYear);
    }

    @GetMapping("/company/{companyName}")
    public List<LaptopResponseDto> readByCompanyName(@PathVariable String companyName){
        return laptopService.findByCompanyName(companyName);

    }

    @GetMapping("/cpu/{cpuName}")
    public List<LaptopResponseDto> readByCpuName(@PathVariable String cpuName){
        return laptopService.findByCpuName(cpuName);

    }

    @PatchMapping("/{laptopId}")
    public void update(@PathVariable Long laptopId, @RequestBody LaptopRequestDto laptopRequestDto){
        laptopService.update(laptopId, laptopRequestDto);
    }

    @DeleteMapping("/{laptopId}")
    public void delete(@PathVariable Long laptopId){
        laptopService.delete(laptopId);
    }
}
