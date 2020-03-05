package com.etcmobileapps.sondepremlerapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Repo {

    @SerializedName("tarih")
    @Expose
    public String tarih;
    @SerializedName("saat")
    @Expose
    public String saat;
    @SerializedName("enlem")
    @Expose
    public Double enlem;
    @SerializedName("boylam")
    @Expose
    public Double boylam;
    @SerializedName("derinlik")
    @Expose
    public String derinlik;
    @SerializedName("buyukluk")
    @Expose
    public String buyukluk;
    @SerializedName("yer")
    @Expose
    public String yer;
    @SerializedName("sehir")
    @Expose
    public String sehir;

}