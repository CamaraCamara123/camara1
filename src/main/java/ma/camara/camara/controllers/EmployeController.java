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

import ma.camara.camara.entities.Employe;
import ma.camara.camara.entities.Service;
import ma.camara.camara.services.EmployeService;

@RestController
@RequestMapping("/employes")
public class EmployeController {
    @Autowired
	private EmployeService employeService;
	

	@GetMapping
	public List<Employe> findAllemploye(){
		return employeService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable Long id) {
		Employe employe = employeService.findById(id);
		if(employe == null) {
			return new ResponseEntity<Object>("employe with ID " + id + " not found", HttpStatus.BAD_REQUEST);
		}
		else {
			return ResponseEntity.ok(employe);
		}
	}
	
	@PostMapping
	public Employe createemploye(@RequestBody Employe employe) {
		employe.setId(0L);
		return employeService.create(employe);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateemploye(@PathVariable Long id,@RequestBody Employe employe) {
//		employe employe = employeService.findById(id);
		if(employeService.findById(id) == null) {
			return new ResponseEntity<Object>("employe with ID " + id + " not found", HttpStatus.BAD_REQUEST);
		}
		else {
			employe.setId(id);
			return ResponseEntity.ok(employeService.update(employe));
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteemploye(@PathVariable Long id){
		Employe employe = employeService.findById(id);
		if(employe == null) {
			return new ResponseEntity<Object>("employe with ID " + id + " not found", HttpStatus.BAD_REQUEST);
		}
		else {
			employeService.delete(employe);
			return ResponseEntity.ok("employe has been deleted");
		}
	}

    @GetMapping("/service")
    public List<Employe> findProfesseurBySpecialite(@RequestBody Service service) {
        return employeService.findByService(service);
    }
}
