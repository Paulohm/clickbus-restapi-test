package com.clickbus.restapi.test.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ListPlaceResponse {
    private List<PlaceResponse> placeResponses;
}
