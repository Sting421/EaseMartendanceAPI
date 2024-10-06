package com.g3appdev.SYSLAB.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.g3appdev.SYSLAB.entity.CourseEntity;

public interface CourseRepo extends JpaRepository<CourseEntity, Integer>{
    public CourseEntity findByCourseID(int id);
}

