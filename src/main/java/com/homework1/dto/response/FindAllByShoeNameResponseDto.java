package com.homework1.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FindAllByShoeNameResponseDto {
    private String shoeBrand;
    private Double shoePrice;
    private Integer shoeUnitInStock;
    private Integer shoeSize;
}
