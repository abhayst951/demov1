package com.teliolabs.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teliolabs.demo.dao.NetworkFunctionDao;

@Repository
public interface NetworkFunctionRepo extends JpaRepository<NetworkFunctionDao,Integer>{
    List<NetworkFunctionDao> findByNfType(String nfType);

    
    List<NetworkFunctionDao> findByNfInstanceId(String nfInstanceId);

    List<NetworkFunctionDao> findByNfStatus(String nfStatus);

    List<NetworkFunctionDao> findByIpAddress(String ipaddress);

    List<NetworkFunctionDao> findByFqdn(String fqdn);
    List<NetworkFunctionDao> findByLocation(String location);

    NetworkFunctionDao findById(int id);
}
