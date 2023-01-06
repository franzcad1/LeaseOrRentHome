package com.example.franzcadiente_comp304sec003_lab02_ex01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class Condominium extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_condominium);
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