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
                                    .addHeader("Accept", "application/json")
                                    .addHeader("Authorization", "Bearer "+preferencesHelper.getToken())
                                    .build();
                        }else {
                            request=chain
                                    .request()
                                    .newBuilder()
                                    .addHeader("Accept", "application/json")
                                    .build();
                        }
                        return chain.proceed(request);
                    }
                }).build();

        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("http://172.20.10.3:8000/api/")
//                .baseUrl("http://10.166.207.182:8000/api/")
//                .baseUrl("http://10.166.208.139:8000/api/")
//                .baseUrl("http://192.168.1.67:8000/api/")
//                .baseUrl("http://10.10.13.211:8000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit.create(ApiService.class);
    }
}
