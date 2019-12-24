package com.example.myproject;

import android.provider.ContactsContract;
import android.widget.ImageButton;

public class Group {
    private String aType;
    private String aName;
    private String aAddress;
    private String aTag1;
    private String aTag2;
    private int aImage;
    private int aLike;

    public Group(){}

    public Group(String aType,String aName,String aAddress,String aTag1,String aTag2,int aImage){
        this.aType = aType;
        this.aName = aName;
        this.aAddress = aAddress;
        this.aTag1 = aTag1;
        this.aTag2 = aTag2;
        this.aImage = aImage;
    }

    public int getaImage() {
        return aImage;
    }

    public String getaType() {
        return aType;
    }

    public String getaName() {
        return aName;
    }

    public String getaAddress() {
        return aAddress;
    }

    public String getaTag1() {
        return aTag1;
    }

    public String getaTag2() {
        return aTag2;
    }

    public void setaType(String aType) {
        this.aType = aType;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public void setaAddress(String aAddress) {
        this.aAddress = aAddress;
    }

    public void setaTag1(String aTag1) {
        this.aTag1 = aTag1;
    }

    public void setaTag2(String aTag2) {
        this.aTag2 = aTag2;
    }

    public void setaImage(int aImage) {
        this.aImage = aImage;
    }

    public int getaLike(){
        return aLike;
    }
}
