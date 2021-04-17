package com.hackaton.brainjacked.services;



import com.hackaton.brainjacked.DTO.BearerToken;
import com.hackaton.brainjacked.DTO.Person;
import com.hackaton.brainjacked.DTO.Register;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;
public interface UserService {

    @POST("users")
    Call<Person> register(@Body Register register);
    @POST("login")
    Call<BearerToken> login(@Header("Authorization") String basicAuthCredentials);

}
