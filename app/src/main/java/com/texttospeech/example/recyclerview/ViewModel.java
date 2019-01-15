package com.texttospeech.example.recyclerview;

import android.os.Parcel;
import android.os.Parcelable;

public class ViewModel implements Parcelable {
    private String name;
    private String mail;
    private int res;
    private boolean checked;

    public ViewModel(String name, String mail, int res) {
        this.name = name;
        this.mail = mail;
        this.res = res;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    protected ViewModel(Parcel in) {
        name = in.readString();
        mail = in.readString();
        res = in.readInt();
        checked = in.readByte() != 0x00;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(mail);
        dest.writeInt(res);
        dest.writeByte((byte) (checked ? 0x01 : 0x00));
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<ViewModel> CREATOR = new Parcelable.Creator<ViewModel>() {
        @Override
        public ViewModel createFromParcel(Parcel in) {
            return new ViewModel(in);
        }

        @Override
        public ViewModel[] newArray(int size) {
            return new ViewModel[size];
        }
    };
}
