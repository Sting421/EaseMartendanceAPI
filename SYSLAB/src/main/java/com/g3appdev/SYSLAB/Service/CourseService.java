package com.g3appdev.SYSLAB.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g3appdev.SYSLAB.entity.CourseEntity;
import com.g3appdev.SYSLAB.repository.CourseRepo;

import jakarta.persistence.NoResultException;

import java.util.Optional;
import java.util.List;


@Service
public class CourseService {

    @Autowired
    CourseRepo cRepo; // Ensure StudentRepo is correctly defined and annotated

    public CourseService(){
        super();
    }
    //Create of CRUD
    public CourseEntity postCourseRecord(CourseEntity seat){

        return cRepo.save(seat);
    }
    //Read of CRUD 
	public List<CourseEntity> getAllCourse(){
        return cRepo.findAll();
    }


    public CourseEntity updateCourse(int id, CourseEntity newSeatDetails){
        CourseEntity course = new CourseEntity();

        if (cRepo.findById(id).isPresent()){
            course.setDescription(newSeatDetails.getDescription());
        }else{
            throw new NoResultException("Course " + id + " does not exist!");
        }

        return cRepo.save(course);

    }


    public String deleteCourse(int id) {
        Optional<CourseEntity> optionalcourse = cRepo.findById(id);

        if (optionalcourse.isPresent()) {
            cRepo.deleteById(id);
            return "Course " + id + " is successfully deleted!";
        } else {
            return "Course " + id + " does not exist.";
        }
    }

    
}

