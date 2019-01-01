package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.graphics.drawable.GradientDrawable;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(Context context, List<Earthquake> earthquakes){
        super(context,0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemview = convertView;
        if(listItemview == null){
            listItemview = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item,parent,false);
        }

        Earthquake currentEarthquake = getItem(position);




        /*Magnitude of the EarthQuake*/
        TextView magnitudeView = (TextView) listItemview.findViewById(R.id.magnitude);
        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        magnitudeView.setText(magnitudeFormatter(currentEarthquake.getMagnitude()));



        /*Split and display the location of Quake*/
        String primaryLocaiton;
        String secondaryLocation;
        String location;
        location = currentEarthquake.getLocation();
        if(location.contains(" of ")) {
            String locationSplit[] = location.split(("(?<=of)"));
            primaryLocaiton = locationSplit[1];
            secondaryLocation = locationSplit[0];
        }
        else {
            primaryLocaiton = location;
            secondaryLocation = "Near of ";
        }

        TextView primaryLocationView = (TextView) listItemview.findViewById(R.id.primary_location);
        primaryLocationView.setText(primaryLocaiton);

        TextView nearLocationView = (TextView) listItemview.findViewById(R.id.location_offset);
        nearLocationView.setText(secondaryLocation);


        /*FOrmat and display the date and time */
        Date dateObject = new Date(currentEarthquake.getDate());

        TextView dateView = (TextView) listItemview.findViewById(R.id.date);
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        String strDate = dateFormat.format(dateObject);
        dateView.setText(strDate);


        TextView timeView = (TextView) listItemview.findViewById(R.id.time);
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        String strtime = timeFormat.format(dateObject);
        timeView.setText(strtime);

        return listItemview;
    }


    private String magnitudeFormatter(double mag){
        DecimalFormat formatter = new DecimalFormat("0.0");
        return formatter.format(mag);
    }


    private int getMagnitudeColor(double magnitude){
        int magnitudeFloor = (int) Math.floor(magnitude);
        int color = ContextCompat.getColor(getContext(), R.color.magnitude1);
        switch (magnitudeFloor){
            case 1:
                color = ContextCompat.getColor(getContext(), R.color.magnitude1);
                break;

            case 2:
                color = ContextCompat.getColor(getContext(), R.color.magnitude2);
                break;

            case 3:
                color = ContextCompat.getColor(getContext(), R.color.magnitude3);
                break;

            case 4:
                color = ContextCompat.getColor(getContext(), R.color.magnitude4);
                break;

            case 5:
                color = ContextCompat.getColor(getContext(), R.color.magnitude5);
                break;

            case 6:
                color = ContextCompat.getColor(getContext(), R.color.magnitude6);
                break;

            case 7:
                color = ContextCompat.getColor(getContext(), R.color.magnitude7);
                break;

            case 8:
                color = ContextCompat.getColor(getContext(), R.color.magnitude8);
                break;

            case 9:
                color = ContextCompat.getColor(getContext(), R.color.magnitude9);
                break;

            case 10:
                color = ContextCompat.getColor(getContext(), R.color.magnitude10plus);
                break;

                default:
                    color = ContextCompat.getColor(getContext(), R.color.magnitude10plus);
                    break;
        }

                return color;

    }

}
