package com.company.inventorymanager;

import com.company.dto.vehicle.Vehicle;
import com.company.dto.vehicle.VehicleStatus;
import com.company.dto.vehicle.VehicleType;
import com.company.inventorymanager.vehicleFactory.VehicleFactory;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryManager {
    private static InventoryManager instance = null;
    private final VehicleFactory vehicleFactory = new VehicleFactory();
    private InventoryManager() {}
    public static InventoryManager getInstance() {
        if(instance == null)
            return new InventoryManager();
        else
            return instance;
    }
    private static Map<VehicleType,List<Vehicle>>vehicleTypeListMap = new HashMap<>();
    public void addVehicle(String licenseNumber, VehicleType vehicleType, String branchName) {
        Vehicle vehicle = vehicleFactory.getVehicle(licenseNumber,vehicleType,branchName);
        if(vehicleTypeListMap.containsKey(vehicleType))
            vehicleTypeListMap.get(vehicleType).add(vehicle);
        else {
            List<Vehicle> vehicles = new ArrayList<>();
            vehicles.add(vehicle);
            vehicleTypeListMap.putIfAbsent(vehicleType,vehicles);
        }
        System.out.println("New vehicle added: "+vehicle.getLicenseNumber()+" "+vehicle.getVehicleType().name());
    }
    public List<Vehicle> getVehiclesOfType(VehicleType vehicleType) {
        return vehicleTypeListMap.get(vehicleType);
    }
    public List<Vehicle> getAvailableVehiclesInTimeSlot(VehicleType vehicleType,
                                                        LocalDateTime startTime, LocalDateTime endTime) {
        List<Vehicle> vehicles = getVehiclesOfType(vehicleType);
        List<Vehicle> availableVehicles = new ArrayList<>();
        for(Vehicle vehicle: vehicles) {
            if(vehicle.getVehicleStatusInTimeSlot(startTime,endTime) == VehicleStatus.AVAILABLE)
                availableVehicles.add(vehicle);
        }
        return availableVehicles;
    }

    public void viewInventory(LocalDateTime startTime, LocalDateTime endTime) {
        if(!vehicleTypeListMap.isEmpty()) {
            System.out.println("Vehicle Inventory Details: ");
            for (Map.Entry<VehicleType, List<Vehicle>> entry : vehicleTypeListMap.entrySet()) {
                VehicleType vehicleType = entry.getKey();
                List<Vehicle> vehicles = entry.getValue();
                for (Vehicle vehicle : vehicles) {
                    VehicleStatus vehicleStatus = vehicle.getVehicleStatusInTimeSlot(startTime, endTime);
                    System.out.println("Branch: " + vehicle.getBranch() +
                            " Vehicle Type: " + vehicleType.name() + " License: "
                            + vehicle.getLicenseNumber() + " Status: " + vehicleStatus.name());
                }
            }
        }
    }

}
