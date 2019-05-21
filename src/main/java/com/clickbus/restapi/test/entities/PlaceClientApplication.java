package com.clickbus.restapi.test.entities;

import lombok.*;

import javax.persistence.*;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "place_client_application")
public class PlaceClientApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer placeClientId;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, optional = false)
    @EqualsAndHashCode.Exclude private Place place;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, optional = false)
    @EqualsAndHashCode.Exclude private ClientApplication clientApplication;

}