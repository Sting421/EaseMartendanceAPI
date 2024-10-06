package com.g3appdev.SYSLAB.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g3appdev.SYSLAB.entity.StudentEntity;
import com.g3appdev.SYSLAB.repository.StudentRepo;

@Service
public class StudentService {

    @Autowired
    StudentRepo sRepo; // Ensure StudentRepo is correctly defined and annotated

    public StudentService(){

        super();
    }
    //Create of CRUD
    public StudentEntity postStudentRecord(StudentEntity student){

        return sRepo.save(student);
    }
    //Read of CRUD 
	public List<StudentEntity> getAllStudents(){

        return sRepo.findAll();
    }
    // New method to find a student by last name
    public StudentEntity getStudentByLname(String lname) {

        return sRepo.findByLname(lname);
    }
    


    public StudentEntity updateStudent(int id, StudentEntity newStudentDetails){
        StudentEntity student = new StudentEntity();

        if (sRepo.findById(id).isPresent()){
            student = sRepo.findByidAndIsDeletedFalse(id);
            student.setFname(newStudentDetails.getFname());
            student.setLname(newStudentDetails.getLname());
            student.setProgram(newStudentDetails.getProgram());
            student.setYearlevel(newStudentDetails.getYearlevel());
        }else{
            throw new NoSuchElementException("Student" + id + "does not exist!");
        }

        return sRepo.save(student);

    }


    public String deleteStudent(int id) {
        Optional<StudentEntity> optionalStudent = sRepo.findById(id);

        if (optionalStudent.isPresent()) {
            sRepo.deleteById(id);
            return "Student " + id + " is successfully deleted!";
        } else {
            return "Student " + id + " does not exist.";
        }
    }




}


