package edu.mvc.repository;

import edu.mvc.model.Engine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EngineRepository extends JpaRepository <Engine, Integer>{

    Engine findById(Integer id);
}
