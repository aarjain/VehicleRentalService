package com.company.inventorymanager.vehicleFactory;

import com.company.dto.vehicle.HatchbackVehicle;
import com.company.dto.vehicle.SedanVehicle;
import com.company.dto.vehicle.SuvVehicle;
import com.company.dto.vehicle.Vehicle;
import com.company.dto.vehicle.VehicleType;

public class VehicleFactory {
    public Vehicle getVehicle(String licenseNumber, VehicleType vehicleType, String branchName) {
        if(vehicleType == VehicleType.SEDAN)
            return new SedanVehicle(licenseNumber,branchName);
        else if(vehicleType == VehicleType.HATCHBACK)
            return new HatchbackVehicle(licenseNumber,branchName);
        else if(vehicleType == VehicleType.SUV)
            return new SuvVehicle(licenseNumber,branchName);
        return null;
    }
}
