package com.richard.pelotas;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    int record;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ayuda(View V){
        Intent ayudaPage = new Intent(this,AyudaActivity.class);

        startActivity(ayudaPage);
    }

    public void dificultad(View v){
        Button df = (Button) v;
        int dif=1;
        if(df.getText().equals(getString(R.string.medio))){
            dif = 2;
        }
        if(df.getText().equals(getString(R.string.dificil))){
            dif = 3;
        }

        Intent i = new Intent(this,GameActivity.class);

        i.putExtra("DIFFICULTY",dif);

        //startActivity(i);

        startActivityForResult(i,1);
    }

    protected void onActivityResult(int peticion,int codigo, Intent i){

        if(peticion!=1||codigo!=RESULT_OK)return;

        int score = i.getIntExtra("SCORE",0);

        if(score>record){
            record=score;
            saveRecord();
            TextView txScore = (TextView) findViewById(R.id.txScore);
            txScore.setText(String.valueOf(score));
        }else{
            String scoreString = ""+score;
            Toast t = Toast.makeText(this,scoreString,Toast.LENGTH_SHORT);
            t.setGravity(Gravity.BOTTOM,0,0);
            t.show();
        }


    }

    public void onResume(){
        super.onResume();
        checkRecord();
    }

    public void checkRecord(){
        SharedPreferences sha = PreferenceManager.getDefaultSharedPreferences(this);
        record = sha.getInt("RECORD",0);
        TextView txScore = (TextView) findViewById(R.id.txScore);
        txScore.setText(String.valueOf(record));
    }

    public void saveRecord(){
        SharedPreferences sha = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor ed =  sha.edit();
        ed.putInt("RECORD",record);
        ed.apply();
    }


}
