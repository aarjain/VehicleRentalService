package com.company.branchservice.data;

import com.company.dto.branch.Branch;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BranchData {
    private static List<Branch> branches = new ArrayList<>();
    public void addBranch(String branchName) {
        branches.add(new Branch(branchName));
    }
    public Optional<Branch> getBranchIfExists(String branchName) {
        Optional<Branch> opBranch = Optional.empty();
        for(Branch branch:branches) {
            if(branchName.equals(branch.getBranchName()))
                opBranch = Optional.of(branch);
        }
        return opBranch;
    }
}
