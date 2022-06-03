package com.company.branchmanager;

import com.company.dto.branch.Branch;

import java.util.ArrayList;
import java.util.List;

public class BranchManager {
    private static BranchManager instance = null;
    private BranchManager() {}
    public static BranchManager getInstance() {
        if(instance == null)
            return new BranchManager();
        else
            return instance;
    }
    private static List<Branch> branches = new ArrayList<>();
    public void addBranch(String branchName) {
        branches.add(new Branch(branchName));
    }
    public Branch getBranchIfExists(String branchName) {
        for(Branch branch:branches) {
            if(branchName.equals(branch.getBranchName()))
                return branch;
        }
        return null;
    }
}
