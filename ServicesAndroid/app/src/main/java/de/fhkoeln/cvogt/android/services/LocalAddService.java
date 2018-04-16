package de.fhkoeln.cvogt.android.services;

// Programmierung verteilter und mobiler Anwendungen
// Prof. Dr. Carsten Vogt
// TH Köln, Institut für Nachrichtentechnik
// Stand: 8.1.2016

// Weitere Kommentare und Erklärungen siehe PDF-Datei mit den kommentierten Quellcodeauszügen und die Vorlesungsfolien

// Android-Service: berechnet die Summer zweier int-Werte

import android.app.Service;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.content.Intent;

// Der Service muss in der Manifest-Datei deklariert werden (auf derselben Ebene wie die Activities)

public class LocalAddService extends Service {

    // onCreate() initialisiert den Service

    public void onCreate() {
        super.onCreate();
        Log.v("DEMO","##### Service - onCreate() #####");
    }

    // onDestroy() kann "Aufräumarbeiten" durchführen

    public void onDestroy() {
        super.onDestroy();
    }

    // Die Methode add() definiert den eigentlichen Dienst des Services

    int add(int a, int b) {

        Log.v("DEMO","##### Service - add("+a+","+b+") #####");
        Log.v("DEMO","Thread des Service: "+Thread.currentThread().getId());
        return a+b;

    }

    // Binder: Hierüber kann eine andere Komponente, die im selben Prozess läuft,
    // auf den Service zugreifen

    private final IBinder addBinder = new LocalAddServiceBinder();

    public class LocalAddServiceBinder extends Binder {

             // getService() liefert eine Referenz auf den Service,
             // über die dann dessen Dienstmethode(n) aufgerufen werden kann/können.
             
             LocalAddService getService() {
                     Log.v("DEMO","##### Service Binder - getService() #####");
                     return LocalAddService.this; }

     }
     
     // onBind() liefert den Binder des Service zurück,
     // wird als Reaktion auf den bindService()-Aufruf des Service-Nutzers ausgeführt
     
     public IBinder onBind(Intent intent) {
             Log.v("DEMO","##### Service - onBind() #####");
             return addBinder; }

}

