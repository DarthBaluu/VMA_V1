package de.fhkoeln.cvogt.android.activities;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ThirdActivity extends Activity {


    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        final Button switchButton3_1 = (Button) findViewById(R.id.switchActivity3_1);
        final Button switchButton3_2 = (Button) findViewById(R.id.switchActivity3_2);

        switchButton3_1.setOnClickListener(new SwitchButtonListener3_1());
        switchButton3_2.setOnClickListener(new SwitchButtonListener3_2());

        Toast.makeText(this,"Activity 3: onCreate()", Toast.LENGTH_LONG).show();

        Log.v("DEMO","      ---> Activity3: onCreate() <--- ");

    }

    public void onStart() {
        super.onStart();
        Log.v("DEMO","      ---> Activity3: onStart() <--- ");
    }

    public void onResume() {
        super.onResume();
        Log.v("DEMO","      ---> Activity3: onResume() <--- ");
    }

    public void onPause() {
        super.onPause();
        Log.v("DEMO","      ---> Activity3: onPause() <--- ");
    }

    public void onStop() {
        super.onStop();
        Log.v("DEMO","      ---> Activity3: onStop() <--- ");
    }

    public void onDestroy() {
        super.onDestroy();
        Log.v("DEMO","      ---> Activity3: onDestroy() <--- ");
    }

}

class SwitchButtonListener3_1 implements View.OnClickListener {   // Listener des Buttons

    public void onClick(View v) {
        Log.v("DEMO","      ---> Activity3: Click on Button <--- ");
        Intent myIntent = new Intent(v.getContext(),MainActivity.class); // Durch Übergabe dieses Intent-Objekts an startActivity():

        myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        v.getContext().startActivity(myIntent);                          // Erzeugung und Aktivierung einer neuen Instanz der Klasse MainActivity
    }

}

class SwitchButtonListener3_2 implements View.OnClickListener {   // Listener des Buttons

    public void onClick(View v) {
        Log.v("DEMO","      ---> Activity3: Click on Button <--- ");
        Intent myIntent = new Intent(v.getContext(),SecondActivity.class); // Durch Übergabe dieses Intent-Objekts an startActivity():

        myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        v.getContext().startActivity(myIntent);                          // Erzeugung und Aktivierung einer neuen Instanz der Klasse MainActivity
    }


}
