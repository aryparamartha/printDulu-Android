package com.example.aryparamartha.printit.model;
import com.google.gson.annotations.SerializedName;

public class ResponseLogin{

	@SerializedName("user")
	private User user;

	@SerializedName("token")
	private String token;

	@SerializedName("admin_status")
	private String admin_status;

	public void setUser(User user){
		this.user = user;
	}

	public User getUser(){
		return user;
	}

	public void setToken(String token){
		this.token = token;
	}

	public String getToken(){
		return token;
	}

	public String getAdmin_status() {
		return admin_status;
	}

	public void setAdmin_status(String admin_status) {
		this.admin_status = admin_status;
	}

	@Override
 	public String toString(){
		return 
			"ResponseLogin{" + 
			"user = '" + user + '\'' + 
			",token = '" + token + '\'' +
			",admin_status = '" + admin_status + '\'' +
			"}";
		}
}