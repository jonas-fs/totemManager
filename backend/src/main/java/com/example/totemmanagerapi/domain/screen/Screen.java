package com.example.totemmanagerapi.domain.screen;

import java.util.ArrayList;
import java.util.List;

import com.example.totemmanagerapi.domain.image.Image;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "screen")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Screen {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    
    // @OneToMany(
    //     mappedBy = "screen",
    //     cascade = CascadeType.ALL,
    //     orphanRemoval = true
    // )
    @OneToMany(mappedBy = "screen")
    private List<Image> images = new ArrayList<>();
}
