package ma.camara.camara.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.camara.camara.entities.Employe;
import ma.camara.camara.entities.Service;

@Repository
public interface EmployeRepository extends JpaRepository<Employe,Long>{
	
	List<Employe> findByService(Service service);
}
