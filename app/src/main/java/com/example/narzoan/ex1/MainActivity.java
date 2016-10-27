package com.example.narzoan.ex1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void makeOrder(View view){
        //TODO: validate the inputs before enabing the button
        //check if its positive number and the checkBox are checked
        //orderButton.setEnabled(true);
        Button orderButton = (Button) findViewById(R.id.button_id);
        CheckBox foodCheckbox = (CheckBox) findViewById(R.id.checkbox_id);
        EditText numInputText = (EditText) findViewById(R.id.input_id);

        int inputInt = Integer.parseInt(numInputText.getText().toString());
        if (inputInt > 0){

            Toast.makeText(getApplicationContext(),"Order has been made",Toast.LENGTH_SHORT).show();
        }
    }
}
