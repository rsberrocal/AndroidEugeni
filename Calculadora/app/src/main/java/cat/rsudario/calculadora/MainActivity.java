package cat.rsudario.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public Button btnOne;
    public Button btnTwo;
    public Button btnThree;
    public Button btnFour;
    public Button btnFive;
    public Button btnSix;
    public Button btnSeven;
    public Button btnEight;
    public Button btnNine;
    public Button btnSum;
    public Button btnMinus;
    public Button btnMult;
    public Button btnDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.btnOne=(Button)findViewById(R.id.btnOne);
        this.btnTwo=(Button)findViewById(R.id.btnTwo);
        this.btnThree=(Button)findViewById(R.id.btnThree);
        this.btnOne=(Button)findViewById(R.id.btnOne);
        this.btnOne=(Button)findViewById(R.id.btnOne);
    }

    public void addOne(View v){

    }
}
