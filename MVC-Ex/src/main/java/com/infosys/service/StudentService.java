package com.infosys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.entity.Student;
import com.infosys.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository srepo;
	
	// 1. insert Student
	public void insertStudent(Student student) {
		srepo.save(student);
	}
	
	// 2. Display list of student
	public List<Student> getAll(){
		return srepo.findAll();
	}
	
	//3. Get Student details based on reg no
	public Student getById(int id) {
		return srepo.getById(id);
	}
	
	//4. Update Student marks based on reg no
	public void updateMarks(int id,int marks) {
		Student s = srepo.findById(id).get();
		if(s != null) {
			s.setMarks(marks);
			srepo.save(s);
		}
	}
	
	//5. Delete Student
	public void delete(int id) {
		srepo.deleteById(id);
	}
}
