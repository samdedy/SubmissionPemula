package com.sam.alatmusiktradisional;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by sam on 16/06/2019.
 */

class AlatMusik implements Parcelable{
    private int mPhoto;
    private String mName;
    private String mAlamatAsal;

    protected AlatMusik(Parcel in) {
        mPhoto = in.readInt();
        mName = in.readString();
        mAlamatAsal = in.readString();
    }

    public static final Creator<AlatMusik> CREATOR = new Creator<AlatMusik>() {
        @Override
        public AlatMusik createFromParcel(Parcel in) {return new AlatMusik(in);}

        @Override
        public AlatMusik[] newArray(int size) {return new AlatMusik[size];}
    };

    public AlatMusik() {

    }

    // ---
    public int getPhoto() { return mPhoto; }

    public void setPhoto(int photo) { this.mPhoto = photo; }

    public String getName(){ return mName; }

    public void setName(String name) { this.mName = name; }

    public String getAlamatAsal() { return mAlamatAsal; }

    public void setAlamatAsal(String alamatAsal){
        this.mAlamatAsal = alamatAsal;
    }

    @Override
    public int describeContents() {return 0;}

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mPhoto);
        dest.writeString(mName);
        dest.writeString(mAlamatAsal);
    }

    // ---
}
