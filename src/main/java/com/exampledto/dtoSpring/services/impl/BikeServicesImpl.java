package com.exampledto.dtoSpring.services.impl;

import com.exampledto.dtoSpring.dto.BikeRequest;
import com.exampledto.dtoSpring.dto.BikeResponse;
import com.exampledto.dtoSpring.entity.Bike;
import com.exampledto.dtoSpring.repository.BikeRepository;
import com.exampledto.dtoSpring.services.BikeServices;
import org.springframework.stereotype.Service;

@Service
public class BikeServicesImpl implements BikeServices {

    private final BikeRepository bikeRepository;

    public BikeServicesImpl(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    @Override
    public BikeResponse getBikeById(int id) {
        Bike existing = bikeRepository.findById(id).orElseThrow(()-> new RuntimeException("book not found"));
        return entityToResponse(existing);
    }

    @Override
    public void deleteBike(int id) {
        bikeRepository.deleteById(id);
    }


    //this is used to add the book in the database and return the BikeResponse
    @Override
    public BikeResponse addBike(BikeRequest bikeRequest) {
        return entityToResponse(bikeRepository.save(requestToEntity(bikeRequest)));
    }


    //first it will be in the form of request so we have to change that into entity
    private Bike requestToEntity(BikeRequest bikeRequest){
        Bike bike = new Bike();
        bike.setName(bikeRequest.getName());
        bike.setCompany(bikeRequest.getCompany());
        bike.setPrice(bikeRequest.getPrice());

        return bike;
    }

    //when the request is converted into entity we have to change that entity into response so for that
    private BikeResponse entityToResponse(Bike bike){
        return BikeResponse.builder()
                .id(bike.getId())
                .name(bike.getName())
                .company(bike.getCompany())
                .price(bike.getPrice())
                .build();
    }


}
