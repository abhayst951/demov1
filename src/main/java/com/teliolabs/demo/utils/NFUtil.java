package com.teliolabs.demo.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.teliolabs.demo.model.NetworkFunctionRequestModel;



public class NFUtil {
    public static boolean containsSpecialCharacters(String inputString){
        if(inputString!=null){
            Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
            Matcher matcher = pattern.matcher(inputString);
            return matcher.find();    
        }
        return false;
    }


    /*TODO
    fqdn ,ip address should allow . (dot)
    space check
    
*/
    public boolean validatefqdnAndIpAddress(String inputString){
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(inputString);
        return matcher.find();
    }

    public static boolean validateReqModel(NetworkFunctionRequestModel requestModel){
        if(requestModel!=null){
            String fqdn = requestModel.getFqdn();
            String ipAddress = requestModel.getIpAddress();
            String location = requestModel.getLocation();
            String nfInstanceId = requestModel.getNfInstanceId();
            String nfType = requestModel.getNfType();
            String nfStatus = requestModel.getNfStatus();

            if(!containsSpecialCharacters(nfInstanceId) && !isBlankOrNull(nfType) && !isBlankOrNull(nfStatus)//Mandatory Field
            && !isBlankOrNull(fqdn) && !containsSpecialCharacters(fqdn) 
            && !isBlankOrNull(ipAddress) && !containsSpecialCharacters(ipAddress) 
            && !isBlankOrNull(location) && !isBlankOrNull(nfInstanceId)){
                return true;
            }
            

        }
        return false;
    }

    public static boolean isBlankOrNull(String inputString){
        if(inputString==null || inputString.isEmpty() ){
            return true;
        }
        return false;
    }
}
