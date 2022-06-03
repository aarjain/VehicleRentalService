package com.company.inventoryservice.data;

import com.company.dto.vehicle.Vehicle;
import com.company.dto.vehicle.VehicleType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryData {
    private static Map<VehicleType, List<Vehicle>> vehicleTypeListMap = new HashMap<>();
    public List<Vehicle> getVehiclesByType(VehicleType vehicleType) {
        return vehicleTypeListMap.getOrDefault(vehicleType, new ArrayList<>());
    }

    public Map<VehicleType, List<Vehicle>> getInventory() {
        return vehicleTypeListMap;
    }

    public void addVehicle(Vehicle vehicle) {
        List<Vehicle> vehiclesByType = getVehiclesByType(vehicle.getVehicleType());
        vehiclesByType.add(vehicle);
        vehicleTypeListMap.put(vehicle.getVehicleType(),vehiclesByType);
    }
}
