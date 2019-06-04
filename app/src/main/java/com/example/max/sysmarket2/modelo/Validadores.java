package com.example.max.sysmarket2.modelo;

import android.support.v4.util.Pools;
import android.widget.EditText;

import com.example.max.sysmarket2.modelo.conexion.ConexionBD;
import com.example.max.sysmarket2.modelo.vo.UsuarioVO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Esta clase tendra metodos los cuales seran utilizados para controlar restricciones de entrada
 *
 * @author Maximiliano Pinto
 * Version: 14-05-2019/V1.0
 */

public class Validadores {

    /**
     * Metodo para validar si el campo ingresado esta vacio, y si es mayor 0 y menor de 12 caracteres
     *
     * @param et_entrada
     * @return Error: "Debe completar el campo" || "Debe tener entre 1 y 11 caracteres".
     */
    public static String validaTexto(EditText et_entrada) {


      //Holi

        String error = null;
        String texto = et_entrada.getText().toString();
        if (texto.isEmpty()) {
            error = "Debe completar el campo";

            return error;
        } else {
            if (texto.length() >= 12) {
                error = "Debe tener entre 1 y 11 caracteres";
            }else {
                if (texto.matches("[a-zA-Z]")){

                }else {
                    error = "Debe contener solo mayusculas o minusculas";
                }
            }
            return error;
        }

    }

    /**
     * Metodo validara la contraseña del login para el ingreso a la aplicacion
     *
     * @param et_entrada Es el parametro solicitado en el metodo el cual sera convertido en String.
     *                   Validara si existe contraseña ingresada y si tiene 6 caracteres.
     * @return error: "Debe completar campo" || "Debe tener 6 caracteres".
     */
    public static String valida_pass(EditText et_entrada) {

        String error = null;
        String texto = et_entrada.getText().toString();
        ;

        if (texto.isEmpty()) {
            error = "Debe completar campo";

        } else {
            if (texto.length() != 6) {
                error = "Debe tener 6 caracteres";
            }
        }

        /**
         * FALTA INCORPORAR LA VALIDACION DE LA CONTRASEÑA EN BD
         */

        return error;
    }

    public static String valida_reg_pass(EditText et_entrada, EditText pass1, EditText pass2) {

        String error = null;
        String val_pass1 = pass1.getText().toString();
        String val_pass2 = pass2.getText().toString();
        String texto = et_entrada.getText().toString();

        if (texto.isEmpty()) {
            error = "Debe completar campo";

        } else {
            if (texto.length() != 6) {
                error = "Contraseña debe tener 6 digitos";
            } else {
                if (val_pass1 != val_pass2) {
                    error = "Las contraseñas deben coincidir";
                }

            }
        }

        return error;
    }


    public static String valida_existencia (UsuarioVO user){

        String usuario = user.getNomUser();
        String contrasena= user.getContrasena();
        String error = null;

        String SQL = "SELECT Usuario, Clave from Usuario WHERE Usuario = '" + usuario +"' AND '" + contrasena+ "'";

        ConexionBD conn = conn = new ConexionBD();

        try {

            conn.conexion();
            Statement state = conn.conexion().createStatement();
            ResultSet resSet = state.executeQuery(SQL);

            if(resSet.next()){

            }

        } catch (SQLException e) {
            error = e.toString();
            e.printStackTrace();
        }

        return  error;


    }

  /*  public static int obtener_edad ( EditText et_entrada){

    }*/



}


