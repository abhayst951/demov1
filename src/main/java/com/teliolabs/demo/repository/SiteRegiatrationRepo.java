package com.teliolabs.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teliolabs.demo.dao.SiteRegiatrationDao;

@Repository
public interface SiteRegiatrationRepo extends JpaRepository<SiteRegiatrationDao,Integer>{ 
    
}
