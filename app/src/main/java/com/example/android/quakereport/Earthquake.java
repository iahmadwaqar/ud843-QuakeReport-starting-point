package com.example.android.quakereport;

public class Earthquake {
    /* Magnitude of Earth quake */
    private double mMagnitude;

    /* Location of Earthquake */
    private String mLocation;

    /* Date of Earthquake */
    private Long mDate;

    // Url of Earthquake
    private String URL;

    /* Constructor to initialize the variables */

    public Earthquake(double magnitude, String location, Long date, String URL){
        mMagnitude = magnitude;
        mLocation = location;
        mDate = date;
        this.URL = URL;
    }

    /* return the value of Magnitude */
    public double getMagnitude (){ return mMagnitude; }

    /* Return the value of Location */
    public String getLocation(){return mLocation;}

    /* Return the value of Date */
    public Long getDate(){return mDate;}

    //Return the URL of Earthquake
    public String getURL(){return URL;}
}
