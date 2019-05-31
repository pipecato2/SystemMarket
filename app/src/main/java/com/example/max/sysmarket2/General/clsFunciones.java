package com.example.max.sysmarket2.General;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class clsFunciones {
    public void sendEmail(Context context) {
        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
        //Aqui definimos la tipologia de datos del contenido dle Email en este caso text/html
        emailIntent.setType("text/html");
        // Indicamos con un Array de tipo String las direcciones de correo a las cuales enviar
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"fmorales_arenas@hotmail.com"});
        // Aqui definimos un titulo para el Email
        emailIntent.putExtra(android.content.Intent.EXTRA_TITLE, "El Titulo");
        // Aqui definimos un Asunto para el Email
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "El Asunto");
        // Aqui obtenemos la referencia al texto y lo pasamos al Email Intent
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "pteua");
        try {
            //Enviamos el Correo iniciando una nueva Activity con el emailIntent.
            context.startActivity(Intent.createChooser(emailIntent, "Enviar Correo..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(context, "No hay ningun cliente de correo instalado.", Toast.LENGTH_SHORT).show();
        }
    }
}
