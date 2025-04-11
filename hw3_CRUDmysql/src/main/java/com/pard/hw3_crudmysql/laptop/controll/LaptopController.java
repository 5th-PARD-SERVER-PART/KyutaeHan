package com.pard.hw3_crudmysql.laptop.controll;


import com.pard.hw3_crudmysql.laptop.dto.LaptopDto;
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
    public void save(@RequestBody LaptopDto laptopDto){
        laptopService.save(laptopDto);
    }

    @GetMapping("/{laptopId}")
    public LaptopDto readById(@PathVariable Long laptopId){
        return laptopService.read(laptopId);
    }


    @GetMapping("")
    public List<LaptopDto> readAll(){
        return laptopService.readAll();
    }

    @GetMapping("/releasedYear")
    public List<LaptopDto> readByReleaseDateEqualToYear(@RequestParam int year){
        return laptopService.findReleasedDateEqualToYear(year);
    }

    @GetMapping("/{companyName}")
    public List<LaptopDto> readByCompanyName(@PathVariable String companyName){
        return laptopService.findByCompanyName(companyName);

    }

    @GetMapping("/{cpuName}")
    public List<LaptopDto> readByCpuName(@PathVariable String cpuName){
        return laptopService.findByCpuName(cpuName);

    }

    @PatchMapping("/{laptopId}")
    public void update(@PathVariable Long laptopId, @RequestBody LaptopDto laptopDto){
        laptopService.update(laptopId, laptopDto);
    }

    @DeleteMapping("/{laptopId}")
    public void delete(@PathVariable Long laptopId){
        laptopService.delete(laptopId);
    }
}
