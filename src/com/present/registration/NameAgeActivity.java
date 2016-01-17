package com.present.registration;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import com.cotroller.Controller;
import foodControl.com.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class NameAgeActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    private EditText editTextName;
    private EditText editTextDate;

    Calendar myCalendar = Calendar.getInstance();

    int displayHeight,
            displayWidth;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name_age_activity);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextDate = (EditText) findViewById(R.id.editTextBirthDate);

        //Getting display size in px
//        displayHeight = getResources().getDisplayMetrics().heightPixels;
//        displayWidth = getResources().getDisplayMetrics().widthPixels;
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NameAgeActivity.this.continueButtonClick(view);
            }
        });

        findViewById(R.id.editTextBirthDate).setOnFocusChangeListener(
                new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        NameAgeActivity.this.dateFieldClick(v);
                    }
                }
        );

        editTextDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
               NameAgeActivity.this.dateFieldClick(view);
            }
        });
    }

    /**
     *
     * @param view
     *
     * Create new User via Controller.newUser
     *
     */
    public void dateFieldClick(View view) {
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        new DatePickerDialog(NameAgeActivity.this, date, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    private void updateLabel() {

        String myFormat = "dd/MM/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        editTextDate.setText(sdf.format(myCalendar.getTime()));
    }


    private void continueButtonClick(View view) {

        String name = editTextName.getText().toString();
        Date date = new Date(editTextDate.getText().toString());
        if(!name.isEmpty()) {
            Controller.getInstance().newUser(name, date);
            Intent intent = new Intent(NameAgeActivity.this, TallWeightActivity.class);
            startActivity(intent);
        }
    }


}
