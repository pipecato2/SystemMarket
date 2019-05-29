package com.example.max.sysmarket2.General;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class clsFunciones {
    protected void sendEmail(Context context) {
        String[] TO = {"contacto@seogalicia.es"}; //aquí pon tu correo
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
// Esto podrás modificarlo si quieres, el asunto y el cuerpo del mensaje
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Asunto");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Escribe aquí tu mensaje");

        try {
            context.startActivity(Intent.createChooser(emailIntent, "Enviar email..."));
           // finish();
        } catch (ActivityNotFoundException ex) {

        }
    }
}
