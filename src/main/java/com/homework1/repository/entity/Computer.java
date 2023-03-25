package com.homework1.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tblComputer")
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//idyi otomatik arttırıyordu.

    private Integer id;
    private String computerBrand;
    private String computerCategory;
    private Double computerPrice;
    private Integer computerUnitInStock;
    private String computerDescription;
}
