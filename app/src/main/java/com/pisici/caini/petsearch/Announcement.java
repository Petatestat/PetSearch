package com.pisici.caini.petsearch;

import android.location.Location;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Announcement {
    Pet pet;
    String date;
    String location;
    public static ArrayList<Announcement> filter(DataSnapshot dataSnapshot) {

        ArrayList<Announcement> arr = new ArrayList<>();

        Log.d("BUGS", "aici incepe sa filtreze");
        for (DataSnapshot ds : dataSnapshot.getChildren()) {
            Announcement curr = ds.getValue(Announcement.class);
            arr.add(curr);
        }

        return arr;
    }
}
