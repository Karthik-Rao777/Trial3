package com.e.login;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class WeightActivity extends AppCompatActivity {
    EditText height , waist;
    TextView calculated_result;
    Button risk_button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);
        height=(EditText)findViewById(R.id.height);
        waist=(EditText)findViewById(R.id.weight);
        calculated_result=(TextView)findViewById(R.id.result);
        risk_button=(Button)findViewById(R.id.risk_analysis);
        risk_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WeightActivity.this,RiskAnalysis.class);
                startActivity(intent);
            }
        });
    }

    public void  calculateRFM(View view)
    {
        String strHeight=height.getText().toString();
        String strWaist=waist.getText().toString(); //here strWaist=strWeight

        float intHeight=Float.parseFloat(strHeight)/100;
        float intWaist=Float.parseFloat(strWaist);
//            float ratioHW=intHeight/intWaist;
//            float mul=20*ratioHW;
//            float bmi=(64-mul);
        float bmi=intWaist/(intHeight*intHeight);
        Toast.makeText(this, "bmi="+bmi, Toast.LENGTH_SHORT).show();
        displayBMI(bmi);

    }
    private void displayBMI(float bmi) {
        String bmiLabel = "";

        if (Float.compare(bmi, 15f) <= 0) {
            bmiLabel = getString(R.string.very_severely_underweight);
        } else if (Float.compare(bmi, 15f) > 0  &&  Float.compare(bmi, 16f) <= 0) {
            bmiLabel = getString(R.string.severely_underweight);
        } else if (Float.compare(bmi, 16f) > 0  &&  Float.compare(bmi, 18.5f) <= 0) {
            bmiLabel = getString(R.string.underweight);
        } else if (Float.compare(bmi, 18.5f) > 0  &&  Float.compare(bmi, 25f) <= 0) {
            bmiLabel = getString(R.string.normal);
        } else if (Float.compare(bmi, 25f) > 0  &&  Float.compare(bmi, 30f) <= 0) {
            bmiLabel = getString(R.string.overweight);
        } else if (Float.compare(bmi, 30f) > 0  &&  Float.compare(bmi, 35f) <= 0) {
            bmiLabel = getString(R.string.obese_class_i);
        } else if (Float.compare(bmi, 35f) > 0  &&  Float.compare(bmi, 40f) <= 0) {
            bmiLabel = getString(R.string.obese_class_ii);
        } else {
            bmiLabel = getString(R.string.obese_class_iii);
        }
        calculated_result.setVisibility(View.VISIBLE);
        risk_button.setVisibility(View.VISIBLE);
        bmiLabel = "BMI = "+bmi + "\nResult = " + bmiLabel+"\n\nBMI Categories:\n" +
                "        Underweight   = <18.5\n" +
                "        Normal weight = 18.5–24.9\n" +
                "        Overweight    = 25–29.9\n" +
                "        Obesity       = BMI of 30 or greater";
        calculated_result.setText(bmiLabel);

    }
}

