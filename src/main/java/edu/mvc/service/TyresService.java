package edu.mvc.service;

import edu.mvc.model.Tyre;
import edu.mvc.repository.TyreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TyresService {

    @Autowired
    private TyreRepository tyresRepository;

    public Tyre findById(int id) {
        return tyresRepository.findById(id);
    }

    public List<Tyre> findAll() {
        return tyresRepository.findAll();
    }

    public void save(Tyre tyre) {
        tyresRepository.save(tyre);
    }
}
