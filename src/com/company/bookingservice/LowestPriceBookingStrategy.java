package com.company.bookingservice;

import com.company.dto.vehicle.Vehicle;

import java.util.List;
import java.util.Optional;

public class LowestPriceBookingStrategy implements BookingStrategy {
    @Override
    public Optional<Vehicle> getBestAvailableVehicle(List<Vehicle> vehicleList) {
        int minPrice = Integer.MAX_VALUE;
        Optional<Vehicle> bestVehicle = Optional.empty();
        for(Vehicle vehicle: vehicleList) {
            int price = vehicle.getPrice();
            if(price < minPrice) {
                minPrice = price;
                bestVehicle = Optional.of(vehicle);
            }
        }
        return bestVehicle;
    }
}
