package com.company.bookingservice.data;

import com.company.dto.booking.Booking;
import com.company.dto.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BookingData {
    Map<Vehicle, List<Booking>> vehicleBookingMap = new HashMap<>();
    public List<Booking> getBookingsForVehicle(Vehicle vehicle) {
        return vehicleBookingMap.getOrDefault(vehicle,new ArrayList<>());
    }
    public void addBookingsForVehicle(Vehicle vehicle, Booking booking) {
        List<Booking> bookings = getBookingsForVehicle(vehicle);
        bookings.add(booking);
        vehicleBookingMap.put(vehicle,bookings);
    }
}
