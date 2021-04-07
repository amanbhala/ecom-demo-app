package com.demoapplication.demoapplication;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface invoice_repo extends JpaRepository<invoice, Integer> {
    
}
