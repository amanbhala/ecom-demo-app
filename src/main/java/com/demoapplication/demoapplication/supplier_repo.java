package com.demoapplication.demoapplication;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface supplier_repo extends JpaRepository<supplier, Integer> {
    public supplier findByname(String name);
}
