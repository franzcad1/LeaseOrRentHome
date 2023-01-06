package com.example.franzcadiente_comp304sec003_lab02_ex01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Checkout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
    }

    public void onPurchase(View view){
        Intent intent1 = new Intent(this, PaymentOptions.class);
        startActivity(intent1);
    }
}