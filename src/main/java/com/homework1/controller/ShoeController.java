package com.homework1.controller;

import com.homework1.dto.request.ShoeUpdateRequestDto;
import com.homework1.dto.response.FindAllByComputerNameResponseDto;
import com.homework1.dto.response.FindAllByShoeNameResponseDto;
import com.homework1.repository.entity.Shoe;
import com.homework1.service.ShoeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static com.homework1.constants.EndPointList.*;
@RestController
@RequestMapping(SHOE)
@RequiredArgsConstructor
public class ShoeController {

    private final ShoeService shoeService;

    @GetMapping(SAVE)
    public ResponseEntity<Shoe> save(Shoe shoe){
        shoeService.save(shoe);
        return ResponseEntity.ok(shoe);
    }
    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Shoe>> findAll(){
        List<Shoe> result=shoeService.findAll();
        return ResponseEntity.ok(result);
    }
    @GetMapping(FIND_BY_ID)
    public Optional<Shoe> findById(Integer id){
        Optional<Shoe> optionalShoe=shoeService.findById(id);
        if(optionalShoe.isEmpty()){
            System.out.println("Boyle bir urun yoktur");
        }
        return optionalShoe;
    }
    @GetMapping(FIND_BY_SHOEBRAND)
    public ResponseEntity<List<FindAllByShoeNameResponseDto>> findByUsername(String shoebrand){
        List<FindAllByShoeNameResponseDto> result=shoeService.findByShoeBrand(shoebrand);
        return ResponseEntity.ok(result);
    }
    @GetMapping(UPDATE)
    public ResponseEntity<Void> update(ShoeUpdateRequestDto dto){

        shoeService.update(dto);
        return ResponseEntity.ok().build();

    }
}
