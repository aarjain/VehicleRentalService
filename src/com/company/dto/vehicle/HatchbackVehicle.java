package com.company.dto.vehicle;


public class HatchbackVehicle extends Vehicle {
    public HatchbackVehicle(String licenseNumber, String branch) {
        this.licenseNumber = licenseNumber;
        this.branch = branch;
        this.vehicleType = VehicleType.HATCHBACK;
    }
}
