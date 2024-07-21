package com.cbfacademy.apiassessment.flowershop;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.RequestParam;

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
  
  @GetMapping("search")
  public ResponseEntity <List<FlowerShop>>searchflowerr( @RequestParam String query)
  {
    return ResponseEntity.ok(flowershopService.searchFlowers(query));
  }

  @GetMapping("fillter")
  public ResponseEntity<Page<FlowerShop>> getFlower(FlowerPage flowerPage, FlowerSearchCriteria flowerSearchCriteria){
    return new ResponseEntity<>(flowershopService.getFlowers(flowerPage,flowerSearchCriteria),HttpStatus.OK);
  }
   
  @GetMapping("/{id}")
  public FlowerShop getId(@PathVariable Long Id) {
    try{
   return flowershopService.getflowershop(Id);
  }catch(NoSuchElementException e){
    throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage(),e);
  }
  }
  @PostMapping
  public FlowerShop postaflower(@RequestBody FlowerShop flowershop) {
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

