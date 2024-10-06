package com.g3appdev.SYSLAB.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.g3appdev.SYSLAB.entity.SeatEntity;


public interface SeatRepo extends JpaRepository<SeatEntity, Integer>{
    public SeatEntity findBySeatID(int id);
}


    

