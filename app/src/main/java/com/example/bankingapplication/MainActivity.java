package com.example.bankingapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_login, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

    public void onClickLogin(View view) {
        TextView loginText = findViewById(R.id.usernameInput);
        TextView passwordText = findViewById(R.id.passwordInput);
        String login = loginText.getText().toString();
        String pswd = passwordText.getText().toString();
        if (!login.isEmpty()) {
            String text = "Welcome back " + login + "!";
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
        } else {
            String text = "Please enter login info.";
            Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
        }
    }

    public void onClickCreateAccount(View view) {
        Intent intent = new Intent(this, UserCreation.class);
        startActivity(intent);
    }

    public void onClickStocks(View view) {
        String text = "Stocks";
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
    }

    public void onClickTrusts(View view) {
        String text = "Trusts";
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
    }

    public void onClickNotification(View view) {
        Intent intent = new Intent(this, Notifications.class);
        startActivity(intent);
    }

    public void onClickBanks(View view) {
        Intent intent = new Intent(this, BankLocations.class);
        startActivity(intent);
    }

    public void onClickCurrency(View view) {
        Intent intent = new Intent(this, CurrencyConverter.class);
        startActivity(intent);
    }
}
