package com.elenildo.school.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.elenildo.school.model.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long>{
	User findByUsername(String username);
}
