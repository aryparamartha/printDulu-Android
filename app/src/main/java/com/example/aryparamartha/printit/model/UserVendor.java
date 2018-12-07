package com.example.aryparamartha.printit.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class UserVendor implements Parcelable {

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

	@SerializedName("rek_bank")
	private String rekBank;

	@SerializedName("admin_status")
	private int adminStatus;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("email_verified_at")
	private String emailVerifiedAt;

	@SerializedName("id")
	private int id;

	@SerializedName("email")
	private String email;

	protected UserVendor(Parcel in) {
		address = in.readString();
		updatedAt = in.readString();
		phone = in.readString();
		profilePic = in.readString();
		name = in.readString();
		rekBank = in.readString();
		adminStatus = in.readInt();
		createdAt = in.readString();
		emailVerifiedAt = in.readString();
		id = in.readInt();
		email = in.readString();
	}

	public static final Creator<UserVendor> CREATOR = new Creator<UserVendor>() {
		@Override
		public UserVendor createFromParcel(Parcel in) {
			return new UserVendor(in);
		}

		@Override
		public UserVendor[] newArray(int size) {
			return new UserVendor[size];
		}
	};

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

	public void setEmailVerifiedAt(String emailVerifiedAt){
		this.emailVerifiedAt = emailVerifiedAt;
	}

	public String getEmailVerifiedAt(){
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
			"UserVendor{" + 
			"address = '" + address + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",phone = '" + phone + '\'' + 
			",profile_pic = '" + profilePic + '\'' + 
			",name = '" + name + '\'' + 
			",rek_bank = '" + rekBank + '\'' + 
			",admin_status = '" + adminStatus + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",email_verified_at = '" + emailVerifiedAt + '\'' + 
			",id = '" + id + '\'' + 
			",email = '" + email + '\'' + 
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
		dest.writeString(profilePic);
		dest.writeString(name);
		dest.writeString(rekBank);
		dest.writeInt(adminStatus);
		dest.writeString(createdAt);
		dest.writeString(emailVerifiedAt);
		dest.writeInt(id);
		dest.writeString(email);
	}
}