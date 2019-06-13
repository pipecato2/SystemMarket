package com.example.max.sysmarket2.modelo.conexion;

import android.os.StrictMode;
import android.widget.Toast;

import com.example.max.sysmarket2.vista.LoginActivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConexionBD {


    public Connection conexion (){
        Connection conn = null;
        String error = null;
        try{

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(
                    "jdbc:jtds:sqlserver:sql5003.site4now.net;" +
                            "databaseName=DB_A48BB3_Market;" +
                            "user=DB_A48BB3;" +
                            "password=");

        }catch (Exception e){
            error = e.toString();

        }

        return conn;
    }
}
