package com.teliolabs.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NetworkFunctionRegistrationRequestModel {
    public int nfId;
    public String nfName;
    public String nfDescription;
}
