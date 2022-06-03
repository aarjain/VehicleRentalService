package com.company.vehicleRentalService;

import com.company.bookingservice.BookingService;
import com.company.bookingservice.LowestPriceBookingStrategy;
import com.company.branchservice.BranchService;
import com.company.dto.vehicle.Vehicle;
import com.company.dto.vehicle.VehicleType;
import com.company.inventoryservice.InventoryService;
import com.company.pricingservice.PricingService;

import java.time.LocalDateTime;
import java.util.Optional;

public class VehicleRentalService {
    private static VehicleRentalService instance = null;
    BranchService branchService = BranchService.getInstance();
    InventoryService inventoryService = InventoryService.getInstance();
    PricingService pricingService = PricingService.getInstance();
    BookingService bookingService = BookingService.getInstance();
    private VehicleRentalService(){}
    public static VehicleRentalService getInstance() {
        if(instance == null)
            return new VehicleRentalService();
        else
            return instance;
    }
    public void addBranch(String branchName) {
        branchService.addBranch(branchName);
    }
    public void addVehicle(String licenseNumber, VehicleType vehicleType, String branchName) {
        if(branchService.getBranchIfExists(branchName).isEmpty())
            throw new RuntimeException("Illegal Branch Name Supplied!");
        inventoryService.addVehicle(licenseNumber,vehicleType,branchName);
    }

    public void allocatePrice(String branchName, VehicleType vehicleType, int price) {
        pricingService.allocatePrice(branchName,vehicleType,price);
    }

    public Optional<Vehicle> bookVehicle(VehicleType vehicleType, LocalDateTime startTime, LocalDateTime endTime) {
        return bookingService.bookBestAvailableVehicle(
                vehicleType,startTime,endTime,new LowestPriceBookingStrategy());
    }

    public void viewInventory(LocalDateTime startTime, LocalDateTime endTime) {
        inventoryService.viewInventory(startTime,endTime);
    }

}
