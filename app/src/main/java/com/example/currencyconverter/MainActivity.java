package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button button;
    EditText editText;
    TextView tvanswer;
    Spinner spinner;
    int index=0;
    String[] options = {"euro","dollar","dinnar"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);
        tvanswer = findViewById(R.id.tvanswer);
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,options);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getinputString = editText.getText().toString();
                double getInputInt = Double.parseDouble(getinputString);
                if(index == 0){
                    double ans = getInputInt/90;
                    String answerString = Double.toString(ans);
                    tvanswer.setText(answerString);
                }
                else if(index == 1){
                    double ans = getInputInt/70;
                    String answerString = Double.toString(ans);
                    tvanswer.setText(answerString);
                }
                else{
                    double ans = getInputInt/18;
                    String answerString = Double.toString(ans);
                    tvanswer.setText(answerString);
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        index = position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}