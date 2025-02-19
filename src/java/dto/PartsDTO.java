/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import exceptions.ValidationError;
import exceptions.ValidationException;
import java.util.HashMap;

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

    public void validate() throws ValidationException {
         HashMap<String,String> errors = new HashMap<>();

        //validate id
        try {
            int idValue = Integer.parseInt(partID);
            if (idValue <= 0) {
                errors.put("id", "Part ID must be greater than 0.");
            }
        } catch (NumberFormatException e) {
            errors.put("id", "Part ID must be an integer.");
        }
         
        //validate name
        if (partName == null || partName.trim().isEmpty()) errors.put("name", "Part name cannot be empty.");
        
        // validate price
        try {
            double priceValue = Double.valueOf(purchasePrice);
            if (priceValue <= 0) {
                errors.put("purchasePrice", "Purchase price must be greater than 0.");
            }
        } catch (NumberFormatException e) {
            errors.put("price", "Purchase price must be a valid number.");
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
