package com.example.max.sysmarket2.modelo.conexion;

public class ConsultasSQLite {

    /**
     * Esta clase tendra los metodos necesarios para la creacion de tablas en SQLite,
     * definiendo parametros contrantes para sus posibles usos en el futuro
     *
     *
     * @Autor Maximiliano Pinto
     * Version: 31-05-2019/V1.0
     * @param TABLA_nombre_de_tabla
     * @return Retorna el mombre de la tabla de la base de datos SQLite.
     *
     * @param CAMPO_nombre_de_campo
     * @return Retorna el nombre del campo correspondiente.
     *
     */



    //Tabla categoria
    public static final String TABLA_CATEGORIA = "categoria";
    public static final String CAMPO_ID_CATEGORIA_C = "id_Categoria";
    public static final String CAMPO_NOMBRE_CAT = "nombre_Cat";

    //Tabla Comuna
    public static final String TABLA_COMUNA = "comuna";
    public static final String CAMPO_ID_COMUNA_C = "id_Comuna";
    public static final String CAMPO_NOMBRE_COM = "nombre_Com";

    //Tabla Perfil

    public static final String TABLA_PERFIL = "perfil";
    public static final String CAMPO_ID_PERFIL_P = "id_Peril";
    public static final String CAMPO_RUT_PER = "rut_Per";
    public static final String CAMPO_NOMBRE_PER = "nombre_Per";

    //Tabla Region
    public static final String TABLA_REGION = "region";
    public static final String CAMPO_ID_REGION_R = "id_Region";
    public static final String CAMPO_NOM_REG = "nombre_Reg";

    //Tabla Local
    public static final String TABLA_LOCAL = "local";
    public static final String CAMPO_ID_LOCAL_L = "id_Local";
    public static final String CAMPO_NOMBRE_LOC = "nombre_Loc";
    public static final String CAMPO_DIRECCION_LOC = "direccion_Loc";
    public static final String CAMPO_GEO_COORDX = "geo_CoorDX";
    public static final String CAMPO_GEO_COORDY = "geo_CoorDY";
    public static final String CAMPO_ID_REGION_L = "id_Region";
    public static final String CAMPO_ID_COMUNA_L = "id_Comuna";

    //Tabla Usuario
    public static final String TABLA_USUARIO = "usuario";
    public static final String CAMPO_USUARIO = "usuario";
    public static final String CAMPO_ID_PERFIL_U = "id_Perfil";
    public static final String CAMPO_NOM_USU = "nom_Usu";
    public static final String CAMPO_APE_USU = "ape_Usu";
    public static final String CAMPO_RUT_USU = "rut_Usu";
    public static final String CAMPO_FECHA_NAC = "fecha_Nac";
    public static final String CAMPO_EMAIL = "email";
    public static final String CAMPO_CLAVE = "clave";
    public static final String CAMPO_ACTIVO = "activo";

    //Tabla Producto
    public static final String TABLA_PRODUCTO = "producto";
    public static final String CAMPO_CODIGO_BARRA = "codigo_Barra";
    public static final String CAMPO_ID_LOCAL_P = "id_Local";
    public static final String CAMPO_ID_USUARIO_P = "id_Usuario";
    public static final String CAMPO_ID_CATEGORIA_P = "id_Categoria";
    public static final String CAMPO_NOMBRE_PROD = "nombre_Prod";
    public static final String CAMPO_PRECIO_PROD = "precio_Prod";
    public static final String CAMPO_CANTIDAD_PROD = "cantidad_Prod";
    public static final String CAMPO_TOTAL_PROD = "total_Prod";




    public static final String CREAR_TABLA_CATEGORIA = "CREATE TABLE "+TABLA_CATEGORIA+" (\n" +
            "    "+CAMPO_ID_CATEGORIA_C+" INTEGER PRIMARY KEY,\n" +
            "    "+CAMPO_NOMBRE_CAT+" VARCHAR(150) NOT NULL\n" +
            ");";

    public static final String CREAR_TABLA_COMUNA = "CREATE TABLE "+TABLA_COMUNA+" (\n" +
            "    "+CAMPO_ID_COMUNA_C+" INTEGER PRIMARY KEY,\n" +
            "    "+CAMPO_NOMBRE_COM+" VARCHAR(150)\n" +
            ");";

    public static final String CREAR_TABLA_PERFIL = "CREATE TABLE "+TABLA_PERFIL+"(\n" +
            "    "+CAMPO_ID_PERFIL_P+" INTEGER PRIMARY KEY,\n" +
            "    "+CAMPO_RUT_PER+" VARCHAR(10) NOT NULL,\n" +
            "    "+CAMPO_NOMBRE_PER+" VARCHAR(100)\n" +
            ");";

    public static final String CREAR_TABLA_REGION = "CREATE TABLE "+TABLA_REGION+"(\n" +
            "    "+CAMPO_ID_REGION_R+" INTEGER PRIMARY KEY,\n" +
            "    "+CAMPO_NOM_REG+" VARCHAR(150) NULL\n" +
            ");";

    public static final String CREAR_TABLA_LOCAL = "CREATE TABLE "+TABLA_LOCAL+"(\n" +
            "    "+CAMPO_ID_LOCAL_L+" INTEGER(4) PRIMARY KEY,\n" +
            "    "+CAMPO_NOMBRE_LOC+" VARCHAR(150) NOT NULL,\n" +
            "    "+CAMPO_DIRECCION_LOC+" VARCHAR(200) NOT NULL,\n" +
            "    "+CAMPO_GEO_COORDX+" VARCHAR(50) NULL,\n" +
            "    "+CAMPO_GEO_COORDY+" VARCHAR(50) NULL,\n" +
            "    "+CAMPO_ID_REGION_L+" INTEGER NOT NULL,\n" +
            "    "+CAMPO_ID_COMUNA_L+" INTEGER NOT NULL,\n" +
            "    CONSTRAINT fk_local_comuna FOREIGN KEY (id_Comuna) REFERENCES comuna(id_Comuna),\n" +
            "    CONSTRAINT local_region FOREIGN KEY (id_Region) REFERENCES region(id_Region)\n" +
            ");";

    public static final String CREAR_TABLA_USUARIO = "CREATE TABLE "+TABLA_USUARIO+"(\n" +
            "    "+CAMPO_USUARIO+" VARCHAR(15) PRIMARY KEY,\n" +
            "    "+CAMPO_ID_PERFIL_U+" INTEGER NOT NULL,\n" +
            "    "+CAMPO_NOM_USU+" VARCHAR(100) NOT NULL,\n" +
            "    "+CAMPO_APE_USU+" VARCHAR(100) NOT NULL,\n" +
            "    "+CAMPO_RUT_USU+" VARCHAR(10) NOT NULL,\n" +
            "    "+CAMPO_FECHA_NAC+" VARCHAR(10) NULL,\n" +
            "    "+CAMPO_EMAIL+" VARCHAR(100) NULL,\n" +
            "    "+CAMPO_CLAVE+" VARCHAR(10) NOT NULL,\n" +
            "    "+CAMPO_ACTIVO+" BOOLEAN NOT NULL,\n" +
            "    CONSTRAINT fk_usuario_perfil FOREIGN KEY (id_Perfil) REFERENCES perfil(id_Perfil)\n" +
            ");";

    public static final String CREAR_TABLA_PRODUCTO = "CREATE TABLE "+TABLA_PRODUCTO+"(\n" +
            "    "+CAMPO_CODIGO_BARRA+" VARCHAR(100) NOT NULL,\n" +
            "    "+CAMPO_ID_LOCAL_P+" INTEGER NULL,\n" +
            "    "+CAMPO_ID_USUARIO_P+" VARCHAR(15) NULL,\n" +
            "    "+CAMPO_ID_CATEGORIA_P+" INTEGER NULL,\n" +
            "    "+CAMPO_NOMBRE_PROD+" VARCHAR(200) NULL,\n" +
            "    "+CAMPO_PRECIO_PROD+" INTEGER NULL,\n" +
            "    "+CAMPO_CANTIDAD_PROD+" INTEGER NULL,\n" +
            "    "+CAMPO_TOTAL_PROD+" INTEGER NULL,\n" +
            "    CONSTRAINT fk_producto_categoria FOREIGN KEY (id_Categoria) REFERENCES categoria(id_Categoria),\n" +
            "    CONSTRAINT fk_producto_local FOREIGN KEY (id_Local) REFERENCES local(id_Local),\n" +
            "    CONSTRAINT fk_producto_usuario FOREIGN KEY (id_Usuario) REFERENCES usuario(usuario)\n" +
            ");";
}
