/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import dao.PartsDAO;
import exceptions.ValidationException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NGHIA
 */
public class PartsDTO{
    private String partID;
    private String partName;
    private String purchasePrice;
    private String retailPrice;
    
    public PartsDTO(String partID, String partName, String purchasePrice, String retailPrice){
        this.partID = partID;
        this.partName = partName;
        this.purchasePrice = purchasePrice;
        this.retailPrice = retailPrice;
    }
    
    public void validateUpdate() throws ValidationException{
        HashMap<String,String> errors = new HashMap<>();

        //validate name
        if (partName == null || partName.trim().isEmpty()) errors.put("partName", "Part name cannot be empty.");
        
        // validate price
        try {
            double priceValue = Double.valueOf(purchasePrice);
            if (priceValue <= 0) {
                errors.put("purchasePrice", "Purchase price must be greater than 0.");
            }
        } catch (NumberFormatException e) {
            errors.put("purchasePrice", "Purchase price must be a valid number.");
        }
        
        try {
            double priceValue = Double.valueOf(retailPrice);
            if (priceValue <= 0) {
                errors.put("retailPrice", "Retail price must be greater than 0.");
            }
        } catch (NumberFormatException e) {
            errors.put("retailPrice", "Retail price must be a valid number.");
        }
        
        
        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }

    public void validate() throws ValidationException, ClassNotFoundException, SQLException {
         HashMap<String,String> errors = new HashMap<>();

        //validate id
        try {
            PartsDAO partsDAO = new PartsDAO();
            long idValue = Long.parseLong(partID);
            if (idValue <= 0) {
                errors.put("partID", "Part ID must be greater than 0.");
            }
            if(partsDAO.getPartById(idValue)!=null) errors.put("partID", "Part ID has already existed");
        } catch (NumberFormatException e) {
            errors.put("partID", "Part ID must be an integer.");
        } 
         
        //validate name
        if (partName == null || partName.trim().isEmpty()) errors.put("partName", "Part name cannot be empty.");
        
        // validate price
        try {
            double priceValue = Double.valueOf(purchasePrice);
            if (priceValue <= 0) {
                errors.put("purchasePrice", "Purchase price must be greater than 0.");
            }
        } catch (NumberFormatException e) {
            errors.put("purchasePrice", "Purchase price must be a valid number.");
        }
        
        try {
            double priceValue = Double.valueOf(retailPrice);
            if (priceValue <= 0) {
                errors.put("retailPrice", "Retail price must be greater than 0.");
            }
        } catch (NumberFormatException e) {
            errors.put("retailPrice", "Retail price must be a valid number.");
        }
        
        
        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }
    
}
