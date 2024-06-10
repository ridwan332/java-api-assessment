package com.cbfacademy.apiassessment.flowershop;
import java.util.List;
import org.springframework.data.repository.ListCrudRepository;


public interface FlowerShopRepository extends 
             ListCrudRepository<FlowerShop, Long> {

    
    List<FlowerShop> searchByname(String name);

   
    List<FlowerShop> searchByplace(String place);

}
