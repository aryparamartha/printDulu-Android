package com.example.aryparamartha.printit.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class User implements Parcelable {

	@SerializedName("address")
	private String address;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("phone")
	private String phone;

	@SerializedName("name")
	private String name;

	@SerializedName("admin_status")
	private String adminStatus;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private String id;

	@SerializedName("email")
	private String email;

	@SerializedName("rek_bank")
	private String rekBank;

	protected User(Parcel in) {
		address = in.readString();
		updatedAt = in.readString();
		phone = in.readString();
		name = in.readString();
		adminStatus = in.readString();
		createdAt = in.readString();
		id = in.readString();
		email = in.readString();
		rekBank = in.readString();
	}

	public static final Creator<User> CREATOR = new Creator<User>() {
		@Override
		public User createFromParcel(Parcel in) {
			return new User(in);
		}

		@Override
		public User[] newArray(int size) {
			return new User[size];
		}
	};

	public User(String nama, String id_user, String id_status){
		this.name = nama;
		this.id = id_user;
		this.adminStatus = id_status;
	}

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

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setAdminStatus(String adminStatus){
		this.adminStatus = adminStatus;
	}

	public String getAdminStatus(){
		return adminStatus;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setRekBank(){
		this.rekBank = rekBank;
	}

	public String getRekBank(){
		return rekBank;
	}


	@Override
 	public String toString(){
		return 
			"User{" + 
			"address = '" + address + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",phone = '" + phone + '\'' + 
			",name = '" + name + '\'' + 
			",admin_status = '" + adminStatus + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",id = '" + id + '\'' + 
			",email = '" + email + '\'' +
			",rek_bank = '" + rekBank + '\''+
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(address);
		dest.writeString(updatedAt);
		dest.writeString(phone);
		dest.writeString(name);
		dest.writeString(adminStatus);
		dest.writeString(createdAt);
		dest.writeString(id);
		dest.writeString(email);
		dest.writeString(rekBank);
	}
}