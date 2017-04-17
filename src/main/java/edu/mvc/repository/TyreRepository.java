package edu.mvc.repository;

import edu.mvc.model.Tyre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TyreRepository extends JpaRepository <Tyre, Integer>{
    Tyre findById(Integer id);
}
