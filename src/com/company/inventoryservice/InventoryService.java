package com.company.inventoryservice;

import com.company.inventoryservice.data.InventoryData;
import com.company.dto.vehicle.Vehicle;
import com.company.dto.vehicle.VehicleStatus;
import com.company.dto.vehicle.VehicleType;
import com.company.inventoryservice.vehicleFactory.VehicleFactory;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InventoryService {
    private static InventoryService instance = null;
    private static InventoryData inventoryData = new InventoryData();
    private final VehicleFactory vehicleFactory = new VehicleFactory();
    private InventoryService() {}
    public static InventoryService getInstance() {
        if(instance == null)
            return new InventoryService();
        else
            return instance;
    }

    public void addVehicle(String licenseNumber, VehicleType vehicleType, String branchName) {
        Vehicle vehicle = vehicleFactory.getVehicle(licenseNumber,vehicleType,branchName);
        inventoryData.addVehicle(vehicle);
        System.out.println("New vehicle added: "+vehicle.getLicenseNumber()+" "+vehicle.getVehicleType().name());
    }

    public List<Vehicle> getAvailableVehiclesInTimeSlot(VehicleType vehicleType,
                                                        LocalDateTime startTime, LocalDateTime endTime) {
        List<Vehicle> vehicles = inventoryData.getVehiclesByType(vehicleType);
        List<Vehicle> availableVehicles = new ArrayList<>();
        for(Vehicle vehicle: vehicles) {
            if(vehicle.getVehicleStatusInTimeSlot(startTime,endTime) == VehicleStatus.AVAILABLE)
                availableVehicles.add(vehicle);
        }
        return availableVehicles;
    }

    public void viewInventory(LocalDateTime startTime, LocalDateTime endTime) {
        Map<VehicleType,List<Vehicle>> vehicleTypeListMap = inventoryData.getInventory();
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
