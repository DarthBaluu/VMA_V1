package de.fhkoeln.cvogt.android.services;

// Programmierung verteilter und mobiler Anwendungen
// Prof. Dr. Carsten Vogt
// TH Köln, Institut für Nachrichtentechnik
// Stand: 8.1.2016

// Weitere Kommentare und Erklärungen siehe PDF-Datei mit den kommentierten Quellcodeauszügen und die Vorlesungsfolien

import android.app.Activity;
import android.os.*;
import android.content.*;
import android.util.Log;
import android.view.View;
import android.widget.*;

public class MainActivity extends Activity {

     private LocalAddService myService;  // Service, der aufgerufen werden soll
     private LocalAddService.LocalAddServiceBinder myBinder;  // Binder des Service
     private ConnectionToAddService myConn;  // Überwacher der Verbindung zum Service

     public void onCreate(Bundle savedInstanceState) {
             super.onCreate(savedInstanceState);
             Log.v("DEMO","Thread der Activity: "+Thread.currentThread().getId());
             setContentView(R.layout.activity_main);
             setTitle(R.string.activity_title);
             Button callServiceButton = (Button) findViewById(R.id.callservice);  // Click auf den Button öffnet Verbindung zum Service und ruft seinen Dienst auf
             callServiceButton.setOnClickListener(new ButtonListener());
     }

     public void onPause() {
             super.onPause();
             Intent intent = new Intent(getApplicationContext(),LocalAddService.class);
             stopService(intent);  // Stoppt den Service, wenn die Activity nicht mehr im Vordergrund liegt
     }

     // Listener des Buttons: stellt Verbindung zum Service her

     class ButtonListener implements View.OnClickListener {

        public void onClick(View v) {

            myConn = new ConnectionToAddService();
            Intent intent = new Intent(getApplicationContext(),LocalAddService.class);
            // Bindung zum Service herstellen (und dabei Service starten, falls nötig).
            // Der Parameter 'myConn' referenziert ein Objekt, das dann die hergestellte Verbindung überwacht
            // und Callback-Methoden bereitstellt, die bei Zustandsänderungen ausgeführt werden.
            // Als Folge des bindService()-Aufrufs wird die callback-Methode myConn.onServiceConnected() (siehe unten) ausgeführt.
            bindService(intent,myConn,Context.BIND_AUTO_CREATE);

        }

     }

     // Ein Objekt der Klasse ConnectionToAddService überwacht eine Verbindung zum Service.
     // Seine Callback-Methode onServiceConnected() wird ausgeführt unmittelbar nachdem die Verbindung hergestellt wurde.
     // In diesem Programm ruft sie die Dienst-Methode add() des Servers direkt auf.

     class ConnectionToAddService implements ServiceConnection {
             
             // onServiceConnected(): Callback-Methode - wird automatisch aufgerufen, wenn die Verbindung zum Service hergestellt ist.
             // Erhält ein IBinder-Objekt als Parameter, über das auf den Service mit seinem angebotenen Dienst zugegriffen werden kann.
             
             public void onServiceConnected(ComponentName className, IBinder binder) {
                     
                     Log.v("DEMO","##### Activity - onServiceConnected(): starting #####");
                     
                     // über den Binder eine Referenz auf den Service beschaffen:
                     myBinder = (LocalAddService.LocalAddServiceBinder) binder;
                     myService = myBinder.getService();
                     
                     // Werte für den Service-Aufruf beschaffen:
                     EditText feldInput1 = (EditText)findViewById(R.id.operand1),
                              feldInput2 = (EditText)findViewById(R.id.operand2),
                     feldOutput = (EditText)findViewById(R.id.result);
                     int op1 = Integer.parseInt(feldInput1.getText().toString());
                     int op2 = Integer.parseInt(feldInput2.getText().toString());

                     // Service aufrufen:
                     Log.v("DEMO","##### Activity - onServiceConnected(): calling myService.add() #####");
                     int result = myService.add(op1, op2);

                     // Resultat ausgeben:
                     feldOutput.setText(""+result);
             }
             
             public void onServiceDisconnected(ComponentName className) {}

     } // Ende von 'ConnectionToAddService'
     
}

