package com.example.pantalla_animada;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class menuMacia extends AppCompatActivity {


    public void PlayGameClick(View v) {
        String mesage=" You ordered PlayGame";
        displayToast(mesage);
    }

    public void ViewScoreClick(View v) {
        String mesage=" You ordered ViewScore";
        displayToast(mesage);
    }
    public void SettingsClick(View v) {
        String mesage=" You ordered Settings";
        displayToast(mesage);
    }
    public void HelpClick(View v) {
        String mesage=" You ordered Help";
        displayToast(mesage);
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_macia);
    }
}
