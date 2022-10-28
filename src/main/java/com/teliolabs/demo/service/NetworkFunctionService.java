package com.teliolabs.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.teliolabs.demo.dao.NetworkFunctionDao;
import com.teliolabs.demo.model.NetworkFunctionRequestModel;
import com.teliolabs.demo.model.ResponseModel;
import com.teliolabs.demo.repository.NetworkFunctionRepo;
import com.teliolabs.demo.utils.NFUtil;

@Service
public class NetworkFunctionService {
    
    @Autowired
    NetworkFunctionRepo repo;

    public ResponseModel addNetworkFunction(NetworkFunctionRequestModel requestModel){
        ResponseModel resp = new ResponseModel();
        boolean isValid = NFUtil.validateReqModel(requestModel);
        if(true){//isValid
            try{
                //Check for duplicate Instance id
                String instanceId = requestModel.getNfInstanceId();
                List<NetworkFunctionDao> list = repo.findByNfInstanceId(instanceId);
                if(list.size()==0){
                    NetworkFunctionDao dao = new NetworkFunctionDao();
                    dao.setNfInstanceId(requestModel.getNfInstanceId());
                    dao.setNfType(requestModel.getNfType());
                    dao.setNfStatus(requestModel.getNfStatus());
                    dao.setFqdn(requestModel.getFqdn());
                    dao.setIpAddress(requestModel.getIpAddress());
                    dao.setLocation(requestModel.getLocation());
        
                    repo.save(dao);
                    
                    resp.setMessage("SUCCCESS");
                    resp.setResponse("Data Saved in successfully");
                    resp.setStatus(HttpStatus.OK);
                }else{
                    resp.setMessage("SUCCCESS");
                    resp.setResponse("Duplicate InstanceId found");
                    resp.setStatus(HttpStatus.BAD_REQUEST);
                }
            }catch(Exception e){
                resp.setMessage("Exception Occurred");
                resp.setResponse(e.getMessage());
                resp.setStatus(HttpStatus.OK);
            }
    
        }else{
            resp.setMessage("Bad data request");
            resp.setResponse("Bad data");
            resp.setStatus(HttpStatus.BAD_REQUEST);
        }
        
        return resp;
    }   

    public ResponseModel discoverNetworkFunction(String searchText,String searchType){
        
        ResponseModel resp = new ResponseModel();
        List<NetworkFunctionDao> networkFunctionList = null;
        if(!NFUtil.isBlankOrNull(searchText) && !NFUtil.isBlankOrNull(searchText)){

            if(searchType.equalsIgnoreCase("nfInstanceId")){
                networkFunctionList = repo.findByNfInstanceId(searchText);
            }else if(searchType.equalsIgnoreCase("nfType")){
                networkFunctionList = repo.findByNfType(searchText);
            }else if(searchType.equalsIgnoreCase("nfStatus")){
                networkFunctionList = repo.findByNfStatus(searchText);
            }else if(searchType.equalsIgnoreCase("fqdn")){
                networkFunctionList = repo.findByFqdn(searchText);
            }else if(searchType.equalsIgnoreCase("ipaddress")){
                networkFunctionList = repo.findByIpAddress(searchText);
            }else if(searchType.equalsIgnoreCase("location")){
                networkFunctionList = repo.findByLocation(searchText);
            }
            
            
            try{    
                if(networkFunctionList.size()>0){
                    resp.setMessage("SUCCCESS");
                    resp.setResponse(networkFunctionList);
                    resp.setStatus(HttpStatus.OK);
                }else{
                    resp.setMessage("SUCCCESS");
                    resp.setResponse("No Network Function found");
                    resp.setStatus(HttpStatus.OK);
                }
            }catch(Exception e){
                resp.setMessage("Exception Occurred");
                resp.setResponse(e.getMessage());
                resp.setStatus(HttpStatus.OK);
            }
        }
        
        return resp;
    }

    public ResponseModel deleteNetworkFunction(NetworkFunctionRequestModel requestModel){
        List<NetworkFunctionDao> networkFunctionList = repo.findByNfType(requestModel.getNfType());
        ResponseModel resp = new ResponseModel();
        try{    
            if(networkFunctionList.size()>0){
                for (NetworkFunctionDao dao : networkFunctionList) {
                    repo.deleteById(dao.getNfId());
                }
                resp.setMessage("SUCCCESS");
                resp.setResponse("Network Function deleted");
                resp.setStatus(HttpStatus.OK);
            }else{
                resp.setMessage("SUCCCESS");
                resp.setResponse("No Network Function found");
                resp.setStatus(HttpStatus.OK);
            }
        }catch(Exception e){
            resp.setMessage("Exception Occurred");
            resp.setResponse(e.getMessage());
            resp.setStatus(HttpStatus.OK);
        }
        return resp;
    }

    public ResponseModel updateNetworkFunction(NetworkFunctionRequestModel requestModel){
        ResponseModel resp = new ResponseModel();
        try{    
           
            
            NetworkFunctionDao dao = repo.findById(requestModel.getNfId());
            
            
            dao.setNfInstanceId(requestModel.getNfInstanceId());
            dao.setNfType(requestModel.getNfType());
            dao.setNfStatus(requestModel.getNfStatus());
            dao.setFqdn(requestModel.getFqdn());
            dao.setIpAddress(requestModel.getIpAddress());
            dao.setLocation(requestModel.getLocation());

            repo.save(dao);

            resp.setMessage("SUCCCESS");
            resp.setResponse("Record Updated Successfully");
            resp.setStatus(HttpStatus.OK);
            
        }catch(Exception e){
            resp.setMessage("Exception Occurred");
            resp.setResponse(e.getMessage());
            resp.setStatus(HttpStatus.OK);
        }
        return resp;
    }

    public ResponseModel viewAllNetworkFunction(){
        ResponseModel resp = new ResponseModel();
        try{
            List<NetworkFunctionDao> networkFunctionList = repo.findAll();
                
            if(networkFunctionList.size()>0){
                resp.setMessage("SUCCCESS");
                resp.setResponse(networkFunctionList);
                resp.setStatus(HttpStatus.OK);
            }else{
                resp.setMessage("SUCCCESS");
                resp.setResponse("No Network Function found");
                resp.setStatus(HttpStatus.OK);
            }
            }catch(Exception e){
                resp.setMessage("Exception Occurred");
                resp.setResponse(e.getMessage());
                resp.setStatus(HttpStatus.OK);
            }
            return resp;
    }
}
