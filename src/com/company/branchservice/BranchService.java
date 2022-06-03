package com.company.branchservice;

import com.company.branchservice.data.BranchData;
import com.company.dto.branch.Branch;

import java.util.Optional;

public class BranchService {
    private static BranchService instance = null;
    private BranchData branchData = new BranchData();
    private BranchService() {}
    public static BranchService getInstance() {
        if(instance == null)
            return new BranchService();
        else
            return instance;
    }
    public void addBranch(String branchName) {
        branchData.addBranch(branchName);
    }
    public Optional<Branch> getBranchIfExists(String branchName) {
        return branchData.getBranchIfExists(branchName);
    }
}
