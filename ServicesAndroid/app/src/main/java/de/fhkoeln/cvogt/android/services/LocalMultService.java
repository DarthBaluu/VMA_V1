package de.fhkoeln.cvogt.android.services;

// Programmierung verteilter und mobiler Anwendungen
// Prof. Dr. Carsten Vogt
// TH Köln, Institut für Nachrichtentechnik
// Stand: 8.1.2016

// Weitere Kommentare und Erklärungen siehe PDF-Datei mit den kommentierten Quellcodeauszügen und die Vorlesungsfolien

// Android-Service: berechnet die Summer zweier int-Werte

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

// Der Service muss in der Manifest-Datei deklariert werden (auf derselben Ebene wie die Activities)

public class LocalMultService extends Service {

    // onCreate() initialisiert den Service

    public void onCreate() {
        super.onCreate();
        Log.v("DEMO","##### Service2 - onCreate() #####");
    }

    // onDestroy() kann "Aufräumarbeiten" durchführen

    public void onDestroy() {
        super.onDestroy();
    }

    // Die Methode add() definiert den eigentlichen Dienst des Services

    int mult(int a, int b) {

        Log.v("DEMO","##### Service2 - mult("+a+","+b+") #####");
        Log.v("DEMO","Thread des Service2: "+Thread.currentThread().getId());
        return a*b;

    }

    // Binder: Hierüber kann eine andere Komponente, die im selben Prozess läuft,
    // auf den Service zugreifen

    private final IBinder multBinder = new LocalMultServiceBinder();

    public class LocalMultServiceBinder extends Binder {

             // getService() liefert eine Referenz auf den Service,
             // über die dann dessen Dienstmethode(n) aufgerufen werden kann/können.
             
             LocalMultService getService() {
                     Log.v("DEMO","##### Service2 Binder - getService() #####");
                     return LocalMultService.this; }

     }
     
     // onBind() liefert den Binder des Service zurück,
     // wird als Reaktion auf den bindService()-Aufruf des Service-Nutzers ausgeführt
     
     public IBinder onBind(Intent intent) {
             Log.v("DEMO","##### Service2 - onBind() #####");
             return multBinder; }

}

