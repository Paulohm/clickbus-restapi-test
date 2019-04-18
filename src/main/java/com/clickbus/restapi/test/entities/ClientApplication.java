package com.clickbus.restapi.test.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Builder
@Entity
@Table(name="client_application")
public class ClientApplication {
    @Id
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "public_name")
    private String publicName;
    @Column(name = "created_at",columnDefinition = "DATETIME")
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name="updated_at",columnDefinition = "DATETIME")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "clientApplication")
    @Builder.Default
    @JsonIgnore
    private Set<PlaceClientApplication> placeClientApplications =  new HashSet<>();

}