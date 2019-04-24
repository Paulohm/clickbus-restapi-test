package com.clickbus.restapi.test.repositories;

import com.clickbus.restapi.test.entities.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
    List<Place> findAll();

    Place findById(Integer id);

    Place findBySlug(String slug);
}
