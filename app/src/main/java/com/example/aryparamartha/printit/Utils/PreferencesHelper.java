package com.example.aryparamartha.printit.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.aryparamartha.printit.model.ResponseLogin;
import com.example.aryparamartha.printit.model.User;

public class PreferencesHelper {
    private SharedPreferences sharedPreferences;
    private final String PREFERENCES_NAME = "shared_preferences";
    private final String LOGIN="login";
    private final String TOKEN="token";
    private final String NAME="name";
    private final String USER_TYPE="user_type";

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

    public void setName(String name){
        sharedPreferences.edit()
                .putString(NAME,name)
                .apply();
    }

    public String getName(){
        return sharedPreferences.getString(NAME,"");
    }

    public void setUserType(String userType){
        sharedPreferences.edit()
                .putString(USER_TYPE,userType)
                .apply();
    }

    public String getUserType(){
        return sharedPreferences.getString(USER_TYPE,"1");
    }

    public void setUserLogin(User user, ResponseLogin responseLogin){
        setLogin(true);
        setToken(responseLogin.getToken());
        setName(user.getName());
        setUserType(user.getAdminStatus());
    }

    public void logout(){
        sharedPreferences.edit()
                .clear()
                .apply();
    }
}
