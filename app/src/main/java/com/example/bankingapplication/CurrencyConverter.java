package com.example.bankingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DecimalFormat;

public class CurrencyConverter extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private TextView inputValues;
    private TextView outputValues;

    private Spinner spinnerMain;
    private Spinner spinnerSecond;

    public String currency;
    public String currencyBack;

    private String mainCurrency = "EUR";
    private String secondaryCurrency = "USD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_converter);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        spinnerMain = findViewById(R.id.mainCurrency);
        spinnerSecond = findViewById(R.id.secondCurrency);
        inputValues = findViewById(R.id.valueInput);
        outputValues = findViewById(R.id.valueOutput);
        createSpinners();

        currency = mainCurrency; currencyBack = secondaryCurrency;
    }

    public void addValues(View view) {
        String valueText = inputValues.getText().toString();
        if (valueText.length() != 9) {
            if (view.getId() == R.id.plus1) {
                valueText = valueText + "1";
            } else if (view.getId() == R.id.plus2) {
                valueText = valueText + "2";
            } else if (view.getId() == R.id.plus3) {
                valueText = valueText + "3";
            } else if (view.getId() == R.id.plus4) {
                valueText = valueText + "4";
            } else if (view.getId() == R.id.plus5) {
                valueText = valueText + "5";
            } else if (view.getId() == R.id.plus6) {
                valueText = valueText + "6";
            } else if (view.getId() == R.id.plus7) {
                valueText = valueText + "7";
            } else if (view.getId() == R.id.plus8) {
                valueText = valueText + "8";
            } else if (view.getId() == R.id.plus9) {
                valueText = valueText + "9";
            } else if (view.getId() == R.id.plus0) {
                valueText = valueText + "0";
            }
            inputValues.setText(valueText);
        }

        if (view.getId() == R.id.backspace) {
            if (!valueText.isEmpty()) {
                valueText = removeLastChar(valueText); inputValues.setText(valueText);
            }
        }
        calculateCurrency();
    }

    public void setCurrency(String firstcurrency, String secondcurrency) {
        currency = firstcurrency; currencyBack = secondcurrency;
        //firstCurrency.setText(currency); changeCurrency.setText(currencyBack);
        calculateCurrency();
    }

    public void changeValue(View view) {
        //String currentCurrency = firstCurrency.getText().toString();
        //currency = currencyBack; currencyBack = currentCurrency;
        //firstCurrency.setText(currency); changeCurrency.setText(currencyBack);

        //Switch around currencies in spinners
        ArrayAdapter myAdap = (ArrayAdapter) spinnerMain.getAdapter();

        int spinnerPosition = myAdap.getPosition(secondaryCurrency);
        spinnerMain.setSelection(spinnerPosition);

        int spinnerPosition2 = myAdap.getPosition(mainCurrency);
        spinnerSecond.setSelection(spinnerPosition2);

        // Switch main & second currencies
        String holdCurrency = mainCurrency; mainCurrency = secondaryCurrency; secondaryCurrency = holdCurrency;
        calculateCurrency();
    }

    public void calculateCurrency() {
        String input = inputValues.getText().toString(); // Get input string
        if (!input.isEmpty()) {                          // Check that it isn't empty
            double inputNum = Double.parseDouble(input); // Parse the input to double value so
            double outputNum = 0;                        // we can use it

            // Here we calculate all the different currency convertions
            if (mainCurrency.equals("EUR")) {
                switch (secondaryCurrency) {
                    case "USD":
                        outputNum = inputNum * 1.10;
                        break;
                    case "GBP":
                        outputNum = inputNum * 0.80;
                        break;
                    case "SEK":
                        outputNum = inputNum * 10.57;
                        break;
                    case "RUB":
                        outputNum = inputNum * 61.18;
                        break;
                    case "AUD":
                        outputNum = inputNum * 1.50;
                        break;
                    case "CAD":
                        outputNum = inputNum * 1.34;
                        break;
                    case "HKD":
                        outputNum = inputNum * 7.79;
                        break;
                    default:
                        outputNum = inputNum;
                        break;
                }
            } else if (mainCurrency.equals("USD")) {
                switch (secondaryCurrency) {
                    case "EUR":
                        outputNum = inputNum * 0.95;
                        break;
                    case "GBP":
                        outputNum = inputNum * 0.77;
                        break;
                    case "SEK":
                        outputNum = inputNum * 9.61;
                        break;
                    case "RUB":
                        outputNum = inputNum * 62.66;
                        break;
                    case "AUD":
                        outputNum = inputNum * 1.48;
                        break;
                    case "CAD":
                        outputNum = inputNum * 1.32;
                        break;
                    case "HKD":
                        outputNum = inputNum * 7.77;
                        break;
                    default:
                        outputNum = inputNum;
                        break;
                }
            } else if (mainCurrency.equals("GBP")) {
                switch (secondaryCurrency) {
                    case "EUR":
                        outputNum = inputNum * 1.18;
                        break;
                    case "USD":
                        outputNum = inputNum * 1.3;
                        break;
                    case "SEK":
                        outputNum = inputNum * 12.51;
                        break;
                    case "RUB":
                        outputNum = inputNum * 81.59;
                        break;
                    case "AUD":
                        outputNum = inputNum * 1.93;
                        break;
                    case "CAD":
                        outputNum = inputNum * 1.71;
                        break;
                    case "HKD":
                        outputNum = inputNum * 10.11;
                        break;
                    default:
                        outputNum = inputNum;
                        break;
                }
            } else if (mainCurrency.equals("SEK")) {
                switch (secondaryCurrency) {
                    case "EUR":
                        outputNum = inputNum * 0.095;
                        break;
                    case "USD":
                        outputNum = inputNum * 0.1;
                        break;
                    case "GBP":
                        outputNum = inputNum * 0.080;
                        break;
                    case "RUB":
                        outputNum = inputNum * 6.35;
                        break;
                    case "AUD":
                        outputNum = inputNum * 0.15;
                        break;
                    case "CAD":
                        outputNum = inputNum * 0.14;
                        break;
                    case "HKD":
                        outputNum = inputNum * 0.81;
                        break;
                    default:
                        outputNum = inputNum;
                        break;
                }
            } else if (mainCurrency.equals("RUB")) {
                switch (secondaryCurrency) {
                    case "EUR":
                        outputNum = inputNum * 0.014;
                        break;
                    case "GBP":
                        outputNum = inputNum * 0.012;
                        break;
                    case "SEK":
                        outputNum = inputNum * 0.15;
                        break;
                    case "USD":
                        outputNum = inputNum * 0.016;
                        break;
                    case "AUD":
                        outputNum = inputNum * 0.024;
                        break;
                    case "CAD":
                        outputNum = inputNum * 0.021;
                        break;
                    case "HKD":
                        outputNum = inputNum * 0.12;
                        break;
                    default:
                        outputNum = inputNum;
                        break;
                }
            } else if (mainCurrency.equals("AUD")) {
                switch (secondaryCurrency) {
                    case "EUR":
                        outputNum = inputNum * 0.61;
                        break;
                    case "GBP":
                        outputNum = inputNum * 0.52;
                        break;
                    case "SEK":
                        outputNum = inputNum * 6.48;
                        break;
                    case "RUB":
                        outputNum = inputNum * 42.33;
                        break;
                    case "USD":
                        outputNum = inputNum * 0.67;
                        break;
                    case "CAD":
                        outputNum = inputNum * 0.89;
                        break;
                    case "HKD":
                        outputNum = inputNum * 5.25;
                        break;
                    default:
                        outputNum = inputNum;
                        break;
                }
            } else if (mainCurrency.equals("CAD")) {
                switch (secondaryCurrency) {
                    case "EUR":
                        outputNum = inputNum * 0.69;
                        break;
                    case "GBP":
                        outputNum = inputNum * 0.58;
                        break;
                    case "SEK":
                        outputNum = inputNum * 7.29;
                        break;
                    case "RUB":
                        outputNum = inputNum * 47.61;
                        break;
                    case "AUD":
                        outputNum = inputNum * 1.12;
                        break;
                    case "USD":
                        outputNum = inputNum * 0.76;
                        break;
                    case "HKD":
                        outputNum = inputNum * 5.90;
                        break;
                    default:
                        outputNum = inputNum;
                        break;
                }
            } else if (mainCurrency.equals("HKD")) {
                switch (secondaryCurrency) {
                    case "EUR":
                        outputNum = inputNum * 0.12;
                        break;
                    case "GBP":
                        outputNum = inputNum * 0.099;
                        break;
                    case "SEK":
                        outputNum = inputNum * 1.24;
                        break;
                    case "RUB":
                        outputNum = inputNum * 8.07;
                        break;
                    case "AUD":
                        outputNum = inputNum * 0.19;
                        break;
                    case "CAD":
                        outputNum = inputNum * 0.17;
                        break;
                    case "USD":
                        outputNum = inputNum * 0.13;
                        break;
                    default:
                        outputNum = inputNum;
                        break;
                }
            }

            //Formatting the outputvalue so it looks like ex 12,96
            DecimalFormat df = new DecimalFormat("#.#####");

            //Send output value to screen
            outputValues.setText(df.format(outputNum));
        } else {
            //Send empty value to screen
            String outputValue = ""; outputValues.setText(outputValue);
        }
    }

    public void createSpinners() {
        //Create adapters and populate spinners with currencies
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.currencies, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMain.setAdapter(adapter);
        spinnerMain.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.currencies, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSecond.setAdapter(adapter2);
        spinnerSecond.setOnItemSelectedListener(this);

        //Set second currency to USD
        ArrayAdapter myAdap = (ArrayAdapter) spinnerSecond.getAdapter();
        int spinnerPosition = myAdap.getPosition(secondaryCurrency);
        spinnerSecond.setSelection(spinnerPosition);
    }

    // Here we get main & secondary currencies from the two spinners
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id ){
        Spinner spinnerMain = (Spinner)parent;
        Spinner spinnerSecond = (Spinner)parent;

        // Here it checks if we changed the value from mainCurrency spinner and
        // assigns the selected value as main currency
        if(spinnerMain.getId() == R.id.mainCurrency) {
            String selectedItemText = (String) parent.getItemAtPosition(position);
            mainCurrency = selectedItemText;
        }
        if(spinnerSecond.getId() == R.id.secondCurrency) {
            String selectedItemText = (String) parent.getItemAtPosition(position);
            secondaryCurrency = selectedItemText;
        }
        calculateCurrency();
    }

    public void onNothingSelected(AdapterView<?> parent){

    }

    private String removeLastChar(String str) {
        return str.substring(0, str.length() - 1);
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
