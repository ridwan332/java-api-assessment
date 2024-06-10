package com.cbfacademy.apiassessment.flowershop;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.server.ResponseStatusException;

import io.micrometer.core.ipc.http.HttpSender.Response;

import org.springframework.lang.Nullable;



@RestController
@RequestMapping("API/flowershops")
public class FlowerShopController {
  FlowerShopService flowershopService;
  
  public FlowerShopController(FlowerShopService flowershopService) {
    this.flowershopService = flowershopService;
  }

  @GetMapping
  public List<FlowerShop> getAllflowershops() {
      return flowershopService.getAllflowershops();
  }
   
  @GetMapping("/{id}")
  public FlowerShop getId(@PathVariable Long Id) {
    try{
   return flowershopService.getflowershop(Id);
  }catch(NoSuchElementException e){
    throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage(),e);
  }
  }
  @PostMapping()
  public FlowerShop postIou(@RequestBody FlowerShop flowershop) {
     try{
      return flowershopService.createFlowerShop(flowershop);
     }catch(IllegalArgumentException e){
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage(),e);
     }
  }
  @PutMapping("{id}")
  public FlowerShop putFlowerShop(@PathVariable Long id, @RequestBody FlowerShop flowershop) {
     try{
    return flowershopService.updateFlowerShop(null, flowershop);
     }catch(IllegalArgumentException  e)
     {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage(),e);
     }
  }
  @DeleteMapping("{id}")
  public ResponseEntity<?> deleteFlowerShop(@PathVariable Long id) {
    try {
      flowershopService.deleteFlowerShop(id);

      return ResponseEntity.noContent().build();
  } catch (NoSuchElementException exception) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "FlowerShop Not Found", exception);
  } catch (RuntimeException exception) {
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), exception);
  }
  
}

}

