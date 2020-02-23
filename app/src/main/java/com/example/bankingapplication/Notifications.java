package com.example.bankingapplication;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Notifications extends AppCompatActivity {

    private Button btn;
    private CheckBox sounds;
    private CheckBox transReceived;
    private CheckBox transSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notifications_activity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Set variables with their ids
        btn = (Button) findViewById(R.id.getNotificationsButton);
        sounds = (CheckBox) findViewById(R.id.soundCheck);
        transReceived = findViewById(R.id.receivedtransactionCheck);
        transSend = findViewById(R.id.sendtransactionCheck);

        // Set checkboxes disabled on start
        sounds.setEnabled(false);
        transReceived.setEnabled(false);
        transSend.setEnabled(false);
    }

    public void getNotifications(View view) {
        String buttonText = btn.getText().toString();

        if (buttonText == "No") {
            String text = "Now you won't get notifications";
            Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
            btn.setText("Yes");
            sounds.setEnabled(false);
            transReceived.setEnabled(false);
            transSend.setEnabled(false);
        } else {
            if (view.getId() == R.id.getNotificationsButton) {
                String text = "Now you get notifications";
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
                btn.setText("No");
                sounds.setEnabled(true);
                transReceived.setEnabled(true);
                transSend.setEnabled(true);
            }
        }
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