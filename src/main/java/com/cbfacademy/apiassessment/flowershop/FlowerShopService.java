package com.cbfacademy.apiassessment.flowershop;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

@Service
public class FlowerShopService implements FlowerService {

    private final FlowerShopRepository flowershoprepository;

    public FlowerShopService(FlowerShopRepository flowershoprepository) {
        this.flowershoprepository = flowershoprepository;
    }

    public List<FlowerShop> getAllflowershops() {
        return flowershoprepository.findAll();

    }

    FlowerShop getflowershop(Long id) throws NoSuchElementException {
        return flowershoprepository.findById(id).orElseThrow();
    }

    public FlowerShop createFlowerShop(FlowerShop flowerShop) throws IllegalArgumentException {
        if (flowerShop == null) {
            throw new IllegalArgumentException(" FlowerShop object cannot be null");
        }

        return flowershoprepository.save(flowerShop);
    }

    public FlowerShop updateFlowerShop(Long id, FlowerShop updatedFlowerShop) throws IllegalArgumentException {
        if (updatedFlowerShop == null) {
            throw new IllegalArgumentException("Updated flowershop object cannot be null");

        }
        FlowerShop updatedflowershopp = flowershoprepository.save(updatedFlowerShop);
        return updatedflowershopp;

    }

    public void deleteFlowerShop(Long id) throws NoSuchElementException {

        if (flowershoprepository.findById(id).isPresent()) {
            flowershoprepository.deleteById(id);
        } else {
            throw new NoSuchElementException("id not found");
        }
    }

    @Override
    public List<FlowerShop> searchFlowers(String query) {
        List<FlowerShop> flower = flowershoprepository.searchFlower(query);
        return flower;

    }

}
