package com.homework1.repository;

import com.homework1.dto.response.FindAllByComputerNameResponseDto;
import com.homework1.repository.entity.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IComputerRepository extends JpaRepository<Computer,Integer> {
    @Query("select new com.homework1.dto.response.FindAllByComputerNameResponseDto(c.computerBrand,c.computerPrice,c.computerUnitInStock) from Computer c where LOWER(c.computerBrand) like ?1%")
    List<FindAllByComputerNameResponseDto> findAllByComputerBrand(String computerBrand );
}
