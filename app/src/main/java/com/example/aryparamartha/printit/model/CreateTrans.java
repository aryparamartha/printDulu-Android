package com.example.aryparamartha.printit.model;

import com.google.gson.annotations.SerializedName;

public class CreateTrans {
    @SerializedName("file_desc")
    private String fileDesc;

    @SerializedName("trans_date")
    private String transDate;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("id_vendor")
    private String idVendor;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("id_user")
    private String idUser;

    @SerializedName("trans_file")
    private String transFile;

    @SerializedName("id")
    private int id;


    public String getFileDesc() {
        return fileDesc;
    }

    public void setFileDesc(String fileDesc) {
        this.fileDesc = fileDesc;
    }

    public void setTransDate(String transDate){
        this.transDate = transDate;
    }

    public String getTransDate(){
        return transDate;
    }

    public void setUpdatedAt(String updatedAt){
        this.updatedAt = updatedAt;
    }

    public String getUpdatedAt(){
        return updatedAt;
    }

    public void setIdVendor(String idVendor){
        this.idVendor = idVendor;
    }

    public String getIdVendor(){
        return idVendor;
    }

    public void setCreatedAt(String createdAt){
        this.createdAt = createdAt;
    }

    public String getCreatedAt(){
        return createdAt;
    }

    public void setIdUser(String idUser){
        this.idUser = idUser;
    }

    public String getIdUser(){
        return idUser;
    }

    public void setTransFile(String transFile){
        this.transFile = transFile;
    }

    public String getTransFile(){
        return transFile;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    @Override
    public String toString(){
        return
                "CreateTrans{" +
                        "trans_date = '" + transDate + '\'' +
                        ",updated_at = '" + updatedAt + '\'' +
                        ",id_vendor = '" + idVendor + '\'' +
                        ",created_at = '" + createdAt + '\'' +
                        ",id_user = '" + idUser + '\'' +
                        ",trans_file = '" + transFile + '\'' +
                        ",file_desc = '" + fileDesc + '\'' +
                        ",id = '" + id + '\'' +
                        "}";
    }
}
