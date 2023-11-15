package ma.camara.camara.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.camara.camara.entities.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service,Long>{
    
}
