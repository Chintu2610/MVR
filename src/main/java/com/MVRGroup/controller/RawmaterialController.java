package com.MVRGroup.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.MVRGroup.Service.RawmaterialService;
import com.MVRGroup.entity.RawmaterialEntity;
import com.MVRGroup.entity.User;

@Controller
public class RawmaterialController {

    @Autowired
    RawmaterialService rawmaterialService;

    // Method to show the raw material form VIEW
    @RequestMapping(value = "/rawmaterialadd", method = RequestMethod.GET)
    public String showAddRawmaterialForm() {
        return "redirect:/rawmaterial"; // Assuming this is the view name to display the form
    }

    // STORE DATA
    @RequestMapping(value = "/rawmaterialadd", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> addRawmaterial(@RequestBody RawmaterialEntity rawmaterial) {
        rawmaterialService.saveRawMaterial(rawmaterial);
        return ResponseEntity.ok("raw material added successfully");// Redirect to GET mapping to show the form again or any appropriate view
    }
    
    @RequestMapping(value = "/rawmaterial", method = RequestMethod.GET)
	public String viewdrawmaterialPage(ModelMap map)
	{
		return "rawmaterial";
	}
    
    //Retrieve DATA
    @RequestMapping(value = "/rawmaterialDetails", method = RequestMethod.GET)
	public ResponseEntity<List<RawmaterialEntity>> viewRMPage()
	{
		 try {
	            List<RawmaterialEntity> raw = rawmaterialService.getAllRawMaterials();
	            return ResponseEntity.ok(raw);
	        } catch (Exception e) {
	            // Log the exception for debugging purposes
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }	 
	}

	/*
	 * @PostMapping("/rawmaterialedit") public String Rawmaterialedit(@RequestParam
	 * String name,@RequestParam int rawMaterialID) {
	 * rawmaterialService.EditRawmaterial(name,rawMaterialID); return
	 * "redirect:/rawmaterial"; }
	*/
    
    @PostMapping("/rawmaterialedit")
    public String Rawmaterialedit(@RequestParam String rawMaterialID,
                                   @RequestParam String name,
                                   @RequestParam String description,
                                   @RequestParam String supplierName,
                                   @RequestParam String unitPrice,
                                   @RequestParam String quantityAvailable,
                                   @RequestParam String storageConditions,
                                   @RequestParam String expiryDate,
                                   @RequestParam String dateAdded)  {
        // Create a new RawmaterialEntity instance and set its properties
        RawmaterialEntity rawmaterial = new RawmaterialEntity();
        rawmaterial.setRawMaterialID(Integer.parseInt(rawMaterialID));
        rawmaterial.setName(name);
        rawmaterial.setDescription(description);
        rawmaterial.setSupplierName(supplierName);
        rawmaterial.setUnitPrice(Double.parseDouble(unitPrice));
        rawmaterial.setQuantityAvailable(Integer.parseInt(quantityAvailable));
        rawmaterial.setStorageConditions(storageConditions);
        // Convert date strings to Date objects
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            rawmaterial.setExpiryDate(dateFormat.parse(expiryDate));
            rawmaterial.setDateAdded(dateFormat.parse(dateAdded));
        } catch (ParseException e) {
            // Handle date parsing exception
            e.printStackTrace();
        }
        
        // Call the service method to edit the raw material
        rawmaterialService.EditRawmaterial(rawmaterial);
        
        // Redirect to the raw material page
        return "redirect:/rawmaterial";
    }

    
  @PostMapping("/rawmaterialdelete")
    public String Rawmaterialdelete(@RequestParam String rawMaterialID)
	{
	  rawmaterialService.DeleteRawmaterial(Integer.parseInt(rawMaterialID) );
	 return "redirect:/rawmaterial";
	}
}
