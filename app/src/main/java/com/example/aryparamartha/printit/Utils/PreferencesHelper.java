package com.example.aryparamartha.printit.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.aryparamartha.printit.model.UserLogin;

public class PreferencesHelper {
    private SharedPreferences sharedPreferences;
    private final String PREFERENCES_NAME = "userInfo";
    private final String LOGIN="login";
    private final String TOKEN="token";
    private final String NAME="name";
    private final String PHONE="phone";
    private final String ADDRESS="address";
    private final String USER_TYPE="user_type";
    private final String ID="id";
    private final String FCM_TOKEN="fcm_token";

    public PreferencesHelper(Context context){
        sharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);

    }

    public void setLogin(boolean login){
        sharedPreferences.edit().putBoolean(LOGIN, login).apply();
    }

    public boolean getLogin(){
        return sharedPreferences.getBoolean(LOGIN, false);
    }

    public void setToken(String token){
        sharedPreferences.edit().putString(TOKEN,token).apply();
    }

    public String getToken(){
        return sharedPreferences.getString(TOKEN,"");
    }

    public void setFCMToken(String fcm_token){
        sharedPreferences.edit().putString(FCM_TOKEN,fcm_token).apply();
    }

    public String getFCMToken() {
        return sharedPreferences.getString(FCM_TOKEN, "");
    }


    public void setName(String name){
        sharedPreferences.edit()
                .putString(NAME,name)
                .apply();
    }

    public void setID(int id){
        sharedPreferences.edit()
                .putInt(ID, id)
                .apply();
    }

    public int getID(){
        return sharedPreferences.getInt(ID,0);
    }


    public String getName(){
        return sharedPreferences.getString(NAME,"");
    }

    public String getPhone(){
        return sharedPreferences.getString(PHONE,"");
    }

    public void setPhone(String phone){
        sharedPreferences.edit()
                .putString(PHONE,phone)
                .apply();
    }

    public String getAddress(){
        return sharedPreferences.getString(ADDRESS,"");
    }
    public void setAddress(String address){
        sharedPreferences.edit()
                .putString(ADDRESS,address)
                .apply();
    }

    public void setUserType(int userType){
        sharedPreferences.edit()
                .putInt(USER_TYPE,userType)
                .apply();
    }

    public int getUserType(){
        return sharedPreferences.getInt(USER_TYPE,0);
    }

    public void setUserLogin(UserLogin responseLogin){
        setLogin(true);
        setID(responseLogin.getId());
        setToken(responseLogin.getToken());
        setName(responseLogin.getName());
        setPhone(responseLogin.getPhone());
        setAddress(responseLogin.getAddress());
        setUserType(Integer.parseInt(responseLogin.getAdminStatus()));
    }

    public void logout(){
        sharedPreferences.edit()
                .clear()
                .apply();
    }
}
