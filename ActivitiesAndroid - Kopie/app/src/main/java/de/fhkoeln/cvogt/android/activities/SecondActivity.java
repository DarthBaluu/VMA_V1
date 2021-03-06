package de.fhkoeln.cvogt.android.activities;

// Programmierung verteilter und mobiler Anwendungen
// Prof. Dr. Carsten Vogt
// TH Köln, Institut für Nachrichtentechnik
// Stand: 4.12.2015

// Weitere Kommentare siehe PDF-Datei mit den kommentierten Quellcodeauszügen

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

/* Diese zweite Aktivität muss ggf. per Hand im Manifest eingetragen werden.
   Sie wird dort automatisch eingetragen, wenn im Project-Unterfenster auf 'java'
   rechts-klickt und dann den Menus "New > Activity > ..." folgt. */

public class SecondActivity extends Activity {
        
    public void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        
        final Button switchButton2_1 = (Button) findViewById(R.id.switchActivity2_1);
        final Button switchButton2_3 = (Button) findViewById(R.id.switchActivity2_3);

        switchButton2_1.setOnClickListener(new SwitchButtonListener2_1());
        switchButton2_3.setOnClickListener(new SwitchButtonListener2_3());

        Toast.makeText(this,"Activity 2: onCreate()", Toast.LENGTH_LONG).show();
        
        Log.v("DEMO","      ---> Activity2: onCreate() <--- ");
 
    }

    public void onStart() {
        super.onStart();
        Log.v("DEMO","      ---> Activity2: onStart() <--- ");
    }        

    public void onResume() {
        super.onResume();
        Log.v("DEMO","      ---> Activity2: onResume() <--- ");
    }        

    public void onPause() {
        super.onPause();
        Log.v("DEMO","      ---> Activity2: onPause() <--- ");
    }        

    public void onStop() {
        super.onStop();
        Log.v("DEMO","      ---> Activity2: onStop() <--- ");
    }        

    public void onDestroy() {
        super.onDestroy();
        Log.v("DEMO","      ---> Activity2: onDestroy() <--- ");
    }       

}

class SwitchButtonListener2_1 implements OnClickListener  {   // Listener des Buttons

        public void onClick(View v) {
        Log.v("DEMO","      ---> Activity2: Click on Button <--- ");
        Intent myIntent = new Intent(v.getContext(),MainActivity.class); // Durch Übergabe dieses Intent-Objekts an startActivity():

        myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        v.getContext().startActivity(myIntent);                          // Erzeugung und Aktivierung einer neuen Instanz der Klasse MainActivity
        }

}

class SwitchButtonListener2_3 implements OnClickListener  {   // Listener des Buttons

    public void onClick(View v) {
        Log.v("DEMO","      ---> Activity2: Click on Button <--- ");
        Intent myIntent = new Intent(v.getContext(),ThirdActivity.class); // Durch Übergabe dieses Intent-Objekts an startActivity():

        myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        v.getContext().startActivity(myIntent);                          // Erzeugung und Aktivierung einer neuen Instanz der Klasse MainActivity
    }

}