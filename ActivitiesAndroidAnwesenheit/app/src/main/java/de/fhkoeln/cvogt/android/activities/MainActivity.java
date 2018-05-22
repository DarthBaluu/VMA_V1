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

public class MainActivity extends Activity {
        
    /* onCreate() wird bei der Erzeugung der Activity ausgeführt. */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);  // Android Doku: "Derived classes must call through to the super class's implementation of this method. If they do not, an exception will be thrown."
        setContentView(R.layout.activity_main);  // zeigt Layout auf dem Display an
        setTitle(R.string.activity1_title);  // setzt den Titel der Activity (kann alternativ durch ein Attribut in der Manifest-Datei geschehen)

        // final Button switchButton1_2 = (Button) findViewById(R.id.switchActivity1_2);
        final Button switchButton1_3 = (Button) findViewById(R.id.switchActivity1_3);

        //switchButton1_2.setOnClickListener(new SwitchButtonListener1_2());
        switchButton1_3.setOnClickListener(new SwitchButtonListener1_3());

        
        Toast.makeText(this,"Activity 1: onCreate()", Toast.LENGTH_LONG).show(); // Kontrollausgabe durch "Toast" (Popup). [Parameter 'this' bezieht sich auf die Activity]
        
        Log.v("DEMO","---> Activity1: onCreate() <--- "); // Kontrollausgabe im LogCat
    }
    
    public void onStart() {
        super.onStart();
        Log.v("DEMO","---> Activity1: onStart() <--- ");
    }        

    public void onResume() {
        super.onResume();
        Log.v("DEMO","---> Activity1: onResume() <--- ");
    }        

    public void onPause() {
        super.onPause();
        Log.v("DEMO","---> Activity1: onPause() <--- ");
    }        

    public void onStop() {
        super.onStop();
        Log.v("DEMO","---> Activity1: onStop() <--- ");
    }        

    public void onDestroy() {
        super.onDestroy();
        Log.v("DEMO","---> Activity1: onDestroy() <--- ");
    }


    public void onClick1_2(View v) {
        View v =
        Log.v("DEMO","---> Activity1: Click on Button <--- ");
        Intent myIntent = new Intent(v.getContext(), SecondActivity.class); // Durch Übergabe dieses Intent-Objekts an startActivity():

        myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        v.getContext().startActivity(myIntent);                             // Erzeugung und Aktivierung einer neuen Instanz der Klasse SecondActivity


        Log.v("DEMO","onClick1_2 works!");
    }

}

/*
class SwitchButtonListener1_2 implements OnClickListener  {   // Listener des Buttons

    public void onClick(View v) {
        Log.v("DEMO","---> Activity1: Click on Button <--- ");
        Intent myIntent = new Intent(v.getContext(), SecondActivity.class); // Durch Übergabe dieses Intent-Objekts an startActivity():

        myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        v.getContext().startActivity(myIntent);                             // Erzeugung und Aktivierung einer neuen Instanz der Klasse SecondActivity
    }

}
*/


class SwitchButtonListener1_3 implements OnClickListener  {   // Listener des Buttons

    public void onClick(View v) {
        Log.v("DEMO","---> Activity1: Click on Button <--- ");
        Intent myIntent = new Intent(v.getContext(), ThirdActivity.class); // Durch Übergabe dieses Intent-Objekts an startActivity():

        myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        v.getContext().startActivity(myIntent);                             // Erzeugung und Aktivierung einer neuen Instanz der Klasse SecondActivity
    }

}







