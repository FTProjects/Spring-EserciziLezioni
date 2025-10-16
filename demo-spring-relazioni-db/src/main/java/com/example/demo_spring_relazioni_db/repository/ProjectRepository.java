package com.example.demo_spring_relazioni_db.repository;

import com.example.demo_spring_relazioni_db.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
