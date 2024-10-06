package com.g3appdev.SYSLAB.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.g3appdev.SYSLAB.entity.StudentEntity;

public interface StudentRepo extends JpaRepository<StudentEntity, Integer>{

    public StudentEntity findByLname(String lname);


    StudentEntity findByidAndIsDeletedFalse(int id);
}
