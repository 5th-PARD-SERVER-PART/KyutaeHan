package com.pard.hw3_crudmysql.laptop.repository;


import com.pard.hw3_crudmysql.laptop.entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LaptopRepository extends JpaRepository<Laptop, Long> {
    //public Laptop findByLaptopName(String laptopName);

    List<Laptop> findByCompanyName(String companyName);

    List<Laptop> findByCpuName(String cpuName);

    List<Laptop> findByReleasedYear(int releasedYear);
}
