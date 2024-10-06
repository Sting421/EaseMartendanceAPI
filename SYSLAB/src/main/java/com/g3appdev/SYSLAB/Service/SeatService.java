package com.g3appdev.SYSLAB.Service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g3appdev.SYSLAB.entity.SeatEntity;
import com.g3appdev.SYSLAB.repository.SeatRepo;

import java.util.List;
import java.util.Optional;


@Service
public class SeatService {

    @Autowired
    SeatRepo sRepo; // Ensure StudentRepo is correctly defined and annotated

    

    public SeatService(){

        super();
    }
    //Create of CRUD
    public SeatEntity postSeatRecord(SeatEntity seat){

        return sRepo.save(seat);
    }
    //Read of CRUD 
	public List<SeatEntity> getAllSeat(){
        return sRepo.findAll();
    }
    // New method to find a student by last name


    public SeatEntity updateSeat(int id, SeatEntity newSeatDetails){
        SeatEntity student = new SeatEntity();

        if (sRepo.findById(id).isPresent()){
            student.setCourseID(newSeatDetails.getCourseID());
        }else{
            throw new NoSuchElementException("Student " + id + " does not exist!");
        }

        return sRepo.save(student);

    }


    public String deleteSeat(int id) {
        Optional<SeatEntity> optionalStudent = sRepo.findById(id);

        if (optionalStudent.isPresent()) {
            sRepo.deleteById(id);
            return "Student " + id + " is successfully deleted!";
        } else {
            return "Student " + id + " does not exist.";
        }
    }

    
}
