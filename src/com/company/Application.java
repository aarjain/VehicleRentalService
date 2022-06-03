package com.company;

import com.company.dto.vehicle.VehicleType;
import com.company.vehicleRentalService.VehicleRentalService;

import java.time.LocalDateTime;
import java.time.Month;

public class Application {

    public static void main(String[] args) {
	// write your code here
        VehicleRentalService vehicleRentalService = VehicleRentalService.getInstance();
        vehicleRentalService.addBranch("CP");
        vehicleRentalService.addBranch("Janakpuri");
        vehicleRentalService.addVehicle("DL 10", VehicleType.HATCHBACK,"CP");
        vehicleRentalService.addVehicle("DL 11", VehicleType.SEDAN,"Janakpuri");
        vehicleRentalService.addVehicle("DL 12", VehicleType.SEDAN,"CP");
        vehicleRentalService.addVehicle("DL 13", VehicleType.SUV,"CP");
        vehicleRentalService.allocatePrice("Janakpuri",VehicleType.SEDAN,100);
        vehicleRentalService.allocatePrice("CP",VehicleType.HATCHBACK,70);
        vehicleRentalService.allocatePrice("CP",VehicleType.SEDAN,90);
        vehicleRentalService.bookVehicle(VehicleType.SEDAN,
                LocalDateTime.of(2022, Month.JUNE,3,12,0),
                LocalDateTime.of(2022, Month.JUNE,3,13,0));
        vehicleRentalService.bookVehicle(VehicleType.SEDAN,
                LocalDateTime.of(2022, Month.JUNE,3,12,30),
                LocalDateTime.of(2022, Month.JUNE,3,13,30));
        vehicleRentalService.bookVehicle(VehicleType.SEDAN,
                LocalDateTime.of(2022, Month.JUNE,3,12,35),
                LocalDateTime.of(2022, Month.JUNE,3,13,30));
        //vehicleRentalService.allocatePrice("Janakpuri",VehicleType.SEDAN,70);
        vehicleRentalService.bookVehicle(VehicleType.SEDAN,
                LocalDateTime.of(2022, Month.JUNE,4,12,0),
                LocalDateTime.of(2022, Month.JUNE,4,13,0));
        vehicleRentalService.viewInventory( LocalDateTime.of(2022, Month.JUNE,3,12,31),
                LocalDateTime.of(2022, Month.JUNE,3,13,30));

    }
}
