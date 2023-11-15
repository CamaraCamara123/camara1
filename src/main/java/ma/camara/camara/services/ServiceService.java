package ma.camara.camara.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.camara.camara.dao.IDao;
import ma.camara.camara.repositories.ServiceRepository;

@Service
public class ServiceService implements IDao<ma.camara.camara.entities.Service>{

    @Autowired
    ServiceRepository serviceRepository;
    @Override
    public ma.camara.camara.entities.Service create(ma.camara.camara.entities.Service o) {
        return serviceRepository.save(o);
    }

    @Override
    public boolean delete(ma.camara.camara.entities.Service o) {
        try {
			serviceRepository.delete(o);
			return true;
		}
		catch(Exception ex) {
			return false;
		}
    }

    @Override
    public ma.camara.camara.entities.Service update(ma.camara.camara.entities.Service o) {
        return serviceRepository.save(o);
    }

    @Override
    public List<ma.camara.camara.entities.Service> findAll() {
       return serviceRepository.findAll();
    }

    @Override
    public ma.camara.camara.entities.Service findById(Long id) {
       return serviceRepository.findById(id).orElse(null);
    }
    
}
