package com.example.max.sysmarket2.vista;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.max.sysmarket2.R;
import com.example.max.sysmarket2.modelo.Validadores;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * El RegistroActivity, es una nueva vista la cual permitira realizar el registro de un usuario no registrado
 *
 * @author Maximiliano Pinto
 * @version 15-05-2019/v1.0 prueba
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

    static EditText et_rg_usuario_A;
    static EditText et_rg_nombre_A;
    static EditText et_rg_apellido_A;
    static EditText et_rg_nacimiento_A;
    static EditText et_rg_new_pass_A;
    static EditText et_rg_repite_pass_A;
    static EditText et_rg_correo_A;
    static Boolean bolValidador;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mnuguardado, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getTitle().toString()) {
            case "Guardar":
                getInsertarUsuario(this);
                return true;
            case "Volver":
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
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
    }

    public static void getInsertarUsuario(final Context contex){
        bolValidador=false;
     //   et_rg_usuario_A = (EditText) findViewById(R.id.et_rg_usuario);
    //    et_rg_nombre_A = (EditText) findViewById(R.id.et_rg_nombre);
     //   et_rg_apellido_A = (EditText) findViewById(R.id.et_rg_apellido);
     //   et_rg_nacimiento_A = (EditText) findViewById(R.id.et_rg_nacimiento);
     //   et_rg_new_pass_A = (EditText) findViewById(R.id.et_rg_new_pass);
      //  et_rg_repite_pass_A = (EditText) findViewById(R.id.et_rg_repite_pass);
      //  et_rg_correo_A = (EditText) findViewById(R.id.et_rg_correo);
        String PLACES_URL = "http://fmorales-001-site2.btempurl.com/Api/Usuario/" + et_rg_usuario_A.getText().toString() +
                        "/" + et_rg_nombre_A.getText().toString() +
                        "/" + et_rg_apellido_A.getText().toString() +
                        "/1344/"+ et_rg_nacimiento_A .getText().toString()+
                        "/" + et_rg_correo_A.getText().toString()+
                        "/" + et_rg_new_pass_A.getText().toString() + "/Insertar";
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
                        if (responsePlaces.length() == 0) {
                            Toast.makeText(contex,contex.getString(R.string.msjContresanaIncorrecta), Toast.LENGTH_LONG).show();
                        } else {

                            for (int i = 0; i < responsePlaces.length(); i++) {
                                try {
                                    if(responsePlaces.getJSONObject(i).getString("IdResultado")=="0"){
                                        bolValidador =false;
                                        Toast.makeText(contex,responsePlaces.getJSONObject(i).getString("Mensaje1"), Toast.LENGTH_LONG).show();
                                    }
                                    else{
                                        if(responsePlaces.getJSONObject(i).getString("IdResultado")=="1"){
                                            bolValidador =true;
                                            Toast.makeText(contex,responsePlaces.getJSONObject(i).getString("Mensaje1"), Toast.LENGTH_LONG).show();
                                        }
                                    }


                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }


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
