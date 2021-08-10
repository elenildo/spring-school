package com.elenildo.school.service;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.elenildo.school.exception.BadRequestException;
import com.elenildo.school.model.Student;
import com.elenildo.school.repository.StudentRepository;

import lombok.Data;


@Service
@Data
public class StudentService {
	
	private final StudentRepository studentRepository;
	
	@Transactional
	public Student create(Student student) {
		student.setId(null);
		return studentRepository.save(student);
	}
	
	public Page<Student> listAll(Pageable pageable) {
		return studentRepository.findAll(pageable);
	}
	
	public Student findById(Long id) {
		return studentRepository.findById(id)
				.orElseThrow(() -> new BadRequestException("Student not found"));
	}

	@Transactional
	public Student update(Student student) {
		if (student.getId() == null) {
			throw new BadRequestException("Id is null");
		}
		studentRepository.findById(student.getId())
				.orElseThrow(() -> new BadRequestException("Student not found. Updade failed."));
		
		return studentRepository.save(student);
	}
	
	@Transactional
	public void delete(Long id) {
		studentRepository.findById(id)
			.orElseThrow(() -> new BadRequestException("Student not found. Delete failed."));
		
		studentRepository.deleteById(id);
	}
}
