package com.example.aryparamartha.printit.model;

import com.google.gson.annotations.SerializedName;
public class Response{

	@SerializedName("success")
	private Success success;

	public void setSuccess(Success success){
		this.success = success;
	}

	public Success getSuccess(){
		return success;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"success = '" + success + '\'' + 
			"}";
		}
}