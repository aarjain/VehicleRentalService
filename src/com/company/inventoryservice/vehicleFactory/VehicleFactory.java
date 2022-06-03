package com.company.inventoryservice.vehicleFactory;

import com.company.dto.vehicle.HatchbackVehicle;
import com.company.dto.vehicle.SedanVehicle;
import com.company.dto.vehicle.SuvVehicle;
import com.company.dto.vehicle.Vehicle;
import com.company.dto.vehicle.VehicleType;

public class VehicleFactory {
    public Vehicle getVehicle(String licenseNumber, VehicleType vehicleType, String branchName) {
        Vehicle vehicle = null;
        if(VehicleType.SEDAN.equals(vehicleType))
            vehicle = new SedanVehicle(licenseNumber,branchName);
        else if(VehicleType.HATCHBACK.equals(vehicleType))
            vehicle = new HatchbackVehicle(licenseNumber,branchName);
        else if(VehicleType.SUV.equals(vehicleType))
            vehicle = new SuvVehicle(licenseNumber,branchName);
        return vehicle;
    }
}
