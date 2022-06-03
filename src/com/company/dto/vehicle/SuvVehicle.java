package com.company.dto.vehicle;


public class SuvVehicle extends Vehicle {
    public SuvVehicle(String licenseNumber, String branch) {
        this.licenseNumber = licenseNumber;
        this.branch = branch;
        this.vehicleType = VehicleType.SUV;

    }

}
