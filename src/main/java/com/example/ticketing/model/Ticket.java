package com.example.ticketing.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.Instant;;

public class Ticket {
    private Long id;

    @NotBlank(message = "Tytuł nie może być pusty")
    @Size(max = 100)
    private String title;

    @Size(max = 1000)
    private String description;

    @NotNull(message = "Status nie może być pusty")
    private Status status;

    private Instant createdAt;

    // Getters and Setters

    public enum Status {
        OPEN, IN_PROGRESS, CLOSED
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

}
