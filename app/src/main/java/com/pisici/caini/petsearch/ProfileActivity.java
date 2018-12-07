package com.pisici.caini.petsearch;

import android.content.Intent;
import android.net.Uri;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProfileActivity extends AppCompatActivity {
    TextView mnameTv;
    Button maddpetBtn;
    Uri file;
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
                //Todo: add break condition(max number of pets)
                final Pet new_animal=new Pet();
                AlertDialog.Builder new_pet_dialog = new AlertDialog.Builder(ProfileActivity.this);

                View dialog_view = getLayoutInflater().inflate(R.layout.add_pet_dialog, null);
                final EditText mnameEt=dialog_view.findViewById(R.id.pet_nameEt);
                final EditText mdateEt=dialog_view.findViewById(R.id.pet_dateEt);
                Button mphotoBtn=dialog_view.findViewById(R.id.mpet_photoBtn);
                Button maddPetBtn=dialog_view.findViewById(R.id.dialog_addPetBtn);
                final RadioGroup mspeciesRG=dialog_view.findViewById(R.id.speciesRG);
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

                mphotoBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent i = new Intent(Intent.ACTION_PICK);
                        i.setType("image/*");
                        startActivityForResult(i, 1);

                    }
                });

                maddPetBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Date birthday;
                        SimpleDateFormat date=new SimpleDateFormat("dd/MM/yyyy");
                        try{
                        birthday=date.parse(mdateEt.getText().toString().trim());}
                        catch (java.text.ParseException e){
                            makeToast("birthday is not a valid format");
                            Log.v("log","data nu a fost valida la parse");
                            return;
                        }
                        if(mspeciesRG.getCheckedRadioButtonId()==R.id.dogRb)
                        {   Log.v("log","trimis in add_pet cu dog");
                            add_pet(true,mnameEt.toString().trim(),birthday,
                                    (Dog_breed) mraceSpinner.getSelectedItem(),Cat_breed.Bengal);}
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
    void add_pet(boolean isDog, String name,Date birthday, Dog_breed dog_breed,Cat_breed cat_breed){
            if(name.equals("")|| birthday.equals(""))
            {  makeToast("You should fill in all the fields");
                return;}

            if(!isBirthdayValid(birthday)){
                Log.v("log","nu e valida saracia");
                makeToast("Birthday is not valid");
                return;
            }
            if(isDog==true){
                Pet.Dog doggo=new Pet.Dog(Pet.getNewID(),name,birthday,dog_breed);
            }
            else{
                Pet.Cat cat=new Pet.Cat(Pet.getNewID(),name,birthday,cat_breed);
            }

    }
    boolean isBirthdayValid(Date birthday){

        if(System.currentTimeMillis()>birthday.getTime() && ((System.currentTimeMillis()-birthday.getTime())/1000<630720000))
        {
            Log.v("log","a dat true isbirthdayvalid");
            return true;
        }
        else {
            Log.v("log","a dat false isbirthdayvalid");
            return false;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //pentru cand vine din galerie
        if (requestCode == 1 && resultCode == RESULT_OK) {
            file = data.getData();
            //timerul e doar ca sa se bifeze casuta in fata userului
            //TODO:Rezolva checkbox-ul
            CountDownTimer count = new CountDownTimer(1500, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                }

                @Override
                public void onFinish() {
                  //  checkBox.setChecked(true);
                }
            }.start();

        }
    }
    void makeToast(String x){
        Toast.makeText(ProfileActivity.this,x,Toast.LENGTH_SHORT);
    }

}
