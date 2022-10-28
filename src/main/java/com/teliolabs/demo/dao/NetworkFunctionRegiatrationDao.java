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
@Table(name="nf_network_function_registration")
public class NetworkFunctionRegiatrationDao {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="nfId")
    private int nfId;

    @Column(name="nfName")
    private String nfName;

    @Column(name="nfDescription")
    private String nfDescription;
}
