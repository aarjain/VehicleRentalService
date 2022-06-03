package com.company.bookingmanager;

import com.company.dto.vehicle.Vehicle;

import java.util.List;

public class LowestPriceBookingStrategy implements BookingStrategy {
    @Override
    public Vehicle getBestAvailableVehicle(List<Vehicle> vehicleList) {
        int minPrice = Integer.MAX_VALUE;
        Vehicle bestVehicle = null;
        for(Vehicle vehicle: vehicleList) {
            int price = vehicle.getPrice();
            if(price < minPrice) {
                minPrice = price;
                bestVehicle = vehicle;
            }
        }
        return bestVehicle;
    }
}
