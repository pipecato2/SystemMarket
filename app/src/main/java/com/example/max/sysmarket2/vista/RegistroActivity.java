package com.example.max.sysmarket2.vista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.max.sysmarket2.R;
import com.example.max.sysmarket2.modelo.Validadores;

/**
 * El RegistroActivity, es una nueva vista la cual permitira realizar el registro de un usuario no registrado
 *
 * @author Maximiliano Pinto
 * @version 15-05-2019/v1.0
 */

public class RegistroActivity extends AppCompatActivity {

    /**
     * Declaracion de variables a utilizar en el Activity RegistroActivity
     *
     * @param et_rg_usuario_A El parametro de tipo EdiText almacenara el contenido ingresado en la caja de texto de "Ingrese nuevo usuario".
     * @param et_rg_nombre_A El parametro de tipo EdiText almacenara el contenido ingresado en la caja de texto de "Ingrese su nombre".
     * @param et_rg_apellido_A El parametro de tipo EdiText almacenara el contenido ingresado en la caja de texto de "Ingrese su apellido".
     * @param et_rg_nacimiento_A El parametro de tipo EdiText almacenara el contenido ingresado en formato de fecha de caja de texto "Ingrese su fecha de nacimiento",
     * validara si el usuario es mayor de edad.
     * @param et_rg_password_A El parametro de tipo EdiText almacenara el contenido ingresado en la caja de texto "ingrese su nueva contraseña".
     * @param et_rg_re_password_A El parametro de tipo EdiText almacenara el contenido ingresado en la caja de texto "repita contraseña",
     * validara que la contraseña ingresada sea correcta.
     * @param et_rg_correo_A El parametro de tipo EdiText almacenara el contenido ingresado en la caja de texto "Correo electronico".
     * @param btn_rg_registrar_A El parametro de tipo Button referencia el boton "Registrar", esto gatillara la accion de creacion de usuario en la base de datos y volvera a la actividad LoginActivity.
     * @param btn_rg_cancelar_A El parametro de tipo Button referencia el boton "Cancelar" el cual cerrara volvera a la actividad LoginActivity.
     */

    EditText et_rg_usuario_A;
    EditText et_rg_nombre_A;
    EditText et_rg_apellido_A;
    EditText et_rg_nacimiento_A;
    EditText et_rg_new_pass_A;
    EditText et_rg_repite_pass_A;
    EditText et_rg_correo_A;
    Button btn_rg_registrar_A;
    Button btn_rg_cancelar_A;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        this.setTitle(R.string.sysMarket_login);

        et_rg_usuario_A = (EditText) findViewById(R.id.et_rg_usuario);
        et_rg_nombre_A = (EditText) findViewById(R.id.et_rg_nombre);
        et_rg_apellido_A = (EditText) findViewById(R.id.et_rg_apellido);
        et_rg_nacimiento_A = (EditText) findViewById(R.id.et_rg_nacimiento);
        et_rg_new_pass_A = (EditText) findViewById(R.id.et_rg_new_pass);
        et_rg_repite_pass_A = (EditText) findViewById(R.id.et_rg_repite_pass);
        et_rg_correo_A = (EditText) findViewById(R.id.et_rg_correo);
        btn_rg_registrar_A = (Button) findViewById(R.id.btn_rg_registrar);
        btn_rg_cancelar_A = (Button) findViewById(R.id.btn_rg_cancelar);

        btn_rg_registrar_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String error = null;

                error = Validadores.validaTexto(et_rg_usuario_A);

                if(error != null){
                    et_rg_usuario_A.setError(error);
                }else {
                    error = Validadores.validaTexto(et_rg_nombre_A);
                    if(error!=null){
                        et_rg_nombre_A.setError(error);
                    }else{
                        error = Validadores.validaTexto(et_rg_apellido_A);
                        if (error != null){
                            et_rg_apellido_A.setError(error);
                        }else {
                           //se debe ingresar el DATE error = Validadores.valida_pass()
                        }
                    }
                }

            }
        });
        btn_rg_cancelar_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
