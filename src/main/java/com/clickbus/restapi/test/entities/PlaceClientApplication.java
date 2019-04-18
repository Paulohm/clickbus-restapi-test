package com.clickbus.restapi.test.entities;

import lombok.Builder;

import javax.persistence.*;

@Builder
@Entity
@Table(name = "place_client_application")
public class PlaceClientApplication {
    @Id
    @GeneratedValue
    private Integer placeClientId;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, optional = false)
    private Place place;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, optional = false)
    private ClientApplication clientApplication;

}