package com.clickbus.restapi.test;

import com.clickbus.restapi.test.entities.Place;
import com.clickbus.restapi.test.repositories.PlaceRepository;
import com.clickbus.restapi.test.services.PlaceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestapiApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void getPlaceByIdTest(){
		Integer id = 1;
		PlaceService placeService = new PlaceService();
		Place place = placeService.getPlaceById(id);
		assertEquals("test_name",place.getName());
		assertEquals("test_slug",place.getSlug());
		assertEquals("xyz",place.getAddress());
	}

}
