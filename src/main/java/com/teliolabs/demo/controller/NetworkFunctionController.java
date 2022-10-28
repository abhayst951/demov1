package com.teliolabs.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teliolabs.demo.model.NetworkFunctionRequestModel;
import com.teliolabs.demo.model.ResponseModel;
import com.teliolabs.demo.service.NetworkFunctionService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/5g")
public class NetworkFunctionController {
    @Autowired
    NetworkFunctionService service;
    
    @RequestMapping(value = "/addNetworkFunction", method = RequestMethod.POST)
    public ResponseEntity<Object> addNetworkFunction(@RequestBody NetworkFunctionRequestModel requestModel){

        ResponseModel respData = service.addNetworkFunction(requestModel);
        return new ResponseEntity<Object>(respData, respData.getStatus());

    }

    @RequestMapping(value = "/discoverNetworkFunction", method = RequestMethod.GET)
    public ResponseEntity<Object> newDiscoverNetworkFunction(@RequestParam String searchText,@RequestParam String searchType){
        ResponseModel respData = service.discoverNetworkFunction(searchText,searchType);
		return new ResponseEntity<Object>(respData, respData.getStatus());
    }

    @RequestMapping(value="/deleteNetworkFunction",method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteNetworkFunction(@RequestBody NetworkFunctionRequestModel requestModel){
        ResponseModel respData = service.deleteNetworkFunction(requestModel);
		return new ResponseEntity<Object>(respData, respData.getStatus());
    } 


    @RequestMapping(value="/updateNetworkFunction",method = RequestMethod.PUT)
    public ResponseEntity<Object> updateNetworkFunction(@RequestBody NetworkFunctionRequestModel requestModel){
        ResponseModel respData = service.updateNetworkFunction(requestModel);
		return new ResponseEntity<Object>(respData, respData.getStatus());
    }

    
    @RequestMapping(value="/viewAllNetworkFunction",method = RequestMethod.GET)
    public ResponseEntity<Object> viewAllNetworkFunction(){
        ResponseModel respData = service.viewAllNetworkFunction();
		return new ResponseEntity<Object>(respData, respData.getStatus());
    }


}
