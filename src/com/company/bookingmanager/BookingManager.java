package com.company.bookingmanager;


import com.company.dto.booking.Booking;
import com.company.dto.vehicle.SedanVehicle;
import com.company.dto.vehicle.Vehicle;
import com.company.dto.vehicle.VehicleType;
import com.company.inventorymanager.InventoryManager;

import java.awt.print.Book;
import java.time.LocalDateTime;
import java.util.List;

public class BookingManager {
    private static BookingManager instance = null;
    InventoryManager inventoryManager = InventoryManager.getInstance();
    private BookingManager(){}

    public static BookingManager getInstance() {
        if(instance == null)
            return new BookingManager();
        return instance;
    }

    public Vehicle bookBestAvailableVehicle(VehicleType vehicleType, LocalDateTime startTime,
                                         LocalDateTime endTime, BookingStrategy bookingStrategy) {
        List<Vehicle> vehicles = inventoryManager.getAvailableVehiclesInTimeSlot(vehicleType, startTime,endTime);
        Vehicle vehicle =  bookingStrategy.getBestAvailableVehicle(vehicles);
        if(vehicle == null) {
            System.out.println("No vehicle available for this time slot");
            return null;
        }
        vehicle.addBooking(new Booking(vehicle,startTime,endTime));
        return vehicle;
    }
}
