package com.cbfacademy.apiassessment.flowershop;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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

   @CreationTimestamp
   private LocalDateTime dateCreated;
   @UpdateTimestamp
   private LocalDateTime dateUpdated;
   
  
  public FlowerShop() {
  }
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

        public LocalDateTime getDateCreated() {
          return dateCreated;
        }
        public void setDateCreated(LocalDateTime dateCreated) {
          this.dateCreated = dateCreated;
        }
        public LocalDateTime getDateUpdated() {
          return dateUpdated;
        }
        public void setDateUpdated(LocalDateTime dateUpdated) {
          this.dateUpdated = dateUpdated;
        }
  }