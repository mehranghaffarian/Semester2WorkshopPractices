package com.company;

/**
 * A class for each music data
 * @author mehran
 * */
public class Musics {
    private String singerName;
    private String address;
    private int publishYear;

    public Musics(String sNAme, String address, int year){
        singerName = sNAme;
        this.address = address;
        publishYear = year;
    }

    /**
     * @param sName given name to set
     * @param address to set
     * @param year to set
     * */
    public void setMusic(String sName, String address, int year){
        singerName = sName;
        this.address = address;
        publishYear = year;
    }

    /**
     * @return singerName
     * */
    public String getSingerName(){return singerName;}

    /**
     * @return the address
     * */
    public String getAddress(){return address;}

    /**
     * @return the publish year
     * */
    public int getPublishYear(){return publishYear;}
}
