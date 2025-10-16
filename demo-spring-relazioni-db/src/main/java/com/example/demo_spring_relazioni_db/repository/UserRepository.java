package com.example.demo_spring_relazioni_db.repository;

import com.example.demo_spring_relazioni_db.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
