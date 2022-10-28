package com.teliolabs.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teliolabs.demo.dao.NetworkFunctionRegiatrationDao;

@Repository
public interface NetworkFunctionRegistrationRepo extends JpaRepository<NetworkFunctionRegiatrationDao,Integer>{
    
}
