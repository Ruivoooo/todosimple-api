package com.lucasangelo.todosimple.models;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "user")

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {
    public interface CreateUser {}
    public interface UpdateUser {}


    public static final String TABLE_NAME = "user";



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true)
    private Long id;



    @Column(name = "username",length = 100,nullable = false,unique = true)
    @NotNull(groups = CreateUser.class)
    @NotEmpty(groups = CreateUser.class)
    @Size(groups = CreateUser.class,min = 2,max = 100)
    private String username;


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "password", length = 60,nullable = false )
    @NotNull(groups = {CreateUser.class, UpdateUser.class})
    @NotEmpty(groups = {CreateUser.class, UpdateUser.class})
    @Size(groups = {CreateUser.class, UpdateUser.class}, min = 8, max = 60)
    private String password;


    @OneToMany(mappedBy = "user")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Task> tasks = new ArrayList<Task>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull(groups = CreateUser.class) @NotEmpty(groups = CreateUser.class) @Size(groups = CreateUser.class, min = 2, max = 100) String getUsername() {
        return username;
    }

    public void setUsername(@NotNull(groups = CreateUser.class) @NotEmpty(groups = CreateUser.class) @Size(groups = CreateUser.class, min = 2, max = 100) String username) {
        this.username = username;
    }

    public @NotNull(groups = {CreateUser.class, UpdateUser.class}) @NotEmpty(groups = {CreateUser.class, UpdateUser.class}) @Size(groups = {CreateUser.class, UpdateUser.class}, min = 8, max = 60) String getPassword() {
        return password;
    }

    public void setPassword(@NotNull(groups = {CreateUser.class, UpdateUser.class}) @NotEmpty(groups = {CreateUser.class, UpdateUser.class}) @Size(groups = {CreateUser.class, UpdateUser.class}, min = 8, max = 60) String password) {
        this.password = password;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
