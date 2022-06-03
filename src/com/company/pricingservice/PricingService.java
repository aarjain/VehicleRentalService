package com.company.pricingservice;

import com.company.pricingservice.data.PricingData;
import com.company.dto.vehicle.VehicleType;

public class PricingService {
    private static PricingService instance = null;
    private final PricingData pricingData = new PricingData();
    private PricingService() {}
    public static PricingService getInstance() {
        if(instance == null)
            return new PricingService();
        return instance;
    }


    public void allocatePrice(String branchName, VehicleType vehicleType, Integer price) {
       pricingData.addPrice(vehicleType,branchName,price);
    }
    public int getPrice(VehicleType vehicleType, String branchName) {
        return pricingData.getPrice(vehicleType,branchName);
    }

}
