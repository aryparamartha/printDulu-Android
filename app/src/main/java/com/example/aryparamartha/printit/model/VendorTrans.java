package com.example.aryparamartha.printit.model;


import android.os.Parcel;
import android.os.Parcelable;
import android.provider.BaseColumns;

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

	@SerializedName("nomer_transfer")
	private String transFile;

	@SerializedName("id_user")
	private int idUser;

	@SerializedName("format_file")
	private String formatFile;

	public VendorTrans(Parcel in) {
		fileLocation = in.readString();
		updatedAt = in.readString();
		namaFile = in.readString();
		createdAt = in.readString();
		transTotal = in.readInt();
		idTrans = in.readInt();
		id = in.readInt();
		transFile = in.readString();
		idUser = in.readInt();
		formatFile = in.readString();
	}

	public static final Creator<VendorTrans> CREATOR = new Creator<VendorTrans>() {
		@Override
		public VendorTrans createFromParcel(Parcel in) {
			return new VendorTrans(in);
		}

		@Override
		public VendorTrans[] newArray(int size) {
			return new VendorTrans[size];
		}
	};

	public VendorTrans(String created, String format, int idtrans, String location, String name, int trans, String transfile, int transtotal, String updated, int user) {
	}

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
		dest.writeString(fileLocation);
		dest.writeString(updatedAt);
		dest.writeString(namaFile);
		dest.writeString(createdAt);
		dest.writeInt(transTotal);
		dest.writeInt(idTrans);
		dest.writeInt(id);
		dest.writeString(transFile);
		dest.writeInt(idUser);
		dest.writeString(formatFile);
	}

	public static class Entry implements BaseColumns {
		public static final String TABLE_NAME = "tb_transaction";
		public static final String COLUMN_LOCATION = "location";
		public static final String COLUMN_UPDATED = "updated";
		public static final String COLUMN_NAME = "name";
		public static final String COLUMN_CREATED = "created";
		public static final String COLUMN_TRANSTOTAL = "total";
		public static final String COLUMN_IDTRANS = "idtrans";
		public static final String COLUMN_TRANS = "id";
		public static final String COLUMN_TRANSFILE = "file";
		public static final String COLUMN_USER = "user";
		public static final String COLUMN_FORMAT = "format";


	}
}