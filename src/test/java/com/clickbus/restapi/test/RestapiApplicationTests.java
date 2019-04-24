package com.clickbus.restapi.test;

import com.clickbus.restapi.test.entities.Place;
import com.clickbus.restapi.test.response.PlaceResponse;
import com.clickbus.restapi.test.services.PlaceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestapiApplicationTests {

	@Autowired
	PlaceService placeService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void getPlaceByIdTest(){
		Integer id = 3;
		PlaceResponse place = placeService.getPlaceById(id);
		assertEquals(id,place.getId());
		assertEquals("ClickBus",place.getName());
		assertEquals("clickbus",place.getSlug());
	}

	@Test
	public void getPlaceBySlugTest(){
		String slug = "clickbus";
		Integer id =3;
		PlaceResponse place = placeService.getPlaceBySlug(slug);
		assertEquals(id,place.getId());
		assertEquals("ClickBus",place.getName());
		assertEquals("clickbus",place.getSlug());

	}

	@Test
	public void getAllTest(){

	}


}
