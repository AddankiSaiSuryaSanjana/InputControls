package com.sanjana.inputcontrols;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name, mobile, emailAddress;
    TextView tv;
    RadioButton m, f;
    SeekBar seekBar;
    RatingBar ratingBar;
    CheckBox j, p, c;
    Spinner spinner;
    String gender, language;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.et_username);
        mobile = findViewById(R.id.et_mobilenumber);
        emailAddress = findViewById(R.id.et_mail);
        tv = findViewById(R.id.tv_text);
        m = findViewById(R.id.male);
        f = findViewById(R.id.female);
        seekBar = findViewById(R.id.seek);
        ratingBar = findViewById(R.id.rating);
        spinner = findViewById(R.id.spin);
        j = findViewById(R.id.java);
        p = findViewById(R.id.python);
        c = findViewById(R.id.c);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                String rate = String.valueOf(ratingBar.getRating());
                tv.setText(rate);
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar1, int i, boolean b) {
                String progress = String.valueOf(seekBar1.getProgress());
                tv.setText(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void submitValues(View view) {
        String myname = name.getText().toString();
        String mymobile = mobile.getText().toString();
        String myemail = emailAddress.getText().toString();
        String mybranch = spinner.getSelectedItem().toString();
        if(m.isChecked()) {
            gender = "male";
        }
        else  {
            gender = "female";
        }
        if(j.isChecked()) {
            language = " JAVA";
        }
        if(c.isChecked()) {
            language += "C";
        }
        if(p.isChecked()) {
            language += "PYTHON";
        }
        if(myname.isEmpty() || mymobile.isEmpty() || myemail.isEmpty()) {
            Toast.makeText(this, "Please Fill The Details", Toast.LENGTH_SHORT).show();
        }
        else {
            tv.setText(myname + "\n" + mymobile + "\n" + myemail + "\n" + mybranch + "\n" + gender + "\n" + language);
        }
    }
}