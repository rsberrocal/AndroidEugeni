package com.richard.progressbar;

import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;

public class ProgressHandler extends Handler {
    ProgressBar pb;

    ProgressHandler(ProgressBar pb){
        this.pb=pb;
    }

    @Override
    public void handleMessage(Message msg){
        pb.incrementProgressBy(5);
    }

}
