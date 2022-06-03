package com.company.pricingservice.data;

import com.company.dto.util.VehicleBranchPrice;
import com.company.dto.vehicle.VehicleType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PricingData {
    private static Map<VehicleType, List<VehicleBranchPrice>> vehicleTypeListMap = new HashMap<>();

    public List<VehicleBranchPrice>getPriceListByType(VehicleType vehicleType) {
        return vehicleTypeListMap.getOrDefault(vehicleType,new ArrayList<>());
    }

    public void addPrice(VehicleType vehicleType, String branchName, int price) {
        boolean inserted = false;
        List<VehicleBranchPrice> vehicleBranchPrices = getPriceListByType(vehicleType);
        if(!vehicleBranchPrices.isEmpty()) {
            for (VehicleBranchPrice vehicleBranchPrice : vehicleBranchPrices) {
                if (branchName.equals(vehicleBranchPrice.getBranchName())) {
                    vehicleBranchPrice.setPrice(price);
                    inserted = true;
                }
            }
            if(!inserted)
                vehicleBranchPrices.add(new VehicleBranchPrice(branchName,price));
        }
        else {
            vehicleBranchPrices.add(new VehicleBranchPrice(branchName,price));
            vehicleTypeListMap.put(vehicleType,vehicleBranchPrices);
        }
    }
    public int getPrice(VehicleType vehicleType, String branchName) {
        List<VehicleBranchPrice> vehicleBranchPrices = getPriceListByType(vehicleType);
        if(!vehicleBranchPrices.isEmpty()) {
            for (VehicleBranchPrice vehicleBranchPrice : vehicleBranchPrices) {
                if (branchName.equals(vehicleBranchPrice.getBranchName()))
                    return vehicleBranchPrice.getPrice();
            }
        }
        throw new RuntimeException("No pricing data found for vehicle type and branch");
    }
}
