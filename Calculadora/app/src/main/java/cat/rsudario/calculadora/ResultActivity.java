package cat.rsudario.calculadora;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class ResultActivity extends Activity {
    int result=0;
    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Bundle data = getIntent().getExtras();
        this.result=data.getInt("result");
        this.tvResult = (TextView) findViewById(R.id.tvResult);
        this.tvResult.setText(String.valueOf(this.result));
    }
}
