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
public class FindAllByComputerNameResponseDto {
    private String computerBrand;
    private Double computerPrice;
    private Integer computerUnitInStock;
}
