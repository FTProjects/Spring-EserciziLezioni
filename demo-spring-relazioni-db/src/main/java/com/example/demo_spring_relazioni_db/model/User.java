package com.example.demo_spring_relazioni_db.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

// dice al framework che questa classe ha una corrispettiva tabella sul db
@Entity
@Table(name = "users")
public class User {

    @Id // indica che questa è la primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autoincrement
    @Column(name = "user_id") // cambio il nome alla colonna
    private Long id;

    private String name;

    private String email;

    @OneToOne(mappedBy = "user")
    @JsonManagedReference("user-userdetails") // da questo lato vedo l'informazione
    public UserDetails userDetails;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference("user-posts")
    private List<Post> posts;

    @ManyToMany
    @JoinTable(
            name = "user_project",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    @JsonManagedReference("user-projects")
    private List<Project> projects;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
