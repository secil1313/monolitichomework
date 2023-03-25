package com.homework1.service;

import com.homework1.dto.request.ComputerUpdateRequestDto;
import com.homework1.dto.request.ShoeUpdateRequestDto;
import com.homework1.dto.response.FindAllByComputerNameResponseDto;
import com.homework1.dto.response.FindAllByShoeNameResponseDto;
import com.homework1.repository.IShoeRepository;
import com.homework1.repository.entity.Computer;
import com.homework1.repository.entity.Shoe;
import com.homework1.utility.ServiceManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoeService extends ServiceManager<Shoe,Integer> {
private final IShoeRepository repository;
    public ShoeService(IShoeRepository repository) {
        super(repository);
       this.repository=repository;
    }
    public Shoe save(Shoe shoe){
        return repository.save(shoe);
    }
    public List<Shoe> findAll(){
        return repository.findAll();
    }
    public Optional<Shoe> findById(Integer id){
        Optional<Shoe> optional=repository.findById(id);
        if(optional.isEmpty()){
            System.out.println("Yok");
        }
        return optional;
    }
    public List<FindAllByShoeNameResponseDto> findByShoeBrand(String shoeBrand){
        return repository.findAllByShoeBrand(shoeBrand);
    }
    public void update(ShoeUpdateRequestDto dto){

        Optional<Shoe> user=repository.findById(dto.getId());
        if(user.isPresent()){
            user.get().setShoeBrand(dto.getShoeBrand());
            user.get().setShoePrice(dto.getShoePrice());
            user.get().setShoeUnitInStock(dto.getShoeUnitInStock());
            repository.save(user.get());
        }
        //http://localhost:9090/dev/v1/user/update?id=2&username=ayhantekin&adres=İzmir&yas=99
    }
}
