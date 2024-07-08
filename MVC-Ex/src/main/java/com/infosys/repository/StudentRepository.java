package com.infosys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{

}
