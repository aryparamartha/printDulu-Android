package com.example.aryparamartha.printit.User.MainMenu;

public class FileItem {
    private int mImageResource;
    private String mNamaFile;
    private String mDetailFile;

    public FileItem(int imageResource, String NamaFile, String DetailFile){
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
