package com.example.android.quakereport;

public class Earthquake {
    /* Magnitude of Earth quake */
    private double mMagnitude;

    /* Location of Earthquake */
    private String mLocation;

    /* Date of Earthquake */
    private Long mDate;

    /* Constructor to initialize the variables */

    public Earthquake(double magnitude, String location, Long date){
        mMagnitude = magnitude;
        mLocation = location;
        mDate = date;
    }

    /* return the value of Magnitude */
    public double getMagnitude (){ return mMagnitude; }

    /* Return the value of Location */
    public String getLocation(){return mLocation;}

    /* Return the value of Date */
    public Long getDate(){return mDate;}
}
