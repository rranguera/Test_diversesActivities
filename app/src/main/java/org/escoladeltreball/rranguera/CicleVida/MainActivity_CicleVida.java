package org.escoladeltreball.rranguera.CicleVida;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.escoladeltreball.rranguera.test_diversesactivities.R;

public class MainActivity_CicleVida extends AppCompatActivity {

    public static final String LOG = "RR_MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__cicle_vida);

        Log.d(LOG, "onCreate()");

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG, "onStart()");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG, "onDestroy()");
    }
}
