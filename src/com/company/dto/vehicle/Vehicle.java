package com.company.dto.vehicle;

import com.company.dto.booking.Booking;
import com.company.pricemanager.PriceManager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {
    VehicleType vehicleType;
    String licenseNumber;
    String branch;
    List<Booking> bookings = new ArrayList<>();
    public VehicleStatus getVehicleStatusInTimeSlot(LocalDateTime startTime, LocalDateTime endTime) {
        for(Booking booking: bookings) {
            if(startTime.isAfter(booking.getStartTime()) && startTime.isBefore( booking.getEndTime()) ||
                    endTime.isAfter(booking.getStartTime()) && endTime.isBefore(booking.getEndTime())) {
                return VehicleStatus.BOOKED;
            }
        }
        return VehicleStatus.AVAILABLE;
    }
    public void addBooking(Booking booking) {
        bookings.add(booking);
    }
    public int getPrice() {
        return PriceManager.getInstance().getPrice(vehicleType,branch);
    }
    public String getLicenseNumber() {
        return licenseNumber;
    }

    public String getBranch() {
        return branch;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
