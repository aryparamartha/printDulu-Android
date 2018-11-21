package com.example.aryparamartha.printit.Api;

import com.example.aryparamartha.printit.model.Login;
import com.example.aryparamartha.printit.model.ResponseLogin;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    @FormUrlEncoded
    @POST("printer")
    Call<Login> addPrinter(
      @Field("printer_name") String printer_name,
      @Field("printer_address") String printer_address,
      @Field("printer_email") String printer_email
    );

    @FormUrlEncoded
    @POST("user/login")
    Call<ResponseLogin> login(
      @Field("email") String email,
      @Field("password") String password
    );
}
