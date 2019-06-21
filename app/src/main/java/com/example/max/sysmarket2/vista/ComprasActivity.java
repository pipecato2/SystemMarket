package com.example.max.sysmarket2.vista;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.max.sysmarket2.R;
import com.example.max.sysmarket2.modelo.conexion.ConexionSQLiteHelper;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class ComprasActivity extends AppCompatActivity {

    ListView lv_cc_carro;
    EditText et_cc_producto;
    ImageButton img_btn_scan;
    String res;
    String resScan;
    ConexionSQLiteHelper conn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compras);

        et_cc_producto  = (EditText) findViewById(R.id.et_cc_producto);
        img_btn_scan = (ImageButton) findViewById(R.id.img_btn_scan);

        scanear();
    }

    /**
     *  Prepara la camara del telefono movil para iniciar el escaneo.
     *
     */

    public void scanear() {

        IntentIntegrator intent = new IntentIntegrator(this);
        intent.setDesiredBarcodeFormats(IntentIntegrator.PRODUCT_CODE_TYPES);
        intent.setPrompt("Escanear codigo");
        intent.setCameraId(0);
        intent.setOrientationLocked(false);
        intent.setBeepEnabled(false);
        intent.setBarcodeImageEnabled(false);
        intent.initiateScan();

    }

    /**
     * El metodo inicia la nueva actividad en donde reciibe el codigo de barras, busca el formato y devuelve
     * como un String, se valida existencia de codigo de barra, aun esta en desarrollo el resto de la funcionalidad
     * @param requestCode
     * @param resultCode
     * @param data
     */

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        final IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        String codigo_de_barra;
        if (result != null) {
            resScan = result.getContents();
            conn = new ConexionSQLiteHelper(ComprasActivity.this, "systemMarket", null, 1);
            Cursor cursor = conn.alldataProd();
            while (cursor.moveToNext()) {
                codigo_de_barra = String.valueOf(cursor.getInt(0));
                if (codigo_de_barra.equals(resScan)) {
                    Toast.makeText(this, "Existe" + codigo_de_barra, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "No existe" + codigo_de_barra, Toast.LENGTH_SHORT).show();

                }
            }
        }


    }


}
