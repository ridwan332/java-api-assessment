package com.cbfacademy.apiassessment;

import com.cbfacademy.apiassessment.flowershop.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FlowerShopTest {

    private FlowerShop flowerShop;

    @BeforeEach
    public void setUp() {
        // Instantiate a new FlowerShop object before each test
        flowerShop = new FlowerShop();
    }

    @Test
    public void testDefaultConstructor() {
        // Test the default constructor
        assertNull(flowerShop.getPlace(), "Place should be null");
        assertNull(flowerShop.getType(), "Type should be null");
        assertNull(flowerShop.getName(), "Name should be null");
        assertNull(flowerShop.getDateCreated(), "DateCreated should be null");
        assertNull(flowerShop.getDateUpdated(), "DateUpdated should be null");
    }

    @Test
    public void testParameterizedConstructor() {
        // Test the parameterized constructor
        flowerShop = new FlowerShop("London", "Roses", "redRose");

        assertEquals("London", flowerShop.getPlace(), "Place should be 'London'");
        assertEquals("Rose", flowerShop.getType(), "Type should be 'Rose'");
        assertEquals("Rose", flowerShop.getName(), "Name should be 'redRose'");
    }

    @Test
    public void testSettersAndGetters() {
        // Test the setters and getters for each field
        flowerShop.setPlace("Bristol");
        flowerShop.setType("gift wraped");
        flowerShop.setName("Tulip");
        
        assertEquals("Bristol", flowerShop.getPlace(), "Place should be 'Bristol'");
        assertEquals("giftwrapped", flowerShop.getType(), "Type should be 'Giftwrapped'");
        assertEquals("Tulip", flowerShop.getName(), "Name should be 'Tulip'");
    }

    @Test
    public void testDateCreatedAndUpdated() {
        // Manually setting dates to test setters and getters
        LocalDateTime now = LocalDateTime.now();
        flowerShop.setDateCreated(now);
        flowerShop.setDateUpdated(now.plusHours(1));

        assertEquals(now, flowerShop.getDateCreated(), "DateCreated should match the set date");
        assertEquals(now.plusHours(1), flowerShop.getDateUpdated(), "DateUpdated should be every time its updated DateCreated");
    }

    @Test
    public void testId() {
        // Test setting and getting the ID
        flowerShop.setId(123);
        assertEquals(123, flowerShop.getId(), "ID should be 123");
    }

    @Test
    public void testNoArgsConstructorInitializesTimestamps() {
        // Test that default constructor initializes timestamps
        assertNull(flowerShop.getDateCreated(), "DateCreated should be null initially");
        assertNull(flowerShop.getDateUpdated(), "DateUpdated should be null initially");
    }
}
