package com.example.aryparamartha.printit.model;

import com.google.gson.annotations.SerializedName;

public class Profile{

	@SerializedName("address")
	private String address;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("phone")
	private String phone;

	@SerializedName("profile_pic")
	private String profilePic;

	@SerializedName("name")
	private String name;

	@SerializedName("fcm_token")
	private String fcmToken;

	@SerializedName("rek_bank")
	private String rekBank;

	@SerializedName("admin_status")
	private int adminStatus;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("email_verified_at")
	private int emailVerifiedAt;

	@SerializedName("id")
	private int id;

	@SerializedName("email")
	private String email;

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return address;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return phone;
	}

	public void setProfilePic(String profilePic){
		this.profilePic = profilePic;
	}

	public String getProfilePic(){
		return profilePic;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setFcmToken(String fcmToken){
		this.fcmToken = fcmToken;
	}

	public String getFcmToken(){
		return fcmToken;
	}

	public void setRekBank(String rekBank){
		this.rekBank = rekBank;
	}

	public String getRekBank(){
		return rekBank;
	}

	public void setAdminStatus(int adminStatus){
		this.adminStatus = adminStatus;
	}

	public int getAdminStatus(){
		return adminStatus;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setEmailVerifiedAt(int emailVerifiedAt){
		this.emailVerifiedAt = emailVerifiedAt;
	}

	public int getEmailVerifiedAt(){
		return emailVerifiedAt;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"Profile{" + 
			"address = '" + address + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",phone = '" + phone + '\'' + 
			",profile_pic = '" + profilePic + '\'' + 
			",name = '" + name + '\'' + 
			",fcm_token = '" + fcmToken + '\'' + 
			",rek_bank = '" + rekBank + '\'' + 
			",admin_status = '" + adminStatus + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",email_verified_at = '" + emailVerifiedAt + '\'' + 
			",id = '" + id + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}