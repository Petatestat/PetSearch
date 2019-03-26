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
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
     ArrayList<Announcement> arr = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("announcement");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                arr.clear();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Announcement curr = ds.getValue(Announcement.class);
                    arr.add(curr);
                }
                ListView mListView = (ListView) findViewById(R.id.resultsLV);
                MyListAdapter adapter=new MyListAdapter(MainActivity.this,R.layout.pet_list_item,arr);
                mListView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        //Toast.makeText(MainActivity.this,arr.get(0).getLocation(), Toast.LENGTH_SHORT).show();
    }

    public class ViewHolder {
        TextView mPetNameTv;
        TextView mOwnerTv;
        TextView mLocationTv;
        TextView mBountyTv;
        TextView mDateTv;
        ImageView mPetImage;
    }

    private class MyListAdapter extends ArrayAdapter<Announcement> {
        private int layout;

        public MyListAdapter(@NonNull Context context, int resource, @NonNull List<Announcement> objects) {
            super(context, resource, objects);
            layout = resource;
        }


        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            MainActivity.ViewHolder mainViewHolder = null;

            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(layout, parent, false);
                MainActivity.ViewHolder viewHolder = new MainActivity.ViewHolder();

                viewHolder.mPetNameTv = (TextView) convertView.findViewById(R.id.ann_PetNameTv);
                viewHolder.mPetNameTv.setText(getItem(position).getPetName());

                viewHolder.mOwnerTv = (TextView) convertView.findViewById(R.id.ann_OwnerNameTv);
                viewHolder.mOwnerTv.setText(getItem(position).getOwnerName());

                viewHolder.mLocationTv = (TextView) convertView.findViewById(R.id.ann_LastLocTv);
                viewHolder.mLocationTv.setText(getItem(position).getLocation());

                viewHolder.mBountyTv= (TextView) convertView.findViewById(R.id.ann_BountyTv);
                viewHolder.mBountyTv.setText(getItem(position).getBounty());

                viewHolder.mPetImage= (ImageView) convertView.findViewById(R.id.ann_PetIv);


                convertView.setTag(viewHolder);
            } else {
                mainViewHolder = (MainActivity.ViewHolder) convertView.getTag();
                mainViewHolder.mPetNameTv.setText(getItem(position).getPetName());
                mainViewHolder.mOwnerTv.setText(getItem(position).getOwnerName());
                mainViewHolder.mLocationTv.setText(getItem(position).getLocation());
                mainViewHolder.mBountyTv.setText(getItem(position).getBounty());
            }

            return convertView;
        }
    }
}
