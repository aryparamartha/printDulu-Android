package com.example.aryparamartha.printit.Api;

import android.content.Context;

import com.example.aryparamartha.printit.Utils.PreferencesHelper;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static ApiService getService(Context context){
        final PreferencesHelper preferencesHelper = new PreferencesHelper(context);

        OkHttpClient client=new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request;
                        if (preferencesHelper.getLogin()){
                            request=chain
                                    .request()
                                    .newBuilder()
                                    .addHeader("Context-Type", "application/json")
                                    .addHeader("Authorization", "Bearer "+preferencesHelper.getToken())
                                    .build();
                        }else {
                            request=chain
                                    .request()
                                    .newBuilder()
                                    .addHeader("Context-Type", "application/json")
                                    .build();
                        }
                        return chain.proceed(request);
                    }
                }).build();
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("http://192.168.1.71:8000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(ApiService.class);
    }
}
