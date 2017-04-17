package edu.mvc.repository;

import edu.mvc.model.Wheel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WheelRepository extends JpaRepository <Wheel, Integer> {
    Wheel findById(Integer id);
}
