package com.company.dto.util;

public class VehicleBranchPrice {
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
