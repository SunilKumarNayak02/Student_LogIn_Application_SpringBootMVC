package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entiry.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer>{  

}
