package cat.rsudario.calculadora;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public TextView txRes;
    public TextView txPower;
    public CheckBox cbPower;
    public int firstNum=0;
    public int secondNum=0;
    public boolean firstOp=false;
    public boolean stillOp=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.txRes=(TextView)findViewById(R.id.txResultat);
        this.txPower=(TextView)findViewById(R.id.txPower);
        this.cbPower=(CheckBox)findViewById(R.id.cbPower);
        this.cbPower.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(cbPower.isChecked()){
                    txPower.setText("On");
                    txPower.setTextColor(Color.rgb(5, 173, 64));
                }else{
                    txPower.setText("Off");
                    txPower.setTextColor(Color.rgb(206, 57, 16));
                    txRes.setText("");
                    firstOp=false;
                    stillOp=true;
                }

            }
        });

    }

    public void addNum(View v){
        Button btn = (Button)v;
        if(this.cbPower.isChecked()){
            if(!this.stillOp){
                this.firstNum=Integer.parseInt(this.txRes.getText().toString());
                this.txRes.setText(btn.getText().toString());
                this.stillOp=true;
            }else{
                this.txRes.setText(this.txRes.getText().toString()+btn.getText().toString());
            }
        }
    }

    public void pushResultPage(View v){
        Intent intentNewPage = new Intent(this,ResultActivity.class);
        intentNewPage.putExtra("result",this.firstNum+this.secondNum);
        startActivity(intentNewPage);
    }

    public void sum(View v){
        if(this.cbPower.isChecked()){
            if(!this.firstOp){
                this.firstNum=Integer.parseInt(this.txRes.getText().toString());
                this.txRes.setText("");
                this.firstOp=true;
            }else{
                this.secondNum=Integer.parseInt(this.txRes.getText().toString());
                this.txRes.setText(String.valueOf(this.firstNum+this.secondNum));
                this.firstNum=this.secondNum;
                this.stillOp=false;
            }
        }
    }

    public void min(View v){
        if(this.cbPower.isChecked()) {
            if(!this.firstOp){
                this.firstNum=Integer.parseInt(this.txRes.getText().toString());
                this.txRes.setText("");
                this.firstOp=true;
            }else{
                this.secondNum=Integer.parseInt(this.txRes.getText().toString());
                this.txRes.setText(String.valueOf(this.firstNum-this.secondNum));
                this.firstNum=this.secondNum;
                this.stillOp=false;
            }
        }
    }

    public void mult(View v){
        if(this.cbPower.isChecked()) {
            if (!this.firstOp) {
                this.firstNum = Integer.parseInt(this.txRes.getText().toString());
                this.txRes.setText("");
                this.firstOp = true;
            } else {
                this.secondNum = Integer.parseInt(this.txRes.getText().toString());
                this.txRes.setText(String.valueOf(this.firstNum * this.secondNum));
                this.firstNum = this.secondNum;
                this.stillOp = false;
            }
        }
    }

    public void div(View v){
        if(this.cbPower.isChecked()) {
            if (!this.firstOp) {
                this.firstNum = Integer.parseInt(this.txRes.getText().toString());
                this.txRes.setText("");
                this.firstOp = true;
            } else {
                this.secondNum = Integer.parseInt(this.txRes.getText().toString());
                this.txRes.setText(String.valueOf(this.firstNum / this.secondNum));
                this.firstNum = this.secondNum;
                this.stillOp = false;
            }
        }
    }

}
