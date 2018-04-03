package com.richard.progressbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {


    ProgressBar pb_main;
    Button btn_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.btn_start = (Button) findViewById(R.id.btn_start);
        this.pb_main = (ProgressBar) findViewById(R.id.pb_main);
    }

    public void startProgress(View v){
        ProgressClass pc = new ProgressClass(this.pb_main);
        pc.start();
    }


}
