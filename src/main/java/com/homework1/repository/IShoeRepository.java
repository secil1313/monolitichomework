package com.homework1.repository;


import com.homework1.dto.response.FindAllByShoeNameResponseDto;
import com.homework1.repository.entity.Shoe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IShoeRepository extends JpaRepository<Shoe,Integer> {
    @Query("select new com.homework1.dto.response.FindAllByShoeNameResponseDto(s.shoeBrand,s.shoePrice,s.shoeUnitInStock,s.shoeSize) from Shoe s where LOWER(s.shoeBrand) like ?1%")
    List<FindAllByShoeNameResponseDto> findAllByShoeBrand(String shoeBrand );
}
