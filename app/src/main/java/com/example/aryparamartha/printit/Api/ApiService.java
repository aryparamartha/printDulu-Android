package com.example.aryparamartha.printit.Api;

import com.example.aryparamartha.printit.model.Login;
import com.example.aryparamartha.printit.model.ResponseLogin;
import com.example.aryparamartha.printit.model.ResponseRegister;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    @FormUrlEncoded
    @POST("user/login")
    Call<ResponseLogin> login(
      @Field("email") String email,
      @Field("password") String password
    );

    @FormUrlEncoded
    @POST("user/register")
    Call<ResponseRegister> register(
      @Field("name") String name,
      @Field("email") String email,
      @Field("phone") String phone,
      @Field("address") String address,
      @Field("rek_bank") String rekBank,
      @Field("password") String password,
      @Field("admin_status") String adminStatus
    );
}
