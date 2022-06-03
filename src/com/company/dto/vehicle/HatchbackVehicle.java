package com.company.dto.vehicle;

import com.company.dto.booking.Booking;
import com.company.pricemanager.PriceManager;

import java.util.List;

public class HatchbackVehicle extends Vehicle {
    private VehicleType vehicleType = VehicleType.HATCHBACK;
    public HatchbackVehicle(String licenseNumber, String branch) {
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
