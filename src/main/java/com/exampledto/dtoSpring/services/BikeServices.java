package com.exampledto.dtoSpring.services;

import com.exampledto.dtoSpring.dto.BikeRequest;
import com.exampledto.dtoSpring.dto.BikeResponse;

public interface BikeServices {
    BikeResponse addBike(BikeRequest bikeRequest);
}
