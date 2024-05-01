package com.MVRGroup.controller;

import com.MVRGroup.Service.ServiceService;
import com.MVRGroup.entity.RawmaterialEntity;
import com.MVRGroup.entity.ServiceEntity;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

@Controller
public class ServiceController {

	
	private final ServiceService serviceService;

    @Autowired
    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    
    @GetMapping("/serviceDetails")
    public ResponseEntity<List<ServiceEntity>> viewAllServices() {
        List<ServiceEntity> services = serviceService.getAllServices();
        return new ResponseEntity<>(services, HttpStatus.OK);
    }

	@GetMapping("/service")
	public String viewServicePage() {
	    return "service";
	}

	@GetMapping("/admin_dashboard")
	public String viewServiceAdminDashboardPage() {
	    return "admin_dashboard";
	}
	
	@GetMapping("/tailoring")
	public String viewtailoringPage() {
	    return "tailoring";
	}
	@GetMapping("/painting")
	public String viewpaintingPage() {
	    return "painting";
	}
	
	 @GetMapping("/sendvideostoemail")
	    public String handleFormSubmission(@RequestParam("selectedVideos") String[] selectedVideos,
	                                       @RequestParam("selectedEmail") String[] selectedEmail) {
	        return "redirect:/successPage";
	    }
	 @GetMapping("/crafting_diversity")
		public String viewcrafting_diversityPage() {
		    return "crafting_diversity";
		}
	 @GetMapping("/chemical_creations")
		public String viewchemical_creaionsPage() {
		    return "chemical_creations";
		}
	 
	  //  VIEW
	    @RequestMapping(value = "/service_add", method = RequestMethod.GET)
	    public String showAddRawmaterialForm() {
	        return "service_add"; // Assuming this is the view name to display the form
	    }
	 
	    // STORE DATA
		/*
		 * @RequestMapping(value = "/serviceadd", method = RequestMethod.POST, consumes
		 * = "application/json") public ResponseEntity<String> addservice(@RequestBody
		 * ServiceEntity s) { serviceService.saveService(s); return
		 * ResponseEntity.ok("service added successfully"); // Redirect to GET mapping
		 * to show the form again or any appropriate view }
		 */
	    
	 // STORE DATA	    
	    @PostMapping("/serviceadd")
	    public String addService(@RequestParam("file") MultipartFile file,
	                             @RequestParam("serviceName") String serviceName,
	                             @RequestParam("url") String url) {
	        try {
	            // Save the file to the assets folder
	            String uploadDirectory = System.getProperty("user.dir") + "/src/main/webapp/assets";
	            String fileName = file.getOriginalFilename();
	            File destFile = new File(uploadDirectory + File.separator + fileName);
	            file.transferTo(destFile);

	            // Set the imageUrl to the file name
	            String imageUrl = fileName;

	            // Create a new ServiceEntity object and set its attributes
	            ServiceEntity serviceEntity = new ServiceEntity();
	            serviceEntity.setServiceName(serviceName);
	            serviceEntity.setUrl(url);
	            serviceEntity.setImageUrl(imageUrl);

	            // Save the ServiceEntity object to the database
	            serviceService.saveService(serviceEntity);

	            // Redirect to a success page or return success message
	            return "redirect:/service";
	        } catch (IOException e) {
	            e.printStackTrace();
	            // Handle error
	            return "error";
	        }
	    }

	    
	  @PostMapping("/servicedelete")
	    public String Servicedelete(@RequestParam int serviceId)
		{
		  serviceService.DeleteService(serviceId);
		 return "redirect:/service";
		}
	  
	  @GetMapping("/service_edit")
		public String viewservice_editPage() {
		    return "service_edit";
		}
		/*
		 * @PostMapping("/serviceedit") public String serviceeditedit(@RequestParam
		 * String service_id,
		 * 
		 * @RequestParam String image_url,
		 * 
		 * @RequestParam String service_name,
		 * 
		 * @RequestParam String url) { ServiceEntity rawmaterial = new ServiceEntity();
		 * rawmaterial.setServiceId(Integer.parseInt(service_id));
		 * rawmaterial.setServiceName(service_name); rawmaterial.setImageUrl(image_url);
		 * rawmaterial.setUrl(url);
		 * 
		 * serviceService.EditService(rawmaterial);
		 * 
		 * // Redirect to the raw material page return "redirect:/service"; }
		 */
	  
	  @PostMapping("/serviceedit")
	  public String serviceeditedit(@RequestParam String service_id,
	                                @RequestParam String image_url,
	                                @RequestParam String service_name,
	                                @RequestParam(value = "file", required = false) MultipartFile file,
	                                @RequestParam String url)  {
	      String fileName = null; // Initialize fileName
	      
	      // Check if file is not null and not empty
	      if (file != null && !file.isEmpty()) {
	          try {
	              // Define upload directory and save the file
	              String uploadDirectory = System.getProperty("user.dir") + "/src/main/webapp/assets";
	              fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename(); // Generate unique file name
	              File destFile = new File(uploadDirectory + File.separator + fileName);
	              file.transferTo(destFile);
	          } catch (IOException e) {
	              e.printStackTrace(); // Handle file transfer exception if needed
	          }
	      }
	      
	      // Set the imageUrl to the file name if file is uploaded, otherwise keep the existing image URL
	      String imageUrl = (fileName != null) ? fileName : image_url;

	      ServiceEntity rawmaterial = new ServiceEntity();
	      rawmaterial.setServiceId(Integer.parseInt(service_id));
	      rawmaterial.setServiceName(service_name);
	      rawmaterial.setImageUrl(imageUrl);
	      rawmaterial.setUrl(url);

	      serviceService.EditService(rawmaterial);

	      // Redirect to the service page
	      return "redirect:/service";
	  }

	 
}
