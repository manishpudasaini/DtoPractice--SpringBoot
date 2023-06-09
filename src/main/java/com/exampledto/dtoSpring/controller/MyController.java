package com.exampledto.dtoSpring.controller;

import com.exampledto.dtoSpring.dto.BikeRequest;
import com.exampledto.dtoSpring.dto.BikeResponse;
import com.exampledto.dtoSpring.services.BikeServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class MyController {
    private final BikeServices bikeServices;

    public MyController(BikeServices bikeServices) {
        this.bikeServices = bikeServices;
    }

    @Value("${welcome.message}")
    public String welcomemessage;

    @GetMapping("/")
    public String welcomeMessage(){
        return welcomemessage;
    }

    @PostMapping("/add")
    public BikeResponse addBike(@Valid @RequestBody BikeRequest bikeRequest){
        return bikeServices.addBike(bikeRequest);
    }

    @GetMapping("/{id}")
    public BikeResponse getBookById(@PathVariable int id) {
        return bikeServices.getBikeById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id){
        bikeServices.deleteBike(id);
    }
}
