package com.demoapplication.demoapplication.repository;

import java.util.Optional;

import com.demoapplication.demoapplication.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>{
    Optional<Role> findByName(String name);
}
