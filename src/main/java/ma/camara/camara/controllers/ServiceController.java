package ma.camara.camara.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.camara.camara.entities.Service;
import ma.camara.camara.services.ServiceService;

@RestController
@RequestMapping("/services")
public class ServiceController {
    @Autowired
	private ServiceService serviceService;
	

	@GetMapping
	public List<Service> findAllservice(){
		return serviceService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable Long id) {
		Service service = serviceService.findById(id);
		if(service == null) {
			return new ResponseEntity<Object>("service with ID " + id + " not found", HttpStatus.BAD_REQUEST);
		}
		else {
			return ResponseEntity.ok(service);
		}
	}
	
	@PostMapping
	public Service createservice(@RequestBody Service service) {
		service.setId(0L);
		return serviceService.create(service);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateservice(@PathVariable Long id,@RequestBody Service service) {
//		service service = serviceService.findById(id);
		if(serviceService.findById(id) == null) {
			return new ResponseEntity<Object>("service with ID " + id + " not found", HttpStatus.BAD_REQUEST);
		}
		else {
			service.setId(id);
			return ResponseEntity.ok(serviceService.update(service));
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteservice(@PathVariable Long id){
		Service service = serviceService.findById(id);
		if(service == null) {
			return new ResponseEntity<Object>("service with ID " + id + " not found", HttpStatus.BAD_REQUEST);
		}
		else {
			serviceService.delete(service);
			return ResponseEntity.ok("service has been deleted");
		}
	}
}
