package edu.mvc.service;

import edu.mvc.model.Wheel;
import edu.mvc.repository.WheelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WheelsService {

    @Autowired
    private WheelRepository wheelsRepository;

    public Wheel findById(int id) {
        return wheelsRepository.findById(id);
    }

    public List<Wheel> findAll() {
        return wheelsRepository.findAll();
    }

    public void save(Wheel wheel) {
        wheelsRepository.save(wheel);
    }

}
