package ma.camara.camara.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.camara.camara.dao.IDao;
import ma.camara.camara.entities.Employe;
import ma.camara.camara.repositories.EmployeRepository;

@Service
public class EmployeService implements IDao<Employe>{
    @Autowired
    EmployeRepository employeRepository;

    @Override
    public Employe create(Employe o) {
        return employeRepository.save(o);
    }

    @Override
    public boolean delete(Employe o) {
        try {
			employeRepository.delete(o);
			return true;
		}
		catch(Exception ex) {
			return false;
		}
    }

    public List<Employe> findByService(ma.camara.camara.entities.Service service){
        return employeRepository.findByService(service);
    }

    @Override
    public Employe update(Employe o) {
        return employeRepository.save(o);
    }

    @Override
    public List<Employe> findAll() {
        return employeRepository.findAll();
    }

    @Override
    public Employe findById(Long id) {
        return employeRepository.findById(id).orElse(null);
    }
    
}
