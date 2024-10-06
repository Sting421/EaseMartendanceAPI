package com.g3appdev.SYSLAB.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.g3appdev.SYSLAB.Service.StudentService;
import com.g3appdev.SYSLAB.entity.StudentEntity;

@RestController
// Removed method attribute to allow both GET and POST requests
@RequestMapping(path = "/api/student")
public class StudentController {
    @Autowired
    StudentService sserv;
	
    @GetMapping("/print")
    public String print(){
        return "Hello, Firstname Lastname";
    }    
    //Create of CRUD
	@PostMapping("/poststudentrecord")
	public StudentEntity postStudentRecord(@RequestBody StudentEntity student) {
		return sserv.postStudentRecord(student);
	}
	
	//Read of CRUD
	@GetMapping("/getAllStudents")
	public java.util.List<StudentEntity> getAllStudents(){
		return sserv.getAllStudents();
	}

    // New method to get a student by last name
    @GetMapping("/getStudentByLname/{lname}")
    public StudentEntity getStudentByLname(@PathVariable String lname) {

        return sserv.getStudentByLname(lname);
    }

    @PutMapping("/updateStudent/{id}")
    public StudentEntity updateStudent(@PathVariable int id, @RequestBody StudentEntity newStudentDetails) {
        return sserv.updateStudent(id, newStudentDetails);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable int id) {
        return sserv.deleteStudent(id);
    }
}
