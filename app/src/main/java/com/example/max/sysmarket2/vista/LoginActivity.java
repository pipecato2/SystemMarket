package com.example.max.sysmarket2.vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.max.sysmarket2.R;
import com.example.max.sysmarket2.modelo.Validadores;
import com.example.max.sysmarket2.modelo.dao.UsuarioDAO;
import com.example.max.sysmarket2.modelo.vo.UsuarioVO;

/**
 * En LoginActivity es MAIN, esto quiere decir cuando se abra la aplicacion, esta funcionara a partir del LoginActivity
 *
 * @author Maximiliano Pinto
 * @Version: 14-05-2019/V1.0
 */

public class LoginActivity extends AppCompatActivity {
    /**
     * Declaracion de variables a utilizar en el Activity LoginActivity
     *
     * @param et_lg_usuario_A El parametro de tipo EdiText almacenara el contenido ingresado en la caja de texto de "Ingrese usuario"
     * @param et_lg_password_A El parametro de tipo EdiText almacenara el contenido ingresado en la caja de texto de "password"
     * @param btn_lg_ingresar_A El parametro de tipo Button referencia el boton "Ingresar" el cual iniciara el Activity "PrincipalActivity"
     * @param btn_lg_registrar_A El parametro de tipo Button referencia el boton "Registrar" el cual iniciara el Activity "RegistroActivity"
     * @param btn_lg_salir_A El parametro de tipo Button referencia el boton "Salir" el cual cerrara la aplicacion.
     */
    EditText et_lg_usuario_A;
    EditText et_lg_password_A;
    Button btn_lg_ingresar_A;
    Button btn_lg_registar_A;
    Button btn_lg_salir_A;

    String titulo = "Ingreso";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.setTitle(R.string.SystemMarket);

        /**
         * A las variables declaradas, se le entregan como valores
         */
        et_lg_usuario_A = (EditText) findViewById(R.id.et_lg_usuario);
        et_lg_password_A = (EditText) findViewById(R.id.et_lg_password);
        btn_lg_ingresar_A = (Button) findViewById(R.id.btn_lg_ingresar);
        btn_lg_registar_A = (Button) findViewById(R.id.btn_lg_registar);
        btn_lg_salir_A = (Button) findViewById(R.id.btn_lg_salir);


        btn_lg_ingresar_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                UsuarioVO usu = new UsuarioVO();

                
                String error;

                /**
                 * Declacarion de variables
                 */


                if (Validadores.valida_existencia(usu) == null){

                    Intent i = new Intent(LoginActivity.this, ComprasActivity.class);
                    startActivity(i);

                }else {

                    error = Validadores.valida_existencia(usu);
                    Toast.makeText(getApplicationContext(), error,Toast.LENGTH_SHORT).show();
                }


         /*
                error = Validadores.validaTexto(et_lg_usuario_A);

                if (error != null) {
                    et_lg_usuario_A.setError(error);

                } else {
                    error = Validadores.valida_pass((et_lg_password_A));
                    if (error != null) {
                        et_lg_password_A.setError(error);
                    }else {
                        if (error != null){


                        }
                    }
                } */

            }
        });

        btn_lg_registar_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, RegistroActivity.class);
                startActivity(i);
            }
        });


    }

    ;


}

