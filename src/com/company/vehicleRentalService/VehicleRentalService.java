package com.company.vehicleRentalService;

import com.company.bookingmanager.BookingManager;
import com.company.bookingmanager.LowestPriceBookingStrategy;
import com.company.branchmanager.BranchManager;
import com.company.dto.vehicle.Vehicle;
import com.company.dto.vehicle.VehicleType;
import com.company.inventorymanager.InventoryManager;
import com.company.pricemanager.PriceManager;

import java.time.LocalDateTime;

public class VehicleRentalService {
    private static VehicleRentalService instance = null;
    BranchManager branchManager = BranchManager.getInstance();
    InventoryManager inventoryManager = InventoryManager.getInstance();
    PriceManager priceManager = PriceManager.getInstance();
    BookingManager bookingManager = BookingManager.getInstance();
    private VehicleRentalService(){}
    public static VehicleRentalService getInstance() {
        if(instance == null)
            return new VehicleRentalService();
        else
            return instance;
    }
    public void addBranch(String branchName) {
        branchManager.addBranch(branchName);
    }
    public void addVehicle(String licenseNumber, VehicleType vehicleType, String branchName) {
        if(branchManager.getBranchIfExists(branchName) == null)
            throw new RuntimeException("Illegal Branch Name Supplied!");
        inventoryManager.addVehicle(licenseNumber,vehicleType,branchName);
    }

    public void allocatePrice(String branchName, VehicleType vehicleType, int price) {
        priceManager.allocatePrice(branchName,vehicleType,price);
    }

    public Vehicle bookVehicle(VehicleType vehicleType, LocalDateTime startTime, LocalDateTime endTime) {
        Vehicle bookedVehicle =  bookingManager.bookBestAvailableVehicle(
                vehicleType,startTime,endTime,new LowestPriceBookingStrategy());
        if(bookedVehicle!=null)
            System.out.println("Vehicle Booked: "+bookedVehicle.getLicenseNumber()+" "+bookedVehicle.getBranch());
        return bookedVehicle;
    }

    public void viewInventory(LocalDateTime startTime, LocalDateTime endTime) {
        inventoryManager.viewInventory(startTime,endTime);
    }

}
