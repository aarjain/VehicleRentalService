package com.company.dto.vehicle;


public class SedanVehicle extends Vehicle {
    public SedanVehicle(String licenseNumber, String branch) {
        this.licenseNumber = licenseNumber;
        this.branch = branch;
        this.vehicleType = VehicleType.SEDAN;
    }


}
