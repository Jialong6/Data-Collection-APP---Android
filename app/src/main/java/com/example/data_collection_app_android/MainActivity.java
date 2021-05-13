package com.example.data_collection_app_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Camera;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<String> disease_adap;
    Spinner disease_sp;

    private Button goCamera_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        if(null == savedInstanceState) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, CameraActivity.newInstance()).commit();
        }
        */

        //******camera btn**********
        goCamera_btn = findViewById(R.id.goCamera_btn);

        goCamera_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, CameraActivity.class);
                startActivity(i);
            }
        });


        //*****crop*******
        TextView crop_tv = findViewById(R.id.crop_tv);
        Spinner crop_sp = (Spinner) findViewById(R.id.crop_sp);

        ArrayAdapter<String> crop_adap = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.crop_arr));
        crop_adap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        crop_sp.setAdapter(crop_adap);

        //******disease*******
        TextView disease_tv = findViewById(R.id.disease_tv);
        disease_sp = (Spinner) findViewById(R.id.disease_sp);

        crop_sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (i == 0){
                    disease_adap = new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.dis_cassava_arr));
                }
                else if (i == 1){
                    disease_adap = new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.dis_potato_arr));
                }
                else if (i == 2){
                    disease_adap = new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.dis_sweet_potato_arr));
                }
                else if (i == 3){
                    disease_adap = new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.dis_maize_arr));
                }

                //disease_adap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                disease_sp.setAdapter(disease_adap);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
}