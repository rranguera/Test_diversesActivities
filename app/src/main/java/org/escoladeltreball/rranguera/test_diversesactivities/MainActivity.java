package org.escoladeltreball.rranguera.test_diversesactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int CODI_2ND_ACTIVITY_REQUEST = 12345; //qualsevol número

    private Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setup();
    }


    private void setup() {

        btn1 = (Button) findViewById(R.id.btn_pag1);

        btn1.setOnClickListener(v -> switchActivitie());

        //manera alternativa:
/*
        btn1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                //....etc
            }
        });
*/

    }


    /*
        Metodo q crida a SecodActivity
        Intent: asyncronuos messages wich allow application components to request functionality
        from another Android component

         - Implicit: diem QUÈ ha de fer, i Android es busca la vida
         - Explicit: diem exactament què ha de fer
    */
    private void switchActivitie() {
        Intent intent1 = new Intent(this, SecondActivity.class);
        intent1.putExtra(Intent.EXTRA_COMPONENT_NAME, "http://google.es");  //valor que passem a la Activity cridada
        //podriem afegir més putExtra....


        //si l'Activity cridada no ha de retornar res:
        // startActivity(intent1);

        //si l'Activity cridada ha de retornar algo:
        startActivityForResult(intent1, CODI_2ND_ACTIVITY_REQUEST);
    }


    //Cal afegir el mètode onActivityResult, si volem recuperar el resultat que ens enviï la Activity filla
    //Mètode q es crida automaticam quan acaba la sub-Activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CODI_2ND_ACTIVITY_REQUEST){
            if (resultCode == RESULT_OK){
                if (data.hasExtra(Intent.EXTRA_COMPONENT_NAME)){
                    Toast.makeText(this, data.getCharSequenceExtra(Intent.EXTRA_COMPONENT_NAME), Toast.LENGTH_LONG).show();
                }
            }
        }

        //super.onActivityResult(requestCode, resultCode, data);
    }
}
