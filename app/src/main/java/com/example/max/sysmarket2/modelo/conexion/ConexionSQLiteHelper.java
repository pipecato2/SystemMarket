package com.example.max.sysmarket2.modelo.conexion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Esta clase tendra los metodos necesarios para la conexion con la base de datos SQLite ademas de los metodos
 * para crear las tablas y actualizarlas si corresponnde.
 *
 * @Autor Maximiliano Pinto
 * Version: 31-05-2019/V1.0
 */

public class ConexionSQLiteHelper extends SQLiteOpenHelper {


    public ConexionSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(ConsultasSQLite.CREAR_TABLA_COMUNA);
        db.execSQL(ConsultasSQLite.CREAR_TABLA_CATEGORIA);
        db.execSQL(ConsultasSQLite.CREAR_TABLA_LOCAL);
        db.execSQL(ConsultasSQLite.CREAR_TABLA_PERFIL);
        db.execSQL(ConsultasSQLite.CREAR_TABLA_PRODUCTO);
        db.execSQL(ConsultasSQLite.CREAR_TABLA_REGION);
        db.execSQL(ConsultasSQLite.CREAR_TABLA_USUARIO);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS categoria");
        db.execSQL("DROP TABLE IF EXISTS comuna");
        db.execSQL("DROP TABLE IF EXISTS local");
        db.execSQL("DROP TABLE IF EXISTS perfil");
        db.execSQL("DROP TABLE IF EXISTS producto");
        db.execSQL("DROP TABLE IF EXISTS usuario");
        onCreate(db);

    }


}
