package com.clickbus.restapi.test.services;

import com.clickbus.restapi.test.entities.Place;
import com.clickbus.restapi.test.repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    public Place getPlaceBySlug(String slug){
        return placeRepository.findBySlug(slug);
    }

    public Place getPlaceById(Integer id){
        Place place = placeRepository.findById(id);
        return place;
    }

    public List <Place> getAllPlaces(){
        List<Place> places = placeRepository.findAll();
        return places;
    }
}
