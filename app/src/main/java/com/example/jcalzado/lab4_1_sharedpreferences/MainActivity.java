package com.example.jcalzado.lab4_1_sharedpreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etJugador;
    private TextView tvUltima;
    private SharedPreferences puntos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etJugador = (EditText) findViewById(R.id.etJugador);
        tvUltima = (TextView) findViewById(R.id.tvUltima);

        // Obtenemos los datos de la última partida.
        ultimaPartida();
    }

    /**
     * Método que lanza la pantalla de juego a la que le pasa el nombre del jugador.
     * Además, controla que se introduzca un nombre de jugador.
     */
    public void lanzaJugar (View view) {
        if (etJugador.getText().toString().length() == 0) {
            Toast.makeText(this, "Inserte un nombre para jugar!", Toast.LENGTH_SHORT).show();
        } else {
            Intent i = new Intent(this, Jugar.class);
            i.putExtra("nombreJugador", etJugador.getText().toString());
            startActivity(i);
        }
    }

    /**
     * Método para obtener del XML de SharedPreferences los datos de la última partida.
     */
    public void ultimaPartida () {
        puntos = getSharedPreferences("Puntuaciones", Context.MODE_PRIVATE);
        String ultimoJugador = puntos.getString("jugador","Sin jugador");
        int ultimaPuntuacion = puntos.getInt("puntos",0);
        tvUltima.setText(ultimoJugador + " (" + ultimaPuntuacion + " puntos)");
    }
}
