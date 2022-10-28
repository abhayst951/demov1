package com.teliolabs.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SiteRegistrationModel {
    public int siteId;
    public String siteName;
    public String siteDescription;
}
