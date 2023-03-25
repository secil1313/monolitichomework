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
@Table(name = "tblShoe")
public class Shoe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//idyi otomatik arttırıyordu.

    private Integer id;
    private String shoeBrand;
    private String shoeCategory;
    private Double shoePrice;
    private Integer shoeUnitInStock;
    private Integer shoeSize;
    private String shoeDescription;


}
