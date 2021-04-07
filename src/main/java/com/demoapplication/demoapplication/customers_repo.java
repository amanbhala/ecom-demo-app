package com.demoapplication.demoapplication;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface customers_repo extends JpaRepository<customers, Integer> {
    public customers findByemail(String email);
	// public customers findByUsername(String name) {
	// 	return null;
	// }
}