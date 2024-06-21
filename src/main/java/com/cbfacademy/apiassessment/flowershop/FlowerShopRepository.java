package com.cbfacademy.apiassessment.flowershop;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FlowerShopRepository extends 
             JpaRepository<FlowerShop, Long> {

  /*filtering items using jpa query language you can also use native sql queries but im using this for now */

    @Query("SELECT Flower FROM FlowerShop Flower WHERE " +"Flower.name LIKE CONCAT ('%',:query, '%')" + " or Flower.type LIKE CONCAT('%', :query, '%')")
    List<FlowerShop> searchFlower(String query);

   
    

}
