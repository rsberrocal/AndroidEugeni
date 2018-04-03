package com.richard.tresprogressbar;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {
    Button btn;
    private ProgressBar progressBar1;
    private ProgressBar progressBar2;
    private ProgressBar progressBar3;
    TextView txt1;
    TextView txt2;
    TextView txt3;
    Integer count =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Asignamos las barras
        progressBar1 = (ProgressBar) findViewById(R.id.pb2);
        progressBar1.setMax(100);
        progressBar2 = (ProgressBar) findViewById(R.id.pb5);
        progressBar2.setMax(100);
        progressBar3 = (ProgressBar) findViewById(R.id.pb10);
        progressBar3.setMax(100);
        //Boton para arrancar
        btn = (Button) findViewById(R.id.btn2);
        //Textos para los porcentajes
        txt1 = (TextView) findViewById(R.id.tx2);
        txt2 = (TextView) findViewById(R.id.tx5);
        txt3 = (TextView) findViewById(R.id.tx10);
    }

    //Funcion para el boton
    public void barraDos(View v){
        //Contador inicial
        count =1;
        //Hacemos visible las barra
        progressBar1.setVisibility(View.VISIBLE);
        progressBar2.setVisibility(View.VISIBLE);
        progressBar3.setVisibility(View.VISIBLE);
        //Iniciamos el progreso al 0
        progressBar1.setProgress(0);
        progressBar2.setProgress(0);
        progressBar3.setProgress(0);
        //Creamos las clases AsyncTask con los dos parametros, el primero para que se ejecuten al mismo tiempo y el otro para el maximo
        new PorcentajeDos((Button)v,progressBar1,txt1,count).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,100);
        new PorcentajeCinco((Button)v,progressBar2,txt2,count).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,100);
        new PorcentajeDiez((Button)v,progressBar3,txt3,count).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,100);
    }
}
