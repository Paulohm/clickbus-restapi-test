package com.clickbus.restapi.test.services;

import com.clickbus.restapi.test.dto.CityDto;
import com.clickbus.restapi.test.dto.CountryDto;
import com.clickbus.restapi.test.dto.StateDto;
import com.clickbus.restapi.test.entities.*;
import com.clickbus.restapi.test.repositories.PlaceRepository;
import com.clickbus.restapi.test.response.ListPlaceResponse;
import com.clickbus.restapi.test.response.PlaceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaceService {

    private final PlaceRepository placeRepository;

    @Autowired
    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }


    public PlaceResponse getPlaceBySlug(String slug){
        Place place  = placeRepository.findBySlug(slug);
        return placeResponseBuilder(place);
    }

    public PlaceResponse getPlaceById(Integer id){
        Place place = placeRepository.findById(id);
        return placeResponseBuilder(place);
    }

    public ListPlaceResponse getAllPlaces(){
        List<Place> places = placeRepository.findAll();
        return ListPlaceResponse.builder().placeResponses(places.stream().map(this::placeResponseBuilder).collect(Collectors.toList())).build();
    }

    public PlaceResponse placeResponseBuilder(Place place){
        return PlaceResponse.builder().
                id(place.getId()).
                name(place.getName()).
                slug(place.getSlug()).
                city(CityDto.builder().
                        name(place.getCity().getName()).
                        build()).
                state(StateDto.builder().
                        name(place.getCity().getState().getName()).
                        build()).
                country(CountryDto.builder().
                        name(place.getCity().getState().getCountry().getName()).
                        build()).
                clientIds(place.getPlaceClientApplications().stream().
                        map(placeClientApplication -> placeClientApplication.getClientApplication().getId()).
                        collect(Collectors.toSet())).

                build();
    }
}
