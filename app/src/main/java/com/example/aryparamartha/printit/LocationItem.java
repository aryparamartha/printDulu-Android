package com.example.aryparamartha.printit;

public class LocationItem {
    private int mLocImgRes;
    private String mLocName;
    private String mLocAddress;

    public LocationItem(int LocImgRes, String LocName, String LocAdrress){
        mLocImgRes= LocImgRes;
        mLocName = LocName;
        mLocAddress = LocAdrress;
    }

    public int getmmLocImgRes(){
        return mLocImgRes;
    }

    public String getmLocName(){
        return mLocName;
    }

    public String getmLocAddress(){
        return mLocAddress;
    }
}
