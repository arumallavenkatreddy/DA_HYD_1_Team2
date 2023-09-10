package com.interlet.user.employee.dao.impl;

import com.interlet.beans.User;
import com.interlet.beans.Asset;
import com.interlet.exceptions.EmailFormatException;
import com.interlet.exceptions.EmployeeAlreadyExistException;
import com.interlet.exceptions.OverDueAssetFoundException;
import com.interlet.user.employee.dao.EmployeeDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

public class EmployeeDaoImpl implements EmployeeDao {
    private List<User> users = new ArrayList<>();
    private List<Asset> assets = new ArrayList<>();

    @Override
    public String registerEmployee(User user) throws EmployeeAlreadyExistException, EmailFormatException {
        for (User existingUser : users) {
            if (existingUser.getEmailId().equals(user.getEmailId())) {
                throw new EmployeeAlreadyExistException();
            }
        }

        if (!isValidEmailFormat(user.getEmailId())) {
            throw new EmailFormatException();
        }

        int uniqueUserId = generateUniqueUserId();

        user.setUserId(uniqueUserId);
        users.add(user);

        return "Employee registered successfully with user ID: " + uniqueUserId;
    }

    @Override
    public String borrowAsset(String type, String assetName) throws OverDueAssetFoundException {
        // Search for the asset by type and name in the list of assets
        Asset foundAsset = null;
        for (Asset asset : assets) {
            if (asset.getAssetType().equals(type) && asset.getAssetName().equals(assetName)) {
                foundAsset = asset;
                break;
            }
        }

        if (foundAsset == null) {
            return "Asset not found";
        }

        if (!foundAsset.getIsAvailable()) {
            return "Asset is already borrowed";
        }

       
        if (isAssetOverdue(foundAsset)) {
            throw new OverDueAssetFoundException();
        }

        foundAsset.setIsAvailable(false); 
        foundAsset.setDateBorrowed(new Date());

        return "Asset borrowed successfully";
    }

    private boolean isValidEmailFormat(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    private int generateUniqueUserId() {
        Random random = new Random();
        return random.nextInt(10000); 
    }

private boolean isAssetOverdue(Asset asset) {
    Date currentDate = new Date(); 
    Date dueDate = asset.getDueDate();

    if (dueDate != null && currentDate.after(dueDate)) {
        return true;
    }
    return false;
}
}
