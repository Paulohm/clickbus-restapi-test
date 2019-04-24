package com.clickbus.restapi.test.response;


import com.clickbus.restapi.test.dto.CityDto;
import com.clickbus.restapi.test.dto.CountryDto;
import com.clickbus.restapi.test.dto.StateDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlaceResponse {
    private Integer id;
    private String name;
    private String slug;
    private CityDto city;
    private StateDto state;
    private CountryDto country;
    private Set<Integer> clientIds;

}
