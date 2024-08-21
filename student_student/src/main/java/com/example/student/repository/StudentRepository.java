package com.example.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.student.entity.student;

public interface StudentRepository extends JpaRepository<student, Long> {
}
