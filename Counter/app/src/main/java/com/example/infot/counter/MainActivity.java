package com.example.infot.counter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public EditText countNum;
    //public CheckBox chBox;
    public int num = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addNum(View v){
        this.countNum = (EditText)findViewById(R.id.txCount);
        this.num++;
        System.out.println("qwmekq");
        this.countNum.setText(String.valueOf(this.num));
    }
    public void removeNum(View v){
        //this.chBox=(CheckBox)findViewById(R.id.cbMin);
        this.countNum = (EditText)findViewById(R.id.txCount);
        //if(this.chBox.isChecked()&&this.num <= 0){

        //}else{
            this.num--;
            this.countNum.setText(String.valueOf(this.num));
        //}
    }
    public void resetNum(View v){
        this.countNum = (EditText)findViewById(R.id.txCount);
        this.num=0;
        this.countNum.setText(String.valueOf(this.num));
    }

}
