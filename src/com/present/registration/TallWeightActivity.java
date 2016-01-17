package com.present.registration;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;
import com.cotroller.Controller;
import foodControl.com.R;

/**
 * Created by Nick on 11.12.2015.
 */
public class TallWeightActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weight_tall_activity);


        //Number pickers settings

        NumberPicker tallPicker = (NumberPicker) findViewById(R.id.tallPicker);
        tallPicker.setMinValue(50);
        tallPicker.setMaxValue(240);
        tallPicker.setValue(Controller.getInstance().getTall() > 0
                ? Controller.getInstance().getTall() : 170);

        NumberPicker weightPicker = (NumberPicker) findViewById(R.id.weightPicker);
        weightPicker.setMinValue(1);
        weightPicker.setMaxValue(400);
        weightPicker.setValue(Controller.getInstance().getWeight() > 0
                ? Controller.getInstance().getWeight() : 60);

        //Buttons click processing
        findViewById(R.id.continueButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TallWeightActivity.this.continueButtonClick();
            }
        });
        findViewById(R.id.backButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TallWeightActivity.this.backButtonClick();
            }
        });

    }

    protected void continueButtonClick() {
        short tall = Short.parseShort(findViewById(R.id.tallPicker).toString());
        float weight = Float.parseFloat(findViewById(R.id.weightPicker).toString());

        Controller.getInstance().setTall(tall);
        Controller.getInstance().setWeight(weight);

        startActivity(new Intent(TallWeightActivity.this, UserDimensionActivity.class));
    }

    protected void backButtonClick() {
        startActivity(new Intent(TallWeightActivity.this, NameAgeActivity.class));
    }
}