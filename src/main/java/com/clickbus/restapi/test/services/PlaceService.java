package com.clickbus.restapi.test.services;

import com.clickbus.restapi.test.entities.Place;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {

    public Place getPlaceBySlug(String slug){
        Place place = new Place();
        return Place.builder().
                slug(slug).
                build();
    }

    public Place getPlaceById(Integer id){
        Place place = new Place();
        return Place.builder().
                id(id).
                build();
    }
}
