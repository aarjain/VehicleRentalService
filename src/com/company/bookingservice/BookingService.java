package com.company.bookingservice;


import com.company.dto.booking.Booking;
import com.company.dto.vehicle.Vehicle;
import com.company.dto.vehicle.VehicleType;
import com.company.inventoryservice.InventoryService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class BookingService {
    private static BookingService instance = null;
    InventoryService inventoryService = InventoryService.getInstance();

    private BookingService(){}

    public static BookingService getInstance() {
        if(instance == null)
            return new BookingService();
        return instance;
    }

    public Optional<Vehicle> bookBestAvailableVehicle(VehicleType vehicleType, LocalDateTime startTime,
                                                      LocalDateTime endTime, BookingStrategy bookingStrategy) {
        List<Vehicle> vehicles = inventoryService.getAvailableVehiclesInTimeSlot(vehicleType, startTime,endTime);
        Optional<Vehicle> opVehicle =  bookingStrategy.getBestAvailableVehicle(vehicles);
        if(opVehicle.isEmpty()) {
            System.out.println("No vehicle available for this time slot");
            return opVehicle;
        }
        Vehicle vehicle = opVehicle.get();
        vehicle.addBooking(new Booking(vehicle,startTime,endTime));
        System.out.println("Vehicle Booked: "+vehicle.getLicenseNumber()+" "+vehicle.getBranch());
        return opVehicle;
    }
}
