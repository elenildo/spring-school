package com.elenildo.school.controllers;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.elenildo.school.model.Student;
import com.elenildo.school.service.StudentService;

import lombok.Data;

@RestController
@RequestMapping("students")
@Data
public class StudentController {
	
	private final StudentService studentService;
	
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> create(@Valid @RequestBody Student student) {
		return new ResponseEntity<>(studentService.create(student), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<Page<Student>> listAll(Pageable pageable) {
		return new ResponseEntity<>(studentService.listAll(pageable), HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Student> findById(@PathVariable Long id) {
		return new ResponseEntity<>(studentService.findById(id), HttpStatus.OK);
	}
	
	@PutMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Student> update(@Valid @RequestBody Student student) {
		return new ResponseEntity<Student>( studentService.update(student), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> remove(@PathVariable Long id) {
		studentService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
