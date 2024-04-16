package com.MVRGroup.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.MVRGroup.Service.SubSubServiceService;
import com.MVRGroup.entity.SubSubServiceEntity;
@Controller
public class SubSubServiceController {

	
	
	private final SubSubServiceService subsubserviceService;

    @Autowired
    public SubSubServiceController(SubSubServiceService subsubserviceService) {
        this.subsubserviceService = subsubserviceService;
    }

	
	
    @GetMapping("/subsubserviceDetails")
    public ResponseEntity<List<SubSubServiceEntity>> viewSubSubServicesByServiceId(@RequestParam(required = false) Integer subserviceId) {
        // Check if serviceId is provided
        if (subserviceId != null ) {
            // Retrieve sub-services based on the provided serviceId
            List<SubSubServiceEntity> subsubservices = subsubserviceService.getSubSubServicesBySubServiceId(subserviceId);
            return new ResponseEntity<>(subsubservices, HttpStatus.OK);
        } else {
            // If serviceId is not provided, return all sub-services
            List<SubSubServiceEntity> allSubSubservices = subsubserviceService.getAllSubSubServices();
            return new ResponseEntity<>(allSubSubservices, HttpStatus.OK);
        }
    }
    

	
    @GetMapping("/subsubservice")
	public String viewServicePage() {
	    return "subsubservice";
	}
	


    @PostMapping("/subsubserviceadd")
    public String addService(@RequestParam("url") String url,
                             @RequestParam("title") String title,
                             @RequestParam("subserviceId") Integer subserviceId) {
        SubSubServiceEntity subservice = new SubSubServiceEntity();
		subservice.setUrl(url);
		subservice.setTitle(title);
		subservice.setSubserviceId(subserviceId);

		subsubserviceService.saveSubSubService(subservice);

		// Redirect to a success page or return success message
		return "redirect:/subsubservice";
    }
    
    
    @PostMapping("/subsubservicedelete")
    public String SubSubServicedelete(@RequestParam int subsubserviceId)
	{
	  subsubserviceService.DeleteSubSubService(subsubserviceId);
	 return "redirect:/service";
	}
    
    @GetMapping("/subsubservice_edit")
	public String viewservice_editPage() {
	    return "subsubservice_edit";
	}
   
    
    @PostMapping("/subsubserviceedit")
    public String serviceeditedit(@RequestParam Integer subsubserviceId,
                                   @RequestParam String url,
                                   @RequestParam String title,
                                   @RequestParam Integer subserviceId) {
        try {
            
        	SubSubServiceEntity subserviceEntity = new SubSubServiceEntity();
            subserviceEntity.setUrl(url);
            subserviceEntity.setTitle(title);
            subserviceEntity.setSubserviceId(subserviceId);
            subserviceEntity.setSubsubserviceId(subsubserviceId);

            subsubserviceService.EditSubSubService(subserviceEntity);

            // Redirect to the service page
            return "redirect:/service";
        } catch (NumberFormatException e) {
            e.printStackTrace(); // Log the exception
            // Handle the exception appropriately, e.g., show error message to the user
            return "error-page"; // Redirect to an error page
        }
    }
    
}




