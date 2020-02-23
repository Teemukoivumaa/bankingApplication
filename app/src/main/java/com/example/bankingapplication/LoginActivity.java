package com.example.bankingapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_investments, R.id.navigation_login_settings)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

    public void onClickAllCardsAccounts(View view) {
        Intent intent = new Intent(this, AllCardsAccounts.class);
        startActivity(intent);
    }

    public void onClickAccountInfo(View view) {
        Button firstAccount = findViewById(R.id.allAccountsCards);
        Intent intent = new Intent(this, AccountInfo.class);
        startActivity(intent);
    }

    public void onClickCardInfo(View view) {
        Intent intent = new Intent(this, CardInfo.class);
        startActivity(intent);
    }

}
