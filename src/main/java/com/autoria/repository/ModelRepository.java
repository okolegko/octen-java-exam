package com.autoria.repository;

import com.autoria.model.Model;
import com.autoria.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model, Long> {
    List<Model> findByBrand(Brand brand);
}
