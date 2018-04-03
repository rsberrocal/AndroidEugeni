package com.examen.richard.examen_richard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    static double DolarToEuro = 0.83;
    static double DolarToLibra = 0.74;
    static double EuroToDolar = 1.20;
    static double EuroToLibra = 0.89;
    static double LibraToDolar = 1.35;
    static double LibraToEuro = 1.12;

    EditText etDolar;
    EditText etEuro;
    EditText etLibra;
    EditText etCount;

    CheckBox cbEuro;
    CheckBox cbDolar;
    CheckBox cbLibra;
    CheckBox cbPower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.etDolar = (EditText) findViewById(R.id.etDolar);
        this.etEuro = (EditText) findViewById(R.id.etEuro);
        this.etLibra = (EditText) findViewById(R.id.etLliura);
        this.etCount = (EditText) findViewById(R.id.etCount);
        this.cbDolar = (CheckBox) findViewById(R.id.cbDolar);
        this.cbEuro = (CheckBox) findViewById(R.id.cbEuro);
        this.cbLibra = (CheckBox) findViewById(R.id.cbLliura);
        this.cbPower = (CheckBox) findViewById(R.id.power);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        this.etDolar.setText(savedInstanceState.getString("DOLAR"));
        this.etEuro.setText(savedInstanceState.getString("EURO"));
        this.etLibra.setText(savedInstanceState.getString("LIBRA"));
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putDouble("DOLAR", Double.parseDouble(this.etDolar.getText().toString()));
        outState.putDouble("EURO", Double.parseDouble(this.etEuro.getText().toString()));
        outState.putDouble("LIBRA", Double.parseDouble(this.etLibra.getText().toString()));

        super.onSaveInstanceState(outState);
    }

    public void Calcula(View v) {
        if (!this.cbPower.isChecked()) {
            double dolar = 0, euro = 0, libra = 0;
            if (this.etDolar.hasFocus()) {
                dolar = Double.parseDouble(this.etDolar.getText().toString());
                euro = dolar * DolarToEuro;
                libra = dolar * DolarToLibra;
            } else if (this.etEuro.hasFocus()) {
                euro = Double.parseDouble(this.etEuro.getText().toString());
                dolar = euro * EuroToDolar;
                libra = euro * EuroToLibra;
            } else if (this.etLibra.hasFocus()) {
                libra = Double.parseDouble(this.etLibra.getText().toString());
                dolar = libra * LibraToDolar;
                euro = libra * LibraToEuro;
            }

            int count = Integer.parseInt(this.etCount.getText().toString()) + 1;
            this.etCount.setText(String.valueOf(count));
            if (this.cbDolar.isChecked()) {
                this.etDolar.setText(String.valueOf(dolar));
            }
            if (this.cbEuro.isChecked()) {
                this.etEuro.setText(String.valueOf(euro));
            }
            if (this.cbLibra.isChecked()) {
                this.etLibra.setText(String.valueOf(libra));
            }
        }
    }

    public void Reset(View v) {
        this.etDolar.setText("0");
        this.etEuro.setText("0");
        this.etLibra.setText("0");
    }

    public void Info(View v) {
        Intent intentNewPage = new Intent(this, InfoActivity.class);
        startActivity(intentNewPage);
    }

}

