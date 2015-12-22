package com.kite.joco.asyncdownp1.rest;

import com.kite.joco.asyncdownp1.db.Partner;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Mester József on 2015.12.22..
 */
public interface PartnerApi {

    @GET("/com.joco.nyomtserv2.partner")
    public void getAsyncListofPartner(Callback<List<Partner>> callback);

    @GET("/com.joco.nyomtserv2.partner")
    public List<Partner> getSyncListOfPartner();
}
