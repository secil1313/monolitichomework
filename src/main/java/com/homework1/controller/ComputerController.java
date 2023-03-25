package com.homework1.controller;

import com.homework1.dto.request.ComputerUpdateRequestDto;
import com.homework1.dto.response.FindAllByComputerNameResponseDto;
import com.homework1.repository.entity.Computer;
import com.homework1.service.ComputerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.homework1.constants.EndPointList.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(COMPUTER)
@RequiredArgsConstructor
public class ComputerController {
    //http://localhost:8080/computer/save?computerBrand=mac&computerCategory=dizüstü&computerPrice=30000&computerUnitInStock=3&computerDescription=bilgisayar
    //http://localhost:8080/computer/find-all
    private final ComputerService computerService;
    @GetMapping(SAVE)
    public ResponseEntity<Computer> save(Computer computer){
    computerService.save(computer);
        return ResponseEntity.ok(computer);
    }
    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Computer>> findAll(){
        List<Computer> result=computerService.findAll();
        return ResponseEntity.ok(result);
    }


    @GetMapping(FIND_BY_ID)
    public Optional<Computer> findById(Integer id) {
        Optional<Computer> optionalProduct = computerService.findById(id);
        if (optionalProduct.isEmpty()){
            System.out.println("Boyle bir urun yoktur");
        }
        return optionalProduct;
    }
    @GetMapping(FIND_BY_COMPUTERBRAND)
    public ResponseEntity<List<FindAllByComputerNameResponseDto>> findByUsername(String username){
        List<FindAllByComputerNameResponseDto> result=computerService.findByComputerBrand(username);
        return ResponseEntity.ok(result);
    }
    @GetMapping(UPDATE)
    public ResponseEntity<Void> update(ComputerUpdateRequestDto dto){

        computerService.update(dto);
        return ResponseEntity.ok().build();

    }

}
