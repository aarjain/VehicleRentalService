package com.company.dto.vehicle;

import com.company.bookingservice.data.BookingData;
import com.company.dto.booking.Booking;
import com.company.pricingservice.PricingService;

import java.time.LocalDateTime;
import java.util.List;

public abstract class Vehicle {
    VehicleType vehicleType;
    String licenseNumber;
    String branch;
    BookingData bookingData = new BookingData();
    public VehicleStatus getVehicleStatusInTimeSlot(LocalDateTime startTime, LocalDateTime endTime) {
        List<Booking> bookings = bookingData.getBookingsForVehicle(this);
        for(Booking booking: bookings) {
            if(startTime.isAfter(booking.getStartTime()) && startTime.isBefore( booking.getEndTime()) ||
                    endTime.isAfter(booking.getStartTime()) && endTime.isBefore(booking.getEndTime())) {
                return VehicleStatus.BOOKED;
            }
        }
        return VehicleStatus.AVAILABLE;
    }
    public void addBooking(Booking booking) {
        bookingData.addBookingsForVehicle(this,booking);
    }
    public int getPrice() {
        return PricingService.getInstance().getPrice(vehicleType,branch);
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
