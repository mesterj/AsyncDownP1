package com.kite.joco.asyncdownp1.db;

import com.orm.SugarRecord;
import com.orm.dsl.Unique;

import java.util.Date;

/**
 * Created by Mester József on 2015.12.22..
 */
public class Partner extends SugarRecord {

    @Unique
    private String partnerKod;

    private String partnerNev;

    private String partnerTelepules;

    private String partnerIrsz;
    private String partnerCim;

    private String partnerAdoszam;

    private String partnerEmail;

    private String status;

    private Date modifiedTime;

    private String baj;

    private String partnerAdoazonosito;

    public Partner() {
    }

    public Partner(String partnerKod, String partnerNev, String partnerTelepules, String partnerIrsz, String partnerCim, String partnerAdoszam, String partnerEmail, String status, Date modifiedTime, String baj, String partnerAdoazonosito) {
        this.partnerKod = partnerKod;
        this.partnerNev = partnerNev;
        this.partnerTelepules = partnerTelepules;
        this.partnerIrsz = partnerIrsz;
        this.partnerCim = partnerCim;
        this.partnerAdoszam = partnerAdoszam;
        this.partnerEmail = partnerEmail;
        this.status = status;
        this.modifiedTime = modifiedTime;
        this.baj = baj;
        this.partnerAdoazonosito = partnerAdoazonosito;
    }

    public String getPartnerKod() {
        return partnerKod;
    }

    public void setPartnerKod(String partnerKod) {
        this.partnerKod = partnerKod;
    }

    public String getPartnerNev() {
        return partnerNev;
    }

    public void setPartnerNev(String partnerNev) {
        this.partnerNev = partnerNev;
    }

    public String getPartnerTelepules() {
        return partnerTelepules;
    }

    public void setPartnerTelepules(String partnerTelepules) {
        this.partnerTelepules = partnerTelepules;
    }

    public String getPartnerIrsz() {
        return partnerIrsz;
    }

    public void setPartnerIrsz(String partnerIrsz) {
        this.partnerIrsz = partnerIrsz;
    }

    public String getPartnerCim() {
        return partnerCim;
    }

    public void setPartnerCim(String partnerCim) {
        this.partnerCim = partnerCim;
    }

    public String getPartnerAdoszam() {
        return partnerAdoszam;
    }

    public void setPartnerAdoszam(String partnerAdoszam) {
        this.partnerAdoszam = partnerAdoszam;
    }

    public String getPartnerEmail() {
        return partnerEmail;
    }

    public void setPartnerEmail(String partnerEmail) {
        this.partnerEmail = partnerEmail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getBaj() {
        return baj;
    }

    public void setBaj(String baj) {
        this.baj = baj;
    }

    public String getPartnerAdoazonosito() {
        return partnerAdoazonosito;
    }

    public void setPartnerAdoazonosito(String partnerAdoazonosito) {
        this.partnerAdoazonosito = partnerAdoazonosito;
    }
}
