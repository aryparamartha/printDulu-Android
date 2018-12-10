package com.example.aryparamartha.printit.model;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class VendorTrans implements Parcelable {

	@SerializedName("file_location")
	private String fileLocation;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("nama_file")
	private String namaFile;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("trans_total")
	private int transTotal;

	@SerializedName("id_trans")
	private int idTrans;

	@SerializedName("id")
	private int id;

	@SerializedName("trans_file")
	private String transFile;

	@SerializedName("id_user")
	private int idUser;

	@SerializedName("format_file")
	private String formatFile;

	public void setFileLocation(String fileLocation){
		this.fileLocation = fileLocation;
	}

	public String getFileLocation(){
		return fileLocation;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setNamaFile(String namaFile){
		this.namaFile = namaFile;
	}

	public String getNamaFile(){
		return namaFile;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setTransTotal(int transTotal){
		this.transTotal = transTotal;
	}

	public int getTransTotal(){
		return transTotal;
	}

	public void setIdTrans(int idTrans){
		this.idTrans = idTrans;
	}

	public int getIdTrans(){
		return idTrans;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setTransFile(String transFile){
		this.transFile = transFile;
	}

	public String getTransFile(){
		return transFile;
	}

	public void setIdUser(int idUser){
		this.idUser = idUser;
	}

	public int getIdUser(){
		return idUser;
	}

	public void setFormatFile(String formatFile){
		this.formatFile = formatFile;
	}

	public String getFormatFile(){
		return formatFile;
	}

	@Override
 	public String toString(){
		return 
			"VendorTrans{" + 
			"file_location = '" + fileLocation + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",nama_file = '" + namaFile + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",trans_total = '" + transTotal + '\'' + 
			",id_trans = '" + idTrans + '\'' + 
			",id = '" + id + '\'' + 
			",trans_file = '" + transFile + '\'' + 
			",id_user = '" + idUser + '\'' + 
			",format_file = '" + formatFile + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {

	}
}