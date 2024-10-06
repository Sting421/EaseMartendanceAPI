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

import com.g3appdev.SYSLAB.Service.SeatService;
import com.g3appdev.SYSLAB.entity.SeatEntity;

@RestController
@RequestMapping(path = "/api/seat")
public class SeatController {
     @Autowired
    SeatService seatService;
	
    @GetMapping("/print")
    public String print(){
        return "Hello, Firstname Lastname";
    }  
      
    //Create of CRUD
	@PostMapping("/postseatrecord")
	public SeatEntity postSeatRecord(@RequestBody SeatEntity seat) {
		return seatService.postSeatRecord(seat);
	}
	
	//Read of CRUD
	@GetMapping("/getAllSeat")
	public java.util.List<SeatEntity> getAllSeat(){
		return seatService.getAllSeat();
	}


    @PutMapping("/updateSeat/{id}")
    public SeatEntity updateStudent(@PathVariable int id, @RequestBody SeatEntity newSeatDetails) {
        return seatService.updateSeat(id, newSeatDetails);
    }

    @DeleteMapping("/deleteSeat/{id}")
    public String deleteSeat(@PathVariable int id) {
        return seatService.deleteSeat(id); // Corrected from sserv to seatService
    }
}
