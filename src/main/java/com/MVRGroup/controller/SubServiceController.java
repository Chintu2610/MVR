package com.MVRGroup.controller;



import com.MVRGroup.Service.SubServiceService;
import com.MVRGroup.entity.ServiceEntity;
import com.MVRGroup.entity.SubServiceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class SubServiceController {

	
	private final SubServiceService subserviceService;

    @Autowired
    public SubServiceController(SubServiceService subserviceService) {
        this.subserviceService = subserviceService;
    }

    
	/*
	 * @GetMapping("/subserviceDetails") public
	 * ResponseEntity<List<SubServiceEntity>> viewAllSubServices() {
	 * List<SubServiceEntity> subservices = subserviceService.getAllSubServices();
	 * return new ResponseEntity<>(subservices, HttpStatus.OK); }
	 */
    
    
    @GetMapping("/subserviceDetails")
    public ResponseEntity<List<SubServiceEntity>> viewSubServicesByServiceId(@RequestParam(required = false) Integer serviceId) {
        // Check if serviceId is provided
        if (serviceId != null ) {
            // Retrieve sub-services based on the provided serviceId
            List<SubServiceEntity> subservices = subserviceService.getSubServicesByServiceId(serviceId);
            return new ResponseEntity<>(subservices, HttpStatus.OK);
        } else {
            // If serviceId is not provided, return all sub-services
            List<SubServiceEntity> allSubservices = subserviceService.getAllSubServices();
            return new ResponseEntity<>(allSubservices, HttpStatus.OK);
        }
    }

	@GetMapping("/subservice")
	public String viewServicePage() {
	    return "subservice";
	}
	
	
	
	 // STORE DATA	    
    @PostMapping("/subserviceadd")
    public  String addService(@RequestParam("file") MultipartFile file,
                             @RequestParam("subservice_name") String subservice_name,
                             @RequestParam("service_id") Integer service_id) {
        try {
            // Save the file to the assets folder
            String uploadDirectory = System.getProperty("user.dir") + "/src/main/webapp/assets";
            String fileName = file.getOriginalFilename();
            File destFile = new File(uploadDirectory + File.separator + fileName);
            file.transferTo(destFile);

            // Set the imageUrl to the file name
            String imageUrl = fileName;

            // Create a new ServiceEntity object and set its attributes
            SubServiceEntity subserviceEntity = new SubServiceEntity();
            subserviceEntity.setSubserviceName(subservice_name);
            subserviceEntity.setServiceId(service_id);
            subserviceEntity.setImageUrl(imageUrl);

        
            subserviceService.saveSubService(subserviceEntity);

            // Redirect to a success page or return success message
            return "redirect:/subservice";
        } catch (IOException e) {
            e.printStackTrace();
            // Handle error
            return "error";
        }
    }
    @PostMapping("/subservicedelete")
    public String SubServicedelete(@RequestParam int subserviceId)
	{
	  subserviceService.DeleteSubService(subserviceId);
	 return "redirect:/service";
	}
    @GetMapping("/subservice_edit")
	public String viewservice_editPage() {
	    return "subservice_edit";
	}
    
    
	/*
	 * @PostMapping("/subserviceedit") public String serviceeditedit(@RequestParam
	 * String subservice_id,
	 * 
	 * @RequestParam String service_id,
	 * 
	 * @RequestParam String subservice_name,
	 * 
	 * @RequestParam String image_url,
	 * 
	 * @RequestParam(value = "file", required = false) MultipartFile file) { String
	 * fileName = null; // Initialize fileName
	 * 
	 * // Check if file is not null and not empty if (file != null &&
	 * !file.isEmpty()) { try { // Define upload directory and save the file String
	 * uploadDirectory = System.getProperty("user.dir") + "/src/main/webapp/assets";
	 * fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
	 * // Generate unique file name File destFile = new File(uploadDirectory +
	 * File.separator + fileName); file.transferTo(destFile); } catch (IOException
	 * e) { e.printStackTrace(); // Handle file transfer exception if needed } }
	 * 
	 * // Set the imageUrl to the file name if file is uploaded, otherwise keep the
	 * existing image URL String imageUrl = (fileName != null) ? fileName :
	 * image_url;
	 * 
	 * SubServiceEntity rawmaterial = new SubServiceEntity();
	 * rawmaterial.setServiceId(Integer.parseInt(service_id));
	 * rawmaterial.setSubserviceName(subservice_name);
	 * rawmaterial.setImageUrl(imageUrl);
	 * rawmaterial.setSubserviceId(Integer.parseInt(subservice_id));
	 * 
	 * subserviceService.EditSubService(rawmaterial);
	 * 
	 * // Redirect to the service page return "redirect:/service"; }
	 */
    @PostMapping("/subserviceedit")
    public String serviceeditedit(@RequestParam String subservice_id,
                                   @RequestParam String service_id,
                                   @RequestParam String subservice_name,
                                   @RequestParam String image_url,
                                   @RequestParam(value = "file", required = false) MultipartFile file) {
        try {
            String fileName = null; // Initialize fileName
            
            // Check if file is provided
            if (file != null && !file.isEmpty()) {
                // Generate unique file name
                fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
                
                // Define upload directory and save the file
                String uploadDirectory = System.getProperty("user.dir") + "/src/main/webapp/assets";
                File destFile = new File(uploadDirectory, fileName);
                file.transferTo(destFile);
            }

            // Set the imageUrl to the file name if file is uploaded, otherwise keep the existing image URL
            String imageUrl = (fileName != null) ? fileName : image_url;

            // Convert IDs to integers
            int subserviceId = Integer.parseInt(subservice_id);
            int serviceId = Integer.parseInt(service_id);

            // Create SubServiceEntity object
            SubServiceEntity rawmaterial = new SubServiceEntity();
            rawmaterial.setServiceId(serviceId);
            rawmaterial.setSubserviceName(subservice_name);
            rawmaterial.setImageUrl(imageUrl);
            rawmaterial.setSubserviceId(subserviceId);

            // Invoke service to edit subservice
            subserviceService.EditSubService(rawmaterial);

            // Redirect to the service page
            return "redirect:/service";
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace(); // Log the exception
            // Handle the exception appropriately, e.g., show error message to the user
            return "error-page"; // Redirect to an error page
        }
    }

}