package com.elenildo.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elenildo.school.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
