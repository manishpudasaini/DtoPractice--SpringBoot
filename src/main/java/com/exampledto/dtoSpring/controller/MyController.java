package com.exampledto.dtoSpring.controller;

import com.exampledto.dtoSpring.dto.BikeRequest;
import com.exampledto.dtoSpring.dto.BikeResponse;
import com.exampledto.dtoSpring.services.BikeServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class MyController {
    private final BikeServices bikeServices;

    public MyController(BikeServices bikeServices) {
        this.bikeServices = bikeServices;
    }

    @PostMapping("/add")
    public BikeResponse addBike(@RequestBody BikeRequest bikeRequest){
        return bikeServices.addBike(bikeRequest);
    }

}
