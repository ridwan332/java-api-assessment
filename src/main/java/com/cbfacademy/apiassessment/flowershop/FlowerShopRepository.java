package com.cbfacademy.apiassessment.flowershop;
import java.util.List;
import org.springframework.data.repository.ListCrudRepository;


public interface FlowerShopRepository extends 
             ListCrudRepository<FlowerShop, Integer> {

    /**
     * Searches for IOUs where the borrower's name matches the provided string.
     *
     * @param name the name of the borrower
     * @return a list of IOUs that match the borrower's name
     */
    List<FlowerShop> searchByname(String name);

    /**
     * Searches for IOUs where the lender's name matches the provided string.
     *
     * @param name the name of the lender
     * @return a list of IOUs that match the lender's name
     */
    List<FlowerShop> searchByplace(String place);

}
