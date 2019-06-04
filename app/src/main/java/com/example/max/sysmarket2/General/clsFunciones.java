package com.example.max.sysmarket2.General;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class clsFunciones {
    public void sendEmail(Context context) {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("systemmarket2", "taller2019");
                    }
                });
            try {

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("pipecato2@gmail.com"));
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse("fmorales_arenas@hotmail.com"));
                message.setSubject("prueba");
                message.setText("correp de cprueba");

                Transport.send(message);

            } catch (MessagingException e) {
                Log.d("MailJob", e.getMessage());
            }

    }

    public  ProgressDialog CargarDatos(String cargar,Context context)
    {
        ProgressDialog progressDialog;
        progressDialog=new ProgressDialog(context);
        progressDialog.setMessage("" + cargar);
        progressDialog.setCancelable(true);
        progressDialog.setCanceledOnTouchOutside(true);
        progressDialog.show();

        return progressDialog;
    }
}
