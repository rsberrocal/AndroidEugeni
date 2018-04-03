package com.richard.pelotas;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;

public class GameActivity extends AppCompatActivity {

    private Game game;
    private int difficulty;
    private int FPS = 30;
    private Handler timer;

    private int touch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();

        this.difficulty=extras.getInt("DIFFICULTY");
        this.game=new Game(getApplicationContext(),this.difficulty);
        setContentView(this.game);
        this.timer= new Handler();
        timer.postDelayed(gameThread,2000/FPS);
        this.touch=0;

    }

    private Runnable gameThread = new Runnable() {
        @Override
        public void run() {

            if(game.movimientoBola()){
                fin();
            }else{
                game.invalidate();
                timer.postDelayed(gameThread,1000/FPS);
            }

        }
    } ;

    public void fin(){
        timer.removeCallbacks(gameThread);
        Intent in = new Intent();
        in.putExtra("SCORE",this.touch);
        setResult(RESULT_OK,in);
        finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        if(this.game.toque(x,y)) this.touch++;
        return false;
    }
}
