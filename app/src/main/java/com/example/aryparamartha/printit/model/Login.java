package com.example.aryparamartha.printit.model;

import com.google.gson.annotations.SerializedName;

public class Login{

	@SerializedName("success")
	private Success success;
    private boolean Admin;
	public void setSuccess(Success success){
		this.success = success;
	}

	public Success getSuccess(){
		return success;
	}

	@Override
 	public String toString(){
		return 
			"Login{" + 
			"success = '" + success + '\'' + 
			"}";
		}

    public boolean isAdmin() {
        return Admin;
    }

    public void setAdmin(boolean admin) {
        Admin = admin;
    }
}