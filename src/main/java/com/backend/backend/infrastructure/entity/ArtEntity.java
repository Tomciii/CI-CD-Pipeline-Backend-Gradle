package com.backend.backend.infrastructure.entity;

import jakarta.persistence.*;

@Entity(name = "ART")
public class ArtEntity {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name ="URL")
    private String imageURL;

    @Column(name ="NAME")
    private String name;

    @Column(name="TEXT")
    private String text;

    public ArtEntity( String imageURL, String name, String text) {
        this.imageURL = imageURL;
        this.name = name;
        this.text = text;
    }

    public ArtEntity() {

    }

    @Override
    public String toString() {
        return String.format("{\"id\": \"%s\",\"imageURL\": \"%s\", \"name\": \"%s\", \"text\": \"%s\"}",
                this.id, this.imageURL, this.name, this.text);
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
