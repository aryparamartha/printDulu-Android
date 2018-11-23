package com.example.aryparamartha.printit.model;

import com.google.gson.annotations.SerializedName;

public class ResponseRegister{

	@SerializedName("user")
	private User user;

	public void setUser(User user){
		this.user = user;
	}

	public User getUser(){
		return user;
	}

	@Override
 	public String toString(){
		return 
			"ResponseRegister{" + 
			"user = '" + user + '\'' + 
			"}";
		}
}