package com.company;

public class Musics {
    private String singerName;
    private String address;
    private int publishYear;

    public Musics(String sNAme, String address, int year){
        singerName = sNAme;
        this.address = address;
        publishYear = year;
    }

    public void setMusic(String sName, String address, int year){
        singerName = sName;
        this.address = address;
        publishYear = year;
    }

    public String getSingerName(){return singerName;}

    public String getAddress(){return address;}

    public int getPublishYear(){return publishYear;}
}
