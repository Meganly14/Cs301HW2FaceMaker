package com.example.hw2facemaker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener, SeekBar.OnSeekBarChangeListener, RadioGroup.OnCheckedChangeListener {

    private Face theFace;
    private SeekBar Red;
    private SeekBar Blue;
    private SeekBar Green;
    private Spinner spinner;
    private List<String> hairChoices = new ArrayList<String>();
    //comment

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find XML
        theFace = findViewById(R.id.Face);
        theFace = theFace.getThisFace();
        spinner = findViewById(R.id.spinner);
            //radio
        RadioGroup RadioGroup = findViewById(R.id.RadioGroup);
        RadioButton HairButton = findViewById(R.id.HairButton);
        RadioButton Eyes = findViewById(R.id.EyesButton);
        RadioButton SkinButton = findViewById(R.id.SkinButton);
            //rand
        Button randomFace = findViewById(R.id.randomFace);
            //seekBars//
        Red = findViewById(R.id.Red);
        Blue = findViewById(R.id.Blue);
        Green = findViewById(R.id.Green);


        //spinners
        hairChoices.add("Short hair");
        hairChoices.add("Long hair");
        hairChoices.add("Medium length hair");


        //set all the listeners
        Spinner.setOnItemSelectedListener(this);



        //hair button for seekbars
        HairButton.setChecked(true);
        Red.setProgress((int)theFace.hairColor.red());
        Blue.setProgress((int)theFace.hairColor.blue());
        Green.setProgress((int)theFace.hairColor.green());


        //spinner adapter
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, hairChoices);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spinner
        Spinner.setAdapter(spinnerAdapter);
        Spinner.setSelection(theFace.hairStyle);


    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.randomFace){
            theFace.randomize();
            if (theFace.hairChecked){
                Red.setProgress((int) theFace.hairColor.red());
                Blue.setProgress((int) theFace.hairColor.blue());
                Red.setProgress((int) theFace.hairColor.green());
            }
            else if (theFace.eyesChecked){
                Red.setProgress((int) theFace.eyeColor.red());
                Blue.setProgress((int) theFace.eyeColor.blue());
                Red.setProgress((int) theFace.eyeColor.green());
            }
            else if (theFace.skinChecked){
                Red.setProgress((int) theFace.skinColor.red());
                Blue.setProgress((int) theFace.skinColor.blue());
                Red.setProgress((int) theFace.skinColor.green());

            }
            hairSpinner.setSelection(theFace.hairStyle);
            theFace.invalidate();

        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        theFace.hairStyle = position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //default
        theFace.hairStyle = 0;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}