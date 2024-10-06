package com.g3appdev.SYSLAB.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g3appdev.SYSLAB.Service.CourseService;
import com.g3appdev.SYSLAB.entity.CourseEntity;

@RestController
@RequestMapping(path = "/api/course")
public class CourseController {
     @Autowired
    CourseService courseService;
	
    @GetMapping("/print")
    public String print(){
        return "Hello, Firstname Lastname";
    }    
    //Create of CRUD
	@PostMapping("/postcourserecord")
	public CourseEntity postSeatRecord(@RequestBody CourseEntity seat) {
		return courseService.postCourseRecord(seat);
	}
	
	//Read of CRUD
	@GetMapping("/getAllCourse")
	public java.util.List<CourseEntity> getAllSeat(){
		return courseService.getAllCourse();
	}


    @PutMapping("/updateCourse/{id}")
    public CourseEntity updateStudent(@PathVariable int id, @RequestBody CourseEntity newSeatDetails) {
        return courseService.updateCourse(id, newSeatDetails);
    }

    @DeleteMapping("/deleteCourse/{id}")
    public String deleteSeat(@PathVariable int id) {
        return courseService.deleteCourse(id); // Corrected from sserv to seatService
    }
}