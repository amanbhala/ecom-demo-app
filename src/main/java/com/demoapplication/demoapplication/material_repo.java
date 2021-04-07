package com.demoapplication.demoapplication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.data.repository.CrudRepository;

@Repository
public interface material_repo extends JpaRepository<material, Integer> {
    public material findByDetails(String details); 
}