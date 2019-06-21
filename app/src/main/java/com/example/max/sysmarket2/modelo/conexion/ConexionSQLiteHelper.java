package com.example.max.sysmarket2.modelo.conexion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.max.sysmarket2.modelo.vo.ProductoVO;

/**
 * Esta clase tendra los metodos necesarios para la conexion con la base de datos SQLite ademas de los metodos
 * para crear las tablas y actualizarlas si corresponnde.
 *
 * @Autor Maximiliano Pinto
 * Version: 31-05-2019/V1.0
 */

public class ConexionSQLiteHelper extends SQLiteOpenHelper {


    /**
     * El metodo se utiliza para instanciar una nueva conexion a SQlite
     * @param context // Recibe el parametro para saber en que conecto o activity se esta utilizando
     * @param name    // Recibe por nombre de la base de datos
     * @param factory //
     * @param version // Recibe como parametro la version de la base de datos
     */

    public ConexionSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * Realiza la creacion de las tablas y campos al momento de instalar la aplicacion
     * @param db // El parametro recibe la basase de datos SQLite
     */

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE categoria (\n" +
                "    id_Categoria INTEGER PRIMARY KEY,\n" +
                "    nombre_Cat VARCHAR(150) NOT NULL\n" +
                ");");
        db.execSQL("CREATE TABLE comuna (\n" +
                "    id_Comuna INTEGER PRIMARY KEY,\n" +
                "    nombre_Com VARCHAR(150)\n" +
                ");");
        db.execSQL("CREATE TABLE perfil(\n" +
                "    id_Perfil INTEGER PRIMARY KEY,\n" +
                "    rut_Per VARCHAR(10) NOT NULL,\n" +
                "    nombre_Per VARCHAR(100)\n" +
                ");");
        db.execSQL("CREATE TABLE region(\n" +
                "    id_Region INTEGER PRIMARY KEY,\n" +
                "    nombre_Reg VARCHAR(150) \n" +
                ");");
        db.execSQL("CREATE TABLE local(\n" +
                "    id_Local INTEGER(4) PRIMARY KEY,\n" +
                "    nombre_Loc VARCHAR(150) NOT NULL,\n" +
                "    direccion_Loc VARCHAR(200) NOT NULL,\n" +
                "    geo_CoorDX VARCHAR(50) ,\n" +
                "    geo_CoorDY VARCHAR(50) ,\n" +
                "    id_Region INTEGER NOT NULL,\n" +
                "    id_Comuna INTEGER NOT NULL,\n" +
                "    CONSTRAINT fk_local_comuna FOREIGN KEY (id_Comuna) REFERENCES comuna(id_Comuna),\n" +
                "    CONSTRAINT local_region FOREIGN KEY (id_Region) REFERENCES region(id_Region)\n" +
                ");");

        db.execSQL("CREATE TABLE usuario(\n" +
                "    usuario VARCHAR(15) PRIMARY KEY,\n" +
                "    id_Perfil INTEGER NOT NULL,\n" +
                "    nom_Usu VARCHAR(100) NOT NULL,\n" +
                "    ape_Usu VARCHAR(100) NOT NULL,\n" +
                "    rut_Usu VARCHAR(10) NOT NULL,\n" +
                "    fecha_Nac VARCHAR(10) ,\n" +
                "    email VARCHAR(100) ,\n" +
                "    clave VARCHAR(10) NOT NULL,\n" +
                "    activo BOOLEAN NOT NULL,\n" +
                "    CONSTRAINT fk_usuario_perfil FOREIGN KEY (id_Perfil) REFERENCES perfil(id_Perfil)\n" +
                ");");
        db.execSQL("CREATE TABLE producto(\n" +
                "    codigo_Barra INTEGER(50) NOT NULL,\n" +
                "    id_Local INTEGER ,\n" +
                "    id_Usuario VARCHAR(15) ,\n" +
                "    id_Categoria INTEGER ,\n" +
                "    nombre_Prod VARCHAR(200) ,\n" +
                "    precio_Prod INTEGER ,\n" +
                "    cantidad_Prod INTEGER ,\n" +
                "    total_Prod INTEGER ,\n" +
                "    CONSTRAINT fk_producto_categoria FOREIGN KEY (id_Categoria) REFERENCES categoria(id_Categoria),\n" +
                "    CONSTRAINT fk_producto_local FOREIGN KEY (id_Local) REFERENCES local(id_Local),\n" +
                "    CONSTRAINT fk_producto_usuario FOREIGN KEY (id_Usuario) REFERENCES usuario(usuario)\n" +
                ");");
        db.execSQL("CREATE TABLE carro(\n" +
                "    id_Carro_C INTEGER(30) NOT NULL,\n" +
                "    codigo_Barra_C VARCHAR(100),\n" +
                "    nombre_Prod VARCHAR(50),\n" +
                "    precio_Prod_C INTEGER,\n" +
                "    cantidad_Prod_C INTEGER,\n" +
                "    total_Prod_C INTEGER,\n" +
                "    CONSTRAINT fk_carro_producto FOREIGN KEY (codigo_Barra_C) REFERENCES producto(codigo_Barra)\n" +
                ");");

        db.execSQL("INSERT INTO producto (codigo_Barra,id_Local,id_Usuario,id_Categoria,nombre_Prod,precio_Prod,cantidad_Prod,total_Prod) VALUES (78018853,1,1,1,'CIGARRO',2000,1,2000) ");

    }

    /**
     * Realiza la actializacion de las tablas en la base de datos en caso de existir algun cambio en las tablas o campos
     * @param db // Recibe como parametro la base de datos SQlite
     * @param oldVersion // Recibe como parametro la antigua version
     * @param newVersion // Recibe como parametro la nueva version
     */

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS categoria");
        db.execSQL("DROP TABLE IF EXISTS comuna");
        db.execSQL("DROP TABLE IF EXISTS local");
        db.execSQL("DROP TABLE IF EXISTS perfil");
        db.execSQL("DROP TABLE IF EXISTS producto");
        db.execSQL("DROP TABLE IF EXISTS usuario");
        db.execSQL("DROP TABLE IF EXISTS carro");
        onCreate(db);

    }

    /**
     * El metodo realiza el select en SQLite de todos los campos de la tabla producto,
     * este retorna cursor el cual tiene los campos de la consulta
     * @return cursor
     */

    public Cursor alldataProd() {

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM producto", null);

        return cursor;
    }

    /**
     * El metodo se encarga de realizar la insercion de un nuveo producto en SQlite.
     * @param producto Recibe el objeto de tipo ProductoVO para la insercion del producto
     * @return resul retorna el resultado de la insercion
     */

    public long ingresoProducto(ProductoVO producto) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues valor = new ContentValues();
        valor.put("codigo_Barra", producto.getCod_barra());
        valor.put("id_Local", producto.getId_Local());
        valor.put("id_Usuario", producto.getId_Usuario());
        valor.put("id_Categoria", producto.getId_Categoria());
        valor.put("nombre_Prod", producto.getNom_Prod());
        valor.put("precio_Prod", producto.getPrecio());
        valor.put("cantidad_Prod", producto.getCantidad());
        valor.put("total_Prod", producto.getTotal());
        long resul = db.insert("producto", null, valor);
        return resul;
    }





}
