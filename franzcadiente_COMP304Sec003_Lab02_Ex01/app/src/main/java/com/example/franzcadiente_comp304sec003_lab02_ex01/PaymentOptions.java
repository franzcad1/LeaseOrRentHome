package com.example.franzcadiente_comp304sec003_lab02_ex01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class PaymentOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_options);
    }

    public void onPurchase(View view){
        RadioGroup radioGroup = findViewById(R.id.rgOptions);
        int selectedId = radioGroup.getCheckedRadioButtonId();

        if (selectedId ==-1) // if nothing is selected
        {
            Toast.makeText(this, "Please select a mode of payment: ", Toast.LENGTH_SHORT).show();

        }
        else{
            RadioButton radioButton = (RadioButton) findViewById(selectedId);
            String paymentOption = (String) radioButton.getText();

            SharedPreferences myPreference =
                    getSharedPreferences("info", 0);
            SharedPreferences.Editor prefEditor = myPreference.edit();
            prefEditor.putString("payment_option", paymentOption);
            prefEditor.commit();

            Intent intent1 = new Intent(this, CustomerInfo.class);
            startActivity(intent1);
        }
    }
}
