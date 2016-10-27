package com.example.narzoan.ex1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText numInputText = (EditText) findViewById(R.id.input_id);
        final CheckBox foodCheckbox = (CheckBox) findViewById(R.id.checkbox_id);
        final Button orderButton = (Button) findViewById(R.id.button_id);
        final SeekBar seekBar = (SeekBar) findViewById(R.id.seek_id);

        numInputText.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                //seekBar.setProgress(Integer.parseInt(numInputText.getText().toString()));
                if (foodCheckbox.isChecked() && checkEditTextInput(numInputText)){
                    orderButton.setEnabled(true);
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChanged = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                progressChanged = progress;
                //numInputText.setText(progressChanged);
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    public void makeOrder(View view){
        //TODO: validate the inputs before enabing the button
        //check if its positive number and the checkBox are checked
        //orderButton.setEnabled(true);
        Button orderButton = (Button) findViewById(R.id.button_id);
        EditText numInputText = (EditText) findViewById(R.id.input_id);
        CheckBox foodCheckbox = (CheckBox) findViewById(R.id.checkbox_id);

        Toast.makeText(getApplicationContext(),"Order has been made",Toast.LENGTH_SHORT).show();
        orderButton.setEnabled(false);
        numInputText.setText("");
        foodCheckbox.setChecked(false);

    }

    public void onCheckboxClicked(View view){
        CheckBox foodCheckbox = (CheckBox) findViewById(R.id.checkbox_id);
        EditText numInputText = (EditText) findViewById(R.id.input_id);
        Button orderButton = (Button) findViewById(R.id.button_id);

        if (foodCheckbox.isChecked() && checkEditTextInput(numInputText)){
            orderButton.setEnabled(true);
        }
    }

    private boolean checkEditTextInput(EditText et){
        //TODO: validate the input.text value.

        int inputInt = Integer.parseInt(et.getText().toString());
        if (inputInt > 0) {
            return true;
        }
        return false;
    }

}
