package com.clickbus.restapi.test;

import com.clickbus.restapi.test.entities.*;
import com.clickbus.restapi.test.repositories.PlaceRepository;
import com.clickbus.restapi.test.response.ListPlaceResponse;
import com.clickbus.restapi.test.response.PlaceResponse;
import com.clickbus.restapi.test.services.PlaceService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestapiApplicationTests {

	@Autowired
	PlaceService placeService;

	@MockBean
	PlaceRepository placeRepository;

	Place place;

	@Before
	public void init(){
		Set placeClientApplications = new HashSet<>();
		place = new Place();
		place.setId(1);
		place.setAddress("end");
		place.setCity(City.builder().
				id(1).
				state(State.builder().
						id(1).
						country(Country.builder().id(1).build()).
						build()).
				build());
		place.setName("nme");
		place.setSlug("slg");
		placeClientApplications.add(PlaceClientApplication.builder().
				placeClientId(1).
				clientApplication(ClientApplication.builder().
						id(1).
						build()).
				build());
		place.setPlaceClientApplications(placeClientApplications);

	}
	@Test
	public void contextLoads() {
	}

	@Test
	public void testGetPlaceById(){
		when(placeRepository.findById(anyInt())).thenReturn(place);
		PlaceResponse placeResponse = placeService.getPlaceById(1);
		assertNotNull(placeResponse);
		assertEquals("slg",placeResponse.getSlug());
	}

	@Test
	public void testGetPlaceBySlug(){
		Integer id =1;
		when(placeRepository.findBySlug(anyString())).thenReturn(place);
		PlaceResponse placeResponse = placeService.getPlaceBySlug("slg");
		assertNotNull(placeResponse);
		assertEquals(id,placeResponse.getId());

	}

	@Test
	public void testGetAll(){
		List<Place> places = new ArrayList<>();
		places.add(place);
		when(placeRepository.findAll()).thenReturn(places);
		ListPlaceResponse listPlaceResponse = placeService.getAllPlaces();
		assertEquals(1,listPlaceResponse.getPlaceResponses().size());
	}


}
