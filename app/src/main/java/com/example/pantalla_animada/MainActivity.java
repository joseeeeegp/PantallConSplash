package com.example.pantalla_animada;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "tag";
    private static final String LAST_LAUNCH = "lasLaunch" ;
    private ImageView icono;
    private ObjectAnimator animatorRotation;
    private AnimatorSet animatorSet;
    private long animationDuration = 3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Lo de Macià para que se coja la hora de la última vez que se abrió la app
        SharedPreferences lastTime = getSharedPreferences(LAST_LAUNCH, MODE_PRIVATE);
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
        if (lastTime.contains("dateTime") == true) {

            String dateTime = lastTime.getString("dateTime", "Default");
            Log.i(TAG, "CONTROL DE INCIIO DE SESIÓN La última vez que se abrio fue  " + dateTime);
        }
        SharedPreferences.Editor dateEditor = lastTime.edit();

        dateEditor.putString("dateTime",format.format(now)); dateEditor.commit();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Lo mio para pintar la fecha actual
        Calendar calendarNow = new GregorianCalendar(TimeZone.getTimeZone("Europe/Madrid"));
        int day =calendarNow.get(Calendar.DAY_OF_MONTH);
        int month = calendarNow.get(Calendar.MONTH);
        int year = calendarNow.get(Calendar.YEAR);
        int hora= calendarNow.get(Calendar.HOUR_OF_DAY);
        int minutos = calendarNow.get(Calendar.MINUTE);
        Log.i(TAG, "CONTROL DE INCIIO DE SESIÓN Se ha abierto ahora a las "+ day + "/"+month+"/"+ year+ " a las "+ hora+":" +minutos);


        //Inicio de la animación del splash
        animatorSet = new AnimatorSet();
        icono = findViewById(R.id.idimagenTrivial);
        animacion();
        handler();



    }


    public void activarDespuesSplash() {
        //startActivity(new Intent(this, DespuesSplash.class));
        //startActivity(new Intent(this, TrasSplash.class));
        startActivity(new Intent(this, menuMacia.class));
    }


    public void animacion(){
        animatorRotation = ObjectAnimator.ofFloat(icono, "rotation", 720f);
        animatorRotation.setDuration(animationDuration);
        AnimatorSet animatorSetRotator = new AnimatorSet();
        animatorSetRotator.playTogether(animatorRotation);
        animatorSetRotator.start();
    }


    public void handler(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                activarDespuesSplash();
            }
        }, animationDuration);
    }
}
