package com.demoapplication.demoapplication;


import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository;

@Repository
public interface material_supplier_repo extends JpaRepository<material_supplier, Integer> {
  
}

