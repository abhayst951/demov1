package com.teliolabs.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.teliolabs.demo.dao.NetworkFunctionRegiatrationDao;
import com.teliolabs.demo.model.NetworkFunctionRegistrationRequestModel;
import com.teliolabs.demo.model.ResponseModel;
import com.teliolabs.demo.repository.NetworkFunctionRegistrationRepo;

@Service
public class NetworkFunctionRegiatrationService {


    @Autowired
    NetworkFunctionRegistrationRepo repo;

    public ResponseModel registerNetworkFunction(NetworkFunctionRegistrationRequestModel reqModel){
        ResponseModel resp = new ResponseModel();
        NetworkFunctionRegiatrationDao dao = new NetworkFunctionRegiatrationDao();
        try{
            dao.setNfName(reqModel.getNfName());
            dao.setNfDescription(reqModel.getNfDescription());

            repo.save(dao);


            resp.setMessage("SUCCCESS");
            resp.setResponse("Data Saved in successfully");
            resp.setStatus(HttpStatus.OK);
        
        
        }catch(Exception e){
            resp.setMessage("SUCCCESS");
            resp.setResponse("Duplicate InstanceId found");
            resp.setStatus(HttpStatus.BAD_REQUEST);
        
        }
        return resp;
    }

    public ResponseModel viewAllNetworkFunction(){
        ResponseModel resp = new ResponseModel();
        try{
            List<NetworkFunctionRegiatrationDao> networkFunctionList = repo.findAll();
                
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

    public ResponseModel deleteNetworkFunction(NetworkFunctionRegistrationRequestModel reqModel){
        ResponseModel resp = new ResponseModel();
        try{
            int id = reqModel.getNfId();

            repo.deleteById(id);
            
            resp.setMessage("SUCCCESS");
            resp.setResponse("Data Deleted successfully");
            resp.setStatus(HttpStatus.OK);
        }catch(Exception e){
            resp.setMessage("Exception occured while deleting");
            resp.setResponse(e.getStackTrace());
            resp.setStatus(HttpStatus.BAD_REQUEST);
        
        }

        return resp;
    }
}
