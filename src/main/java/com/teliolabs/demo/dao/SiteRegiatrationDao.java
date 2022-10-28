package com.teliolabs.demo.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="nf_siteRegistration")
public class SiteRegiatrationDao {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="siteId")
    private int siteId;

    @Column(name="siteName")
    private String siteName;

    @Column(name="siteDescription")
    private String siteDescription;

}
