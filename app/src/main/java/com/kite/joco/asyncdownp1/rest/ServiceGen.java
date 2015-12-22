package com.kite.joco.asyncdownp1.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;

import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.JacksonConverter;

/**
 * Created by Mester József on 2015.12.22..
 */
public class ServiceGen {
    // public static final String API_BASE_URL = "http://192.168.1.107:8080/NyomtServ2-1.0/webresources";// home
    // public static final String API_BASE_URL = "http://192.168.86.3:8080/NyomtServ2-1.0/webresources";// work
    public static final String API_BASE_URL = "http://192.168.3.90/NyomtServ2-1.0/webresources"; //éles

    /*
        private static RestAdapter.Builder builder = new RestAdapter.Builder()
                .setConverter(new JacksonConverter(new ObjectMapper()))
                .setEndpoint(API_BASE_URL)
                .setClient(new OkClient(new OkHttpClient()));

        public static <S> S createService(Class<S> serviceClass) {
            RestAdapter adapter = builder.build();
            return adapter.create(serviceClass);
        }

        */
    private static PartnerApi Jackson_API;

    static {
        setupOldFileClient();
    }

    public static PartnerApi get() {
        return Jackson_API;
    }

    private static void setupOldFileClient() {

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setConverter(new JacksonConverter(new ObjectMapper()))
                .setEndpoint(API_BASE_URL)
                .setClient(new OkClient(new OkHttpClient())).build();


        //RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(API_BASE_URL).build();


        Jackson_API = restAdapter.create(PartnerApi.class);
    }
}
