package com.company.pricemanager;

import com.company.dto.vehicle.Vehicle;
import com.company.dto.vehicle.VehicleType;

import javax.crypto.AEADBadTagException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PriceManager {
    private static PriceManager instance = null;
    private class VehicleBranchPrice {
        private String branchName;
        private int price;
        public VehicleBranchPrice(String branchName, int price) {
            this.branchName = branchName;
            this.price = price;
        }

        public String getBranchName() {
            return branchName;
        }

        public void setPrice(int price) {
            this.price = price;
        }
        public int getPrice() {
            return price;
        }
    }
    private PriceManager() {}
    public static PriceManager getInstance() {
        if(instance == null)
            return new PriceManager();
        return instance;
    }
    private static Map<VehicleType, List<VehicleBranchPrice>> vehicleTypeListMap = new HashMap<>();

    public void allocatePrice(String branchName, VehicleType vehicleType, Integer price) {
        if(vehicleTypeListMap.containsKey(vehicleType)) {
            List<VehicleBranchPrice> vehicleBranchPrices = vehicleTypeListMap.get(vehicleType);
            for (VehicleBranchPrice vehicleBranchPrice : vehicleBranchPrices) {
                if (branchName.equals(vehicleBranchPrice.getBranchName())) {
                    vehicleBranchPrice.setPrice(price);
                    return;
                }
            }
            vehicleBranchPrices.add(new VehicleBranchPrice(branchName, price));
        }
        else {
            List<VehicleBranchPrice> vehicleBranchPrices = new ArrayList<>();
            vehicleBranchPrices.add(new VehicleBranchPrice(branchName,price));
            vehicleTypeListMap.put(vehicleType,vehicleBranchPrices);
        }
    }
    public int getPrice(VehicleType vehicleType, String branchName) {
        if(vehicleTypeListMap.containsKey(vehicleType)) {
            List<VehicleBranchPrice> vehicleBranchPrices = vehicleTypeListMap.get(vehicleType);
            for (VehicleBranchPrice vehicleBranchPrice : vehicleBranchPrices) {
                if (branchName.equals(vehicleBranchPrice.getBranchName()))
                    return vehicleBranchPrice.getPrice();
            }
        }
        throw new RuntimeException("Illegal Branch Name Specified");
    }

}
