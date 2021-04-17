package com.hackaton.brainjacked.services;

import com.hackaton.brainjacked.DTO.Login;
import com.hackaton.brainjacked.DTO.LoginReturn;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {

    @POST("login")
    Call<LoginReturn> login(@Body Login basicAuthCredentials);

}
