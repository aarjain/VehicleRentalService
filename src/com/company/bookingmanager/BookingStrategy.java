package com.company.bookingmanager;

import com.company.dto.vehicle.Vehicle;

import java.util.List;

public interface BookingStrategy {
    public Vehicle getBestAvailableVehicle(List<Vehicle> vehicleList);
}
