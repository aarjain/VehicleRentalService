package com.company.dto.booking;

import com.company.dto.vehicle.Vehicle;

import java.time.LocalDateTime;

public class Booking {
    private Vehicle vehicle;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    public Booking(Vehicle vehicle, LocalDateTime startTime, LocalDateTime endTime) {
        this.vehicle = vehicle;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public LocalDateTime getStartTime() {
        return startTime;
    }
    public LocalDateTime getEndTime() {
        return endTime;
    }
}
