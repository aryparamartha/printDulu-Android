package com.example.aryparamartha.printit.Api;

import com.example.aryparamartha.printit.model.Profile;
import com.example.aryparamartha.printit.model.ResponseRegister;
import com.example.aryparamartha.printit.model.UserLogin;
import com.example.aryparamartha.printit.model.UserTrans;
import com.example.aryparamartha.printit.model.UserVendor;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @FormUrlEncoded
    @POST("user/login")
    Call<UserLogin> login(
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

    @GET("user/profile")
    Call<Profile> profile();

    @POST("user/profile")
    Call<Response> editProfile(
            @Field("name") String name,
            @Field("phone") String phone,
            @Field("address") String address
    );

    @GET("user/vendor")
    Call<List<UserVendor>> showVendor();

    @GET("user/trans")
    Call<List<UserTrans>> showTransaction();


}
