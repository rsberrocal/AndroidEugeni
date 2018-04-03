package com.richard.tresprogressbar;

import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class PorcentajeCinco extends AsyncTask<Integer, Integer, Integer>  {
    Button btn;
    private ProgressBar progressBar;
    TextView txt;
    int count;

    public PorcentajeCinco(Button btn, ProgressBar progressBar, TextView txt, int count) {
        this.btn = btn;
        this.progressBar = progressBar;
        this.txt = txt;
        this.count = count;
    }

    @Override
    protected Integer doInBackground(Integer... params) {
        //Bucle hasta lo que hemos puesto como parametro
        for (; count < params[0]; count++) {
            try {
                //Cantidad en milisegundos que se detiene el hilo
                Thread.sleep(500);
                //Se actualiza la barra
                publishProgress(count);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return count;
    }

    @Override
    protected void onPostExecute(Integer result) {
        //Una vez acabado actualiza el texto
        txt.setText(result+"%");
    }
    @Override
    protected void onProgressUpdate(Integer... values) {
        //Mientras ejecutas actualiza el estado y el texto
        txt.setText(values[0]+"%");
        progressBar.setProgress(values[0]);
    }

}
