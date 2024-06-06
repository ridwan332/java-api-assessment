package com.cbfacademy.flowershop;

import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table( name = "flowerShop")
public class FlowerShop {
  @Id 
    @GeneratedValue( strategy  = GenerationType.IDENTITY)
   private long id;

   private String place;
   private String type;
   private String name;
  public FlowerShop(String place, String type, String name) {
    this.place = place;
    this.type = type;
    this.name = name;
  }
        public long getId() {
          return id;
        }
        public void setId(long id) {
          this.id = id;
        }
        public String getPlace() {
          return place;
        }
        public void setPlace(String place) {
          this.place = place;
        }
        public String getType() {
          return type;
        }
        public void setType(String type) {
          this.type = type;
        }
        public String getName() {
          return name;
        }
        public void setName(String name) {
          this.name = name;
        }

   

  }