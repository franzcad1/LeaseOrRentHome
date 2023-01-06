package com.example.franzcadiente_comp304sec003_lab02_ex01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;


public class Apartment extends AppCompatActivity {
    private CheckBox cbApt1, cbApt2;
    boolean hasItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartment);

        //initialize parameters
        cbApt1=findViewById(R.id.cbApt1);
        cbApt2=findViewById(R.id.cbApt2);
        hasItem = false;
    }

    public void onCheckout(View view){
        Intent intent1 = new Intent(this, Checkout.class);

        //if cart has no item, do not enter checkout screen
        if (hasItem == false)
        {
            Toast.makeText(this, "Cannot checkout empty cart",Toast.LENGTH_SHORT).show();
        }
        else
            startActivity(intent1);
    }

    public void onAdd(View view){
        //atleast one item should be checked before it can be added to the cart
        if (cbApt1.isChecked() == false && cbApt2 .isChecked() == false )
        {
            Toast.makeText(this, "No item selected",Toast.LENGTH_SHORT).show();
            hasItem = false;
        }
        else {

            //store which items have been checked and add them to the cart
            SharedPreferences myPreference =
                    getSharedPreferences("info", 0);

            SharedPreferences.Editor prefEditor = myPreference.edit();

            boolean apt1check = cbApt1.isChecked();
            boolean apt2check = cbApt2.isChecked();
            prefEditor.putBoolean("apt1check", apt1check);
            prefEditor.putBoolean("apt2check", apt2check);
            prefEditor.commit();
            Toast.makeText(this, "Added to cart!", Toast.LENGTH_SHORT).show();
            hasItem = true;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.apartment:
                Intent intent1 = new Intent(this, Apartment.class);
                startActivity(intent1);
                break;

            case R.id.detachedhome:
                Intent intent2 = new Intent(this, DetachedHome.class);
                startActivity(intent2);
                break;

            case R.id.semidetached:
                Intent intent3 = new Intent(this, SemiDetached.class);
                startActivity(intent3);
                break;

            case R.id.condo:
                Intent intent4 = new Intent(this, Condominium.class);
                startActivity(intent4);
                break;
            case R.id.townhouse:
                Intent intent5 = new Intent(this, TownHouse.class);
                startActivity(intent5);
                break;
            default:
                return super.onOptionsItemSelected(item);

        }
        return true;

    }
}