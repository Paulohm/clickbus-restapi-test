package com.clickbus.restapi.test.controller;

import com.clickbus.restapi.test.response.ListPlaceResponse;
import com.clickbus.restapi.test.response.PlaceResponse;
import com.clickbus.restapi.test.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlaceController {

    private final PlaceService placeService;

    @Autowired
    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping(value="/findById/{id}")
    public PlaceResponse getPlaceById(@PathVariable Integer id){
        return placeService.getPlaceById(id);
    }

    @GetMapping(value="/findBySlug/{slug}")
    public PlaceResponse getPlaceBySlug(@PathVariable String slug){
        return placeService.getPlaceBySlug(slug);
    }

    @GetMapping(value="/list")
    public ListPlaceResponse listPlaceResponse(){
        return placeService.getAllPlaces();
    }
}
