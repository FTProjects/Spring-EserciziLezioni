package com.example.demo_spring_relazioni_db.repository;

import com.example.demo_spring_relazioni_db.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
}
