package org.example.java4n_sp26_sd20307.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {

    @Id
    private  Long id;

    private String rating;
    private String description;

    @ManyToOne
    private Course course;

    public Review() {
    }

    public Review(Long id, String rating, String description, Course course) {
        this.id = id;
        this.rating = rating;
        this.description = description;
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
