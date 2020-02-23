package com.example.bankingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bankingapplication.ui.userHome.HomeFragment;

public class UserCreation extends AppCompatActivity {

    public static String userNames;
    public static String userEmail;
    public static String userAddress;
    public static String userCash;
    public static String info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_creation);
        getSupportActionBar().setTitle("New user creation");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void onUserCreation(View view) {
        String err;
        TextView userNamesText = findViewById(R.id.usercreationNames);
        TextView userEmailText = findViewById(R.id.usercreationEmail);
        TextView userAddressText = findViewById(R.id.usercreationAddress);
        TextView userCashText = findViewById(R.id.usercreationCash);

        userNames = userNamesText.getText().toString();
        userEmail = userEmailText.getText().toString();
        userAddress = userAddressText.getText().toString();
        userCash = userCashText.getText().toString();

        if (!userNames.isEmpty()) {
            if (!userEmail.isEmpty()) {
                if (!userAddress.isEmpty()) {
                    if (!userCash.isEmpty()) {
                        info = "" + userNames + " " + userEmail + " " + userAddress + " " + userCash;
                        Intent intent = new Intent(this, LoginActivity.class);
                        startActivity(intent);

                    } else { err = "Please enter your cash amount"; showError(err); }
                } else { err = "Please enter address"; showError(err); }
            } else { err = "Please enter email address"; showError(err); }
        } else { err = "Please enter first & lastname"; showError(err); }
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    private void showError(String error) {
        Toast.makeText(getApplicationContext(), error, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}