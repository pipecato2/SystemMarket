package com.example.max.sysmarket2.vista;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

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
    static EditText et_lg_usuario_A;
    static EditText et_lg_password_A;
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

                String error;

                /**
                 * Declacarion de variables
                 */


           //     if (Validadores.valida_existencia(usu) == null){

             //       Intent i = new Intent(LoginActivity.this, ComprasActivity.class);
               //     startActivity(i);

               // }else {

                 //   error = Validadores.valida_existencia(usu);
                 //   Toast.makeText(getApplicationContext(), error,Toast.LENGTH_SHORT).show();
               // }
                    getUsuario(v.getContext(),et_lg_usuario_A.getText().toString(),et_lg_password_A.getText().toString());



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

    public static void getUsuario(final Context contex, String usuario, String Clave){

        String PLACES_URL = "http://fmorales-001-site2.btempurl.com/api/Usuario/"+usuario+"/"+Clave+"/ValidacionUsuario";
        final String LOG_TAG = "VolleyPlacesRemoteDS";

// Instantiate the RequestQueue
        RequestQueue requestQueue = Volley.newRequestQueue(contex);

//Prepare the Request
        JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET, //GET or POST
                PLACES_URL, //URL
                null, //Parameters
                new Response.Listener<JSONArray>() { //Listener OK

                    @Override
                    public void onResponse(JSONArray responsePlaces) {
                        UsuarioVO usu = new UsuarioVO();
                        if (responsePlaces.length() == 0) {
                            et_lg_password_A.setText("");
                            et_lg_usuario_A.clearFocus();
                            Toast.makeText(contex,contex.getString(R.string.msjContresanaIncorrecta), Toast.LENGTH_LONG).show();
                        } else {
                            for (int i = 0; i < responsePlaces.length(); i++) {
                                try {
                                    usu.setNomUser(responsePlaces.getJSONObject(i).getString("usuario1"));
                                    usu.setApellido(responsePlaces.getJSONObject(i).getString("Apellido1"));

                                    usu.setApellido(responsePlaces.getJSONObject(i).getString("Rut1"));
                                    usu.setNombre(responsePlaces.getJSONObject(i).getString("Nombre1"));
                                    usu.setIdPerfil(responsePlaces.getJSONObject(i).getInt("IdPerfil"));
                                    usu.setFecha_Nac(responsePlaces.getJSONObject(i).getString("Fecha_Nac1"));
                                    usu.setEmail(responsePlaces.getJSONObject(i).getString("Email1"));
                                    usu.setContraseña(responsePlaces.getJSONObject(i).getString("Clave1"));
                                    usu.setEstado(responsePlaces.getJSONObject(i).getInt("Activo")) ;

                                    if(usu.getEstado()==0){
                                        et_lg_password_A.setText("");
                                        et_lg_usuario_A.clearFocus();
                                        Toast.makeText(contex,contex.getString(R.string.msjcuentaInactiva), Toast.LENGTH_LONG).show();
                                    }

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        Log.d(LOG_TAG,responsePlaces.toString());
                    }
                }, new Response.ErrorListener() { //Listener ERROR

            @Override
            public void onErrorResponse(VolleyError error) {
                //There was an error :(
                Log.d(LOG_TAG,error.toString());
            }
        });

//Send the request to the requestQueue
        requestQueue.add(request);
    }


}

