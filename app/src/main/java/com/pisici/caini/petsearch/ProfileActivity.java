package com.pisici.caini.petsearch;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    TextView mnameTv;
    Button maddpetBtn;

        @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mnameTv=(TextView) findViewById(R.id.nameTV);
        maddpetBtn=(Button) findViewById(R.id.addpetBtn);
        maddpetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder new_pet_dialog = new AlertDialog.Builder(ProfileActivity.this);
                View dialog_view = getLayoutInflater().inflate(R.layout.add_pet_dialog, null);
                EditText mnameEt=dialog_view.findViewById(R.id.NameEt);
                Switch mspeciesSwitch=dialog_view.findViewById(R.id.Species_Switch);
                Spinner mraceSpinner=dialog_view.findViewById(R.id.species_spinner);
                new_pet_dialog.setView(dialog_view);
                final AlertDialog dialog = new_pet_dialog.create();
                dialog.show();
            }
        });
    }
}
