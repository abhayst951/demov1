package com.teliolabs.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.teliolabs.demo.model.ResponseModel;
import com.teliolabs.demo.model.SiteRegistrationModel;
import com.teliolabs.demo.model.SiteRegistrationRequestModel;
import com.teliolabs.demo.service.SiteRegiatrationService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/5g/site")
public class SiteRegistrationController {
    @Autowired
    SiteRegiatrationService service;

    @RequestMapping(value = "/registerSite", method = RequestMethod.POST)
    public ResponseEntity<Object> registerSite(@RequestBody SiteRegistrationModel requestModel){

        ResponseModel respData = service.registerSite(requestModel);
        return new ResponseEntity<Object>(respData, respData.getStatus());

    }

    @RequestMapping(value="/viewAllSites",method = RequestMethod.GET)
    public ResponseEntity<Object> viewAllSites(){
        ResponseModel respData = service.viewAllSites();
		return new ResponseEntity<Object>(respData, respData.getStatus());
    }

    @RequestMapping(value="/deleteSite",method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteSite(@RequestBody SiteRegistrationModel requestModel){
        ResponseModel respData = service.deleteSite(requestModel);
		return new ResponseEntity<Object>(respData, respData.getStatus());
    }
}
