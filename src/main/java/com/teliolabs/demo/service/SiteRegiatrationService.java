package com.teliolabs.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.teliolabs.demo.dao.SiteRegiatrationDao;
import com.teliolabs.demo.model.ResponseModel;
import com.teliolabs.demo.model.SiteRegistrationModel;
import com.teliolabs.demo.repository.SiteRegiatrationRepo;

@Service
public class SiteRegiatrationService {

    @Autowired
    SiteRegiatrationRepo repo;

    public ResponseModel viewAllSites(){
        ResponseModel resp = new ResponseModel();
                try{
            List<SiteRegiatrationDao> list = repo.findAll();
                
            if(list.size()>0){
                resp.setMessage("SUCCCESS");
                resp.setResponse(list);
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

    public ResponseModel registerSite(SiteRegistrationModel reqModel){
        ResponseModel resp = new ResponseModel();
        SiteRegiatrationDao dao = new SiteRegiatrationDao();
        try{
            dao.setSiteName(reqModel.getSiteName());
            dao.setSiteDescription(reqModel.getSiteDescription());

            repo.save(dao);


            resp.setMessage("SUCCCESS");
            resp.setResponse("Site Registered successfully");
            resp.setStatus(HttpStatus.OK);
        
        
        }catch(Exception e){
            resp.setMessage("Exception occurred while registring Site");
            resp.setResponse(e.getStackTrace());
            resp.setStatus(HttpStatus.BAD_REQUEST);
        
        }
        return resp;
    }

    public ResponseModel deleteSite(SiteRegistrationModel reqModel){
        ResponseModel resp = new ResponseModel();
        try{
            int id = reqModel.getSiteId();

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
