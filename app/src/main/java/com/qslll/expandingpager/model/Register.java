package com.qslll.expandingpager.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Register implements Parcelable {
    String registerAs;

    public Register(String registerAs) {
        this.registerAs = registerAs;
    }

    protected Register(Parcel in) {
        registerAs = in.readString();
    }

    public static final Creator<Register> CREATOR = new Creator<Register>() {
        @Override
        public Register createFromParcel(Parcel in) {
            return new Register(in);
        }

        @Override
        public Register[] newArray(int size) {
            return new Register[size];
        }
    };

    public String getRegisterAs() {
        return registerAs;
    }

    public void setRegisterAs(String registerAs) {
        this.registerAs = registerAs;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(registerAs);
    }
}
