package com.example.radiobutton;

import static com.example.radiobutton.R.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    RadioGroup radioGroup;
    Button show ;
    TextView outPut;
    String[] course = {"Android", "Java", "DSA"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        radioGroup =findViewById(R.id.rdgrp);
        outPut = findViewById(R.id.txtView);
        show = findViewById(id.btnShow);
       show.setOnClickListener(new View.OnClickListener() {

           @Override
           public void onClick(View view) {
               int selectedId = radioGroup.getCheckedRadioButtonId();
               RadioButton gender = findViewById(selectedId);
               RadioButton maleRadioButton = findViewById(id.rdMale);
               RadioButton femaleRadioButton = findViewById(id.rdFemal);



               if(gender==maleRadioButton)
               {
                   outPut.setText("M");
               }
               if(gender==femaleRadioButton)
               {
                   outPut.setText("F");
               }


              // ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,course);
             //  sp.setAdapter(adapter);

             //  String s = gender.getText().toString();
              // outPut.setText(s+"");
           }
       });
        Spinner  sp;
        sp = findViewById(id.spnr);
        sp.setOnItemSelectedListener(this);



        ArrayAdapter adapter = new ArrayAdapter(this , android.R.layout.simple_spinner_dropdown_item,course);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);

        RatingBar rating = findViewById(R.id.ratingId);
        TextView textView = findViewById(R.id.ratTxt);
        textView.setText("value is  "+rating.getProgress());
        rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                textView.setText("value is "+v);
            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(getApplicationContext(),course[i],Toast.LENGTH_LONG).show();
        Button spButton = findViewById(id.spButton);
        TextView txt = findViewById(R.id.sptext);
        spButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText(course[i]);
            }
        });



    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}