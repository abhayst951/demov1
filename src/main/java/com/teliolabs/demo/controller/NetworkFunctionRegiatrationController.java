package com.teliolabs.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.teliolabs.demo.model.NetworkFunctionRegistrationRequestModel;
import com.teliolabs.demo.model.ResponseModel;
import com.teliolabs.demo.service.NetworkFunctionRegiatrationService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/5g/networkFunction")
public class NetworkFunctionRegiatrationController {
    
    @Autowired
    NetworkFunctionRegiatrationService service;

    @RequestMapping(value = "/registerNewNetworkFunction", method = RequestMethod.POST)
    public ResponseEntity<Object> addNetworkFunction(@RequestBody NetworkFunctionRegistrationRequestModel requestModel){

        ResponseModel respData = service.registerNetworkFunction(requestModel);
        return new ResponseEntity<Object>(respData, respData.getStatus());

    }

    @RequestMapping(value="/viewAllNetworkFunction",method = RequestMethod.GET)
    public ResponseEntity<Object> viewAllNetworkFunction(){
        ResponseModel respData = service.viewAllNetworkFunction();
		return new ResponseEntity<Object>(respData, respData.getStatus());
    }

    @RequestMapping(value="/deleteNetworkFunction",method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteNetworkFunction(@RequestBody NetworkFunctionRegistrationRequestModel requestModel){
        ResponseModel respData = service.deleteNetworkFunction(requestModel);
		return new ResponseEntity<Object>(respData, respData.getStatus());
    }
}
