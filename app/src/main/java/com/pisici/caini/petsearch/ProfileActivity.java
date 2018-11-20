package com.pisici.caini.petsearch;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
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
                //Dialog add pet
                final Pet new_animal=new Pet();
                AlertDialog.Builder new_pet_dialog = new AlertDialog.Builder(ProfileActivity.this);

                View dialog_view = getLayoutInflater().inflate(R.layout.add_pet_dialog, null);
                EditText mnameEt=dialog_view.findViewById(R.id.pet_nameEt);
                EditText mdateEt=dialog_view.findViewById(R.id.dateEt);
                RadioGroup mspeciesRG=dialog_view.findViewById(R.id.speciesRG);

                final Spinner mraceSpinner=dialog_view.findViewById(R.id.species_spinner);
                mspeciesRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch (checkedId){
                        case R.id.dogRb:
                            spinner_change_dog(mraceSpinner);
                            break;
                        case R.id.catRb:
                            spinner_change_cat(mraceSpinner);
                            break;
                            default:
                                break;
                        }
                    }
                });
                mspeciesRG.check(R.id.dogRb);
                new_pet_dialog.setView(dialog_view);
                final AlertDialog dialog = new_pet_dialog.create();
                dialog.show();
            }
        });
    }
    void spinner_change_dog(Spinner mraceSpinner){
        mraceSpinner.setAdapter(new ArrayAdapter<Dog_breed>(ProfileActivity.this,
                android.R.layout.simple_spinner_item,Dog_breed.values()));

    }
    void spinner_change_cat(Spinner mraceSpinner){
        mraceSpinner.setAdapter(new ArrayAdapter<Cat_breed>(ProfileActivity.this,
                android.R.layout.simple_spinner_item,Cat_breed.values()));

    }

}
