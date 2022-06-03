package com.company.bookingservice;

import com.company.dto.vehicle.Vehicle;

import java.util.List;
import java.util.Optional;

public interface BookingStrategy {
    public Optional<Vehicle> getBestAvailableVehicle(List<Vehicle> vehicleList);
}
