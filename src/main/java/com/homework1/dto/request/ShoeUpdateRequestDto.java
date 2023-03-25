package com.homework1.dto.request;

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

public class ShoeUpdateRequestDto {

    private Integer id;
    private String shoeBrand;
    private Double shoePrice;
    private int shoeUnitInStock;
}
