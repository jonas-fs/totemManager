package com.example.totemmanagerapi.domain.image;

import java.util.UUID;

import com.example.totemmanagerapi.domain.screen.Screen;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "image")
@Getter
@Setter
@AllArgsConstructor
public class Image {
    public Image() {
        this.id = UUID.randomUUID().toString();
    }

    public Image(Screen screen) {
        this.id = UUID.randomUUID().toString();
        this.screen = screen;
    }

    @Id    
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "screen_id")
    //@JsonBackReference
    private Screen screen;
}



/*
public void addImage(Image image) {
    images.add(image);
    image.setScreen(this);
}

public void removeImage(Image image) {
    images.remove(image);
    image.setScreen(null);
}
*/
