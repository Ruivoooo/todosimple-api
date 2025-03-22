package com.lucasangelo.todosimple.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;


@Entity
@Table(name = "task")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Task {

    public static final String TABLE_NAME = "task";


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false, updatable = false)
    private User user;


    @Column(name = "description", length = 255, nullable = false)
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 255)
    private String description;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public @NotNull @NotEmpty @Size(min = 1, max = 255) String getDescription() {
        return description;
    }

    public void setDescription(@NotNull @NotEmpty @Size(min = 1, max = 255) String description) {
        this.description = description;
    }
}
