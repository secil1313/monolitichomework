package com.homework1.service;

import com.homework1.dto.request.ComputerUpdateRequestDto;
import com.homework1.dto.response.FindAllByComputerNameResponseDto;
import com.homework1.repository.IComputerRepository;
import com.homework1.repository.entity.Computer;
import com.homework1.utility.ServiceManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComputerService extends ServiceManager<Computer,Integer> {
    private final IComputerRepository repository;
    public ComputerService(IComputerRepository repository){
        super(repository);
        this.repository=repository;
    }
    public Computer save(Computer computer){

        return repository.save(computer);
    }
    public List<Computer> findAll(){

        return repository.findAll();
    }
    public Optional<Computer> findById(Integer id) {
        Optional <Computer> optional=repository.findById(id);
        if(optional.isEmpty()){
            System.out.println("Yok");
        }
        return optional;
    }
    public List<FindAllByComputerNameResponseDto> findByComputerBrand(String computerBrand){
        return repository.findAllByComputerBrand(computerBrand);
    }
    public void update(ComputerUpdateRequestDto dto){

        Optional<Computer> user=repository.findById(dto.getId());
        if(user.isPresent()){
            user.get().setComputerBrand(dto.getComputerBrand());
            user.get().setComputerPrice(dto.getComputerPrice());
            repository.save(user.get());
        }
        //http://localhost:9090/dev/v1/user/update?id=2&username=ayhantekin&adres=İzmir&yas=99
    }
}
