package com.example.franzcadiente_comp304sec003_lab02_ex01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CustomerInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_info);
        SharedPreferences myPref =
                getSharedPreferences("info", MODE_PRIVATE);

        //payment
        String payment_option = myPref.getString("payment_option","");

        //if paying with cash, remove  card info
        if (payment_option.equals("Cash")){
            EditText card = (EditText)findViewById(R.id.tvCard);
            card.setVisibility(View.INVISIBLE);
            EditText expire = (EditText)findViewById(R.id.tvExpiry);
            expire.setVisibility(View.INVISIBLE);
            EditText CVV = (EditText)findViewById(R.id.tvCVV);
            CVV.setVisibility(View.INVISIBLE);
            TextView labelExpire = (TextView) findViewById(R.id.labelExpire);
            labelExpire.setVisibility(View.INVISIBLE);
            TextView labelCVV = (TextView) findViewById(R.id.labelCVV);
            labelCVV.setVisibility(View.INVISIBLE);
        }
    }

    public void onPurchase(View view){
        boolean valid = true;

        //full name validation
        EditText fullNameText = (EditText) findViewById(R.id.tvName);
        String full_name = fullNameText.getText().toString().trim();
        if (full_name.length() == 0){
            Toast.makeText(this, "Please enter your full name", Toast.LENGTH_SHORT).show();
            valid = false;
        }

        //email validation
        EditText emailText = (EditText) findViewById(R.id.tvEmail);
        String email = emailText.getText().toString().trim();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (email.length() == 0 || !email.matches(emailPattern)){
            Toast.makeText(this, "Invalid Email", Toast.LENGTH_SHORT).show();
            valid = false;
        }

        //phone validation
        EditText phoneText = (EditText) findViewById(R.id.tvPhone);
        String phone = phoneText.getText().toString().trim();
        if (phone.length()!= 10 ){
            Toast.makeText(this, "Invalid Phone Number (Input 10 Digits) ", Toast.LENGTH_SHORT).show();
            valid = false;
        }

        //validating for non-cash payments
        SharedPreferences myPref =
                getSharedPreferences("info", MODE_PRIVATE);
        String chosen_payment = myPref.getString("payment_option","");
        if (!chosen_payment.equals("Cash")){
            //card number validation
            EditText cardText = (EditText) findViewById(R.id.tvCard);
            String card = cardText.getText().toString().trim();
            if (card.length() != 16){
                Toast.makeText(this, "Invalid Card Number (Input 16 Digits)", Toast.LENGTH_SHORT).show();
                valid = false;
            }

            //expiry date validation
            EditText expireText = (EditText) findViewById(R.id.tvExpiry);
            String expire = expireText.getText().toString().trim();
            if (expire.length() != 4){
                Toast.makeText(this, "Invalid Expiry Date", Toast.LENGTH_SHORT).show();
                valid = false;
            }
            //cvv validation
            EditText cvvText = (EditText) findViewById(R.id.tvCVV);
            String cvv = cvvText.getText().toString().trim();
            if (cvv.length() != 3){
                Toast.makeText(this, "Invalid CVV", Toast.LENGTH_SHORT).show();
                valid = false;
            }
        }
        if (valid){
            Toast.makeText(this, "Order Successful", Toast.LENGTH_LONG).show();
        }
    }
}