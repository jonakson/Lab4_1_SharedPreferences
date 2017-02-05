package com.example.jcalzado.lab4_1_sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Jugar extends AppCompatActivity {

    private int numeroAleatorio, puntuacion;
    private TextView tvSaludo, tvMensaje;
    private EditText etNumero;
    private String nombreJugador;
    private SharedPreferences puntos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugar);

        // Enlace de los elementos de la interfaz gráfica e inicializaciones.
        numeroAleatorio = (int) (Math.random()*10+1);
        puntuacion = 0;
        tvSaludo = (TextView) findViewById(R.id.tvSaludo);
        tvMensaje = (TextView) findViewById(R.id.tvMensaje);
        etNumero = (EditText) findViewById(R.id.etNumero);

        // Obtención de nombre de jugador del MainActivity.
        Bundle b = getIntent().getExtras();
        nombreJugador = b.getString("nombreJugador");
        tvSaludo.setText("Hola " + nombreJugador + ". Debes acertar el número del 1 al 10 que he elegido. ¿Listo para Jugar?");

        // Creamos las SharedPreferences
        puntos = getSharedPreferences("Puntuaciones", Context.MODE_PRIVATE);
    }

    /**
     * Método que se ejecuta con el botón de comprobación del número por parte del usuario.
     */
    public void heAcertado (View view) {
        // Comprobamos que el campo de número no ha quedado vacío.
        if (etNumero.getText().toString().length() == 0) {
            Toast.makeText(this, "Introduzca un número para comprobar si ha acertado.", Toast.LENGTH_SHORT).show();
        } else {
            int numeroJugador = Integer.parseInt(etNumero.getText().toString());
            // Se produce el acierto. Haremos la puntuación sobre 10.
            if (numeroJugador == numeroAleatorio) {
                tvMensaje.setText("¡Enhorabuena, has acertado! Puntuación: " + String.valueOf(10 - puntuacion) + "/10.");
                crearPuntuacion(nombreJugador, 10 - puntuacion); // Llamamos a un método que mete los datos en el XML.
                // Se produce el fallo.
            } else {
                puntuacion++;
                tvMensaje.setText("Ha fallado. Vuelva a intentarlo.");
                crearPuntuacion(nombreJugador, 10 - puntuacion);
            }
        }
    }

    /**
     * Método para meter el nombre de jugador y su puntuación en el archivo XML de SharedPreferences.
     * @param jugador Nombre del jugador.
     * @param puntuacion Puntuación del jugador.
     */
    private void crearPuntuacion(String jugador, int puntuacion) {
        SharedPreferences.Editor editorPuntuacion = puntos.edit();
        editorPuntuacion.putString("jugador", jugador);
        editorPuntuacion.putInt("puntos", puntuacion);
        editorPuntuacion.commit();
    }

    /**
     * Método para generar un nuevo número aleatorio.
     */
    public void nuevoNumero (View view) {
        numeroAleatorio = (int) (Math.random()*10+1);
        Toast.makeText(this, "Se ha generado un nuevo número.", Toast.LENGTH_SHORT).show();
    }
}
