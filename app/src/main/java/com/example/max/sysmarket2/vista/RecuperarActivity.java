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
import com.android.volley.toolbox.Volley;
import com.example.max.sysmarket2.R;
import com.example.max.sysmarket2.modelo.vo.UsuarioVO;

import org.json.JSONArray;
import org.json.JSONException;
import com.example.max.sysmarket2.General.clsFunciones;


public class RecuperarActivity extends AppCompatActivity {

    static Button bt_enviar;
    static EditText ed_usuario;
    static Boolean bolValidador;
    static clsFunciones funciones = new clsFunciones();
    private String _user;

    private String _pass;



    private String[] _to;

    private String _from;



    private String _port;

    private String _sport;



    private String _host;



    private String _subject;

    private String _body;



    private boolean _auth;



    private boolean _debuggable;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar);

        bt_enviar= (Button)findViewById(R.id.btEnviar);
        ed_usuario=(EditText)findViewById(R.id.edEmail);

        bt_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funciones.sendEmail(v.getContext());
            }
        });
    }

    public static void getObtenerEmail(final Context contex, String usuario, String Clave){
        bolValidador=false;
        String PLACES_URL = "http://fmorales-001-site2.btempurl.com/api/Usuario/"+usuario+"/"+Clave+"/RecuperarUsuario";
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
                            Toast.makeText(contex,contex.getString(R.string.msjContresanaIncorrecta), Toast.LENGTH_LONG).show();
                        } else {
                            for (int i = 0; i < responsePlaces.length(); i++) {
                                try {
                                    usu.setNomUser(responsePlaces.getJSONObject(i).getString("usuario1"));
                                    usu.setEmail(responsePlaces.getJSONObject(i).getString("Email1"));
                                    usu.setContraseña(responsePlaces.getJSONObject(i).getString("Clave1"));

                                    if(usu.getEstado()==0){
                                        ed_usuario.clearFocus();
                                        bolValidador =false;
                                        Toast.makeText(contex,contex.getString(R.string.msjcuentaInactiva), Toast.LENGTH_LONG).show();
                                    }
                                    else{
                                        bolValidador =true;

                                        Intent act = new Intent(contex, ComprasActivity.class);
                                        contex.startActivity(act);
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
