package com.example.aryparamartha.printit.model;

import com.google.gson.annotations.SerializedName;

public class ResponseCreateTrans {

    @SerializedName("trans_date")
    private String transDate;

    @SerializedName("id_status")
    private String idStatus;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("file_desc")
    private String fileDesc;

    @SerializedName("id_vendor")
    private String idVendor;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("file_link")
    private String fileLink;

    @SerializedName("id_user")
    private String idUser;

    @SerializedName("id")
    private int id;

    public void setTransDate(String transDate){
        this.transDate = transDate;
    }

    public String getTransDate(){
        return transDate;
    }

    public void setIdStatus(String idStatus){
        this.idStatus = idStatus;
    }

    public String getIdStatus(){
        return idStatus;
    }

    public void setUpdatedAt(String updatedAt){
        this.updatedAt = updatedAt;
    }

    public String getUpdatedAt(){
        return updatedAt;
    }

    public void setFileDesc(String fileDesc){
        this.fileDesc = fileDesc;
    }

    public String getFileDesc(){
        return fileDesc;
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

    public void setFileLink(String fileLink){
        this.fileLink = fileLink;
    }

    public String getFileLink(){
        return fileLink;
    }

    public void setIdUser(String idUser){
        this.idUser = idUser;
    }

    public String getIdUser(){
        return idUser;
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
                "ResponseCreateTrans{" +
                        "trans_date = '" + transDate + '\'' +
                        ",id_status = '" + idStatus + '\'' +
                        ",updated_at = '" + updatedAt + '\'' +
                        ",file_desc = '" + fileDesc + '\'' +
                        ",id_vendor = '" + idVendor + '\'' +
                        ",created_at = '" + createdAt + '\'' +
                        ",file_link = '" + fileLink + '\'' +
                        ",id_user = '" + idUser + '\'' +
                        ",id = '" + id + '\'' +
                        "}";
    }
}
