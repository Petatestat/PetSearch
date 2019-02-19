package com.pisici.caini.petsearch;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Announcement> arr = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("announcement");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                arr.clear();
                arr.addAll(Announcement.filter(dataSnapshot));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        ListView mListView = (ListView) findViewById(R.id.resultsLV);

    }

    private class MyListAdapter extends ArrayAdapter<Announcement> {
        private int layout;

        public MyListAdapter(@NonNull Context context, int resource, @NonNull List<Announcement> objects) {
            super(context, resource, objects);
            layout = resource;
        }

        public class ViewHolder {
            TextView mSportTv;
            TextView mPlayersTv;
            TextView mLocationTv;
            TextView mTimeTv;
            Button mJoinBtn;
        }

        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            MainActivity.ViewHolder mainViewHolder = null;

            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(layout, parent, false);
                MainActivity.ViewHolder viewHolder = new MainActivity().ViewHolder();

                viewHolder.mSportTv = (TextView) convertView.findViewById(R.id.resultsSportTV);
                viewHolder.mSportTv.setText(getItem(position).getSport().toString());

                viewHolder.mJoinBtn = (Button) convertView.findViewById(R.id.joinLobbyBtn);

                viewHolder.mPlayersTv = (TextView) convertView.findViewById(R.id.resultsPlayersTV);
                viewHolder.mPlayersTv.setText(getItem(position).getSize() + "/" + getItem(position).getMaxSize());

                viewHolder.mLocationTv = (TextView) convertView.findViewById(R.id.locationTV);
                viewHolder.mLocationTv.setText(getItem(position).getLocationName());

                viewHolder.mTimeTv=(TextView) convertView.findViewById(R.id.results_timeTV);
                viewHolder.mTimeTv.setText(getItem(position).getDay()+"/"+(getItem(position).getMonth()+1)+"  "+getItem(position).getHour()
                        +":"+getItem(position).getMinute());

                viewHolder.mJoinBtn = (Button) convertView.findViewById(R.id.joinLobbyBtn);
                viewHolder.mJoinBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(ResultsActivity.this, LobbyActivity.class);
                        intent.putExtra("User", user);
                        LobbySports mlobby=(LobbySports)getItem(position);
                        mlobby.addUser(FirebaseAuth.getInstance().getUid());
                        intent.putExtra("Lobby", mlobby);
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                        finish();
                    }
                });
                convertView.setTag(viewHolder);
            } else {
                mainViewHolder = (ResultsActivity.ViewHolder) convertView.getTag();
                mainViewHolder.mSportTv.setText(getItem(position).getSport().toString());
                mainViewHolder.mPlayersTv.setText(getItem(position).getSize() + "/" + getItem(position).getMaxSize());
                mainViewHolder.mLocationTv.setText(getItem(position).getLocationName());
            }

            return convertView;
        }
    }
}
