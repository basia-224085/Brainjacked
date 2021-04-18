package com.hackaton.brainjacked.services;

import com.hackaton.brainjacked.DTO.Login;
import com.hackaton.brainjacked.DTO.LoginReturn;
import com.hackaton.brainjacked.DTO.Register;
import com.hackaton.brainjacked.DTO.RegisterReturn;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {

    @POST("humans/login")
    Call<LoginReturn> login(@Body Login basicAuthCredentials);

    @POST("users/register")
    Call<RegisterReturn> register(@Body Register register);

}
