package com.clothingshop.controller;

import com.clothingshop.model.ClothingItem;
import com.clothingshop.service.ClothingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //defines the class as a REST controller (Spring component for handling HTTP requests)
@RequestMapping("/api/clothing") 
public class ClothingController { 

    private final ClothingService clothingService;

    @Autowired //injects the ClothingService dependency (Spring will automatically create an instance of ClothingService)
    public ClothingController(ClothingService clothingService) { 
        this.clothingService = clothingService; 
    }

    @GetMapping //defines a handler for GET requests to the /api/clothing endpoint
    public List<ClothingItem> getAllClothingItems() {
        return clothingService.getAllClothingItems();
    }

    @PostMapping //defines a handler for POST requests to the /api/clothing endpoint
    public ClothingItem addClothingItem(@RequestBody ClothingItem clothingItem) {
        return clothingService.addClothingItem(clothingItem);
    }

    @PutMapping("/{id}") //defines a handler for PUT requests to the /api/clothing/{id} endpoint
    public ClothingItem updateClothingItem(
            @PathVariable Long id, //extracts the id from the URL path
            @RequestBody ClothingItem clothingItem) { //extracts the request body and maps it to a ClothingItem object
        return clothingService.updateClothingItem(id, clothingItem);
    }

    @DeleteMapping("/{id}") //defines a handler for DELETE requests to the /api/clothing/{id} endpoint
    public void deleteClothingItem(@PathVariable Long id) { 
        clothingService.deleteClothingItem(id);
    }
}
