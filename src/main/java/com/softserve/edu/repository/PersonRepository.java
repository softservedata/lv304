package com.softserve.edu.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.softserve.edu.entity.Person;

// Use JPARepository
//@Repository
public interface PersonRepository {//extends CrudRepository<Person, Integer> {
	
	List<Person> findByName(String name);
	
}
