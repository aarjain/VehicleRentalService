package com.company.dto.vehicle;

import com.company.dto.booking.Booking;
import com.company.dto.vehicle.Vehicle;
import com.company.dto.vehicle.VehicleType;
import com.company.pricemanager.PriceManager;

import java.util.List;

public class SedanVehicle extends Vehicle {
    private VehicleType vehicleType = VehicleType.SEDAN;
    public SedanVehicle(String licenseNumber, String branch) {
        this.licenseNumber = licenseNumber;
        this.branch = branch;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }


    public String getLicenseNumber() {
        return licenseNumber;
    }
    @Override
    public int getPrice() {
        return PriceManager.getInstance().getPrice(vehicleType,branch);
    }

    public String getBranch() {
        return branch;
    }


    public List<Booking> getBookings() {
        return bookings;
    }
}
