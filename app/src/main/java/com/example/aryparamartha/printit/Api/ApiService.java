package com.example.aryparamartha.printit.Api;

import com.example.aryparamartha.printit.model.CreateTrans;
import com.example.aryparamartha.printit.model.Profile;
import com.example.aryparamartha.printit.model.ResponseCreateTrans;
import com.example.aryparamartha.printit.model.ResponseRegister;
import com.example.aryparamartha.printit.model.UserLogin;
import com.example.aryparamartha.printit.model.UserTrans;
import com.example.aryparamartha.printit.model.UserVendor;
import com.example.aryparamartha.printit.model.VendorTrans;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

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

    @GET("vendor/trans")
    Call<List<VendorTrans>> showTransactionVendor();

    @FormUrlEncoded
    @POST("user/profile/{id}")
    Call<com.example.aryparamartha.printit.model.Response> saveProfile(
            @Path("id") int id,
            @Field("name") String name,
            @Field("address") String address,
            @Field("phone") String phone
            );

    @FormUrlEncoded
    @POST("user/save/fcm/{id}")
    Call<com.example.aryparamartha.printit.model.Response> saveFCM(
        @Path("id") int id,
        @Field("fcm_token") String fcm_token
    );

    @FormUrlEncoded
    @POST("trans/create")
    Call<ResponseCreateTrans> createTrans(
            @Field("id_user") String idUser,
            @Field("id_vendor") String idVendor,
            @Field("nama_file") String namaFile,
            @Field("file_location") String fileLoc,
            @Field("format_file") String formatFile
    );

    @FormUrlEncoded
    @POST("trans/update/{id}")
    Call<Void> updateTrans(
            @Path("id") int id,
            @Field("nama_file") String namaFile,
            @Field("file_location") String fileLocation,
            @Field("format_file") String formatFile,
            @Field("nomor_transfer") String buktiPembayaran,
            @Field("trans_total") String transTotal,
            @Field("id_status") String idStatus
    );


}
