package org.escoladeltreball.rranguera.test_diversesactivities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    Button btn;
    Button btnBack;
    Intent intentOrigen;
    EditText textEntrat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        setup();
    }


    private void setup() {

        btn = (Button) findViewById(R.id.btn_pag2);

        btn.setOnClickListener( view -> mostraBrowser());



        intentOrigen = getIntent(); //ens dona qui ha creat la pantalla (Activity) actual

        btnBack = (Button) findViewById(R.id.btn_p2_back);

        btnBack.setOnClickListener( view -> tornarPag1());



        textEntrat = (EditText) findViewById(R.id.editText_pag2);

        textEntrat.setText(intentOrigen.getCharSequenceExtra(Intent.EXTRA_COMPONENT_NAME));
    }




    /*
    Implicit intent
    */
    private void mostraBrowser() {
        String web = intentOrigen.getStringExtra(Intent.EXTRA_COMPONENT_NAME);
        Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse(web));
        startActivity(intent2);
    }


    //tornar, amb el botó que hem fet
    private void tornarPag1() {
        Intent localIntent = new Intent();
        localIntent.putExtra(Intent.EXTRA_COMPONENT_NAME, textEntrat.getText().toString());
        setResult(RESULT_OK, localIntent);

        //finish();
        super.finish();
    }



    //tornar, amb el botó Back del telèfon
    @Override
    public void finish() {
/*
        Intent localIntent = new Intent();
        localIntent.putExtra(Intent.EXTRA_COMPONENT_NAME, textEntrat.getText().toString());
        setResult(RESULT_OK, localIntent);

        super.finish();
*/
tornarPag1();
    }




}
