package com.clickbus.restapi.test.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="client_application")
public class ClientApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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