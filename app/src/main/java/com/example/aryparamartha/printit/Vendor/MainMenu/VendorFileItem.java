package com.example.aryparamartha.printit.Vendor.MainMenu;

public class VendorFileItem {
    private int mImageResource;
    private String mNamaFile;
    private String mDetailFile;

    public VendorFileItem(int imageResource, String NamaFile, String DetailFile){
        mImageResource = imageResource;
        mNamaFile = NamaFile;
        mDetailFile = DetailFile;
    }

    public void changeText1(String text){
        mNamaFile = text;
    }

    public int getmImageResource(){
        return mImageResource;
    }

    public String getmNamaFile(){
        return mNamaFile;
    }

    public String getmDetailFile(){
        return mDetailFile;
    }
}
