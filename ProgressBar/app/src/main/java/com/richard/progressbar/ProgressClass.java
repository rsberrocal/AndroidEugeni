package com.richard.progressbar;

import android.os.Handler;
import android.widget.ProgressBar;

public class ProgressClass extends Thread {
    int max = 101;
    ProgressHandler h;
    ProgressBar pb;

    ProgressClass(ProgressBar pb){
        this.pb = pb;
    }

    @Override
    public void run() {
        for(int i=0;i<max;i++){
            System.out.println(i);
            this.h = new ProgressHandler(pb);
            try {
                h.handleMessage(h.obtainMessage());
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
