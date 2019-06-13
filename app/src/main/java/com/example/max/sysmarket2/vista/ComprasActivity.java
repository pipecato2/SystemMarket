package com.example.max.sysmarket2.vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.max.sysmarket2.R;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class ComprasActivity extends AppCompatActivity {

    ListView lv_cc_carro;
    EditText et_cc_producto;
    ImageButton img_btn_scan;
    String res;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compras);

        et_cc_producto  = (EditText) findViewById(R.id.et_cc_producto);
        img_btn_scan = (ImageButton) findViewById(R.id.img_btn_scan);

        scanear();
    }

    public void scanear (){
        IntentIntegrator intent = new IntentIntegrator(this);
        intent.setDesiredBarcodeFormats(IntentIntegrator.ONE_D_CODE_TYPES);
        intent.setPrompt("Escanear codigo");
        intent.setCameraId(0);
        intent.setOrientationLocked(false);
        intent.setBeepEnabled(false);
        intent.setBarcodeImageEnabled(false);
        intent.initiateScan();

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        final IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (result != null) {

            res = result.getContents();
            Toast.makeText(this, res, Toast.LENGTH_SHORT).show();
            et_cc_producto.setText(res);
        } else {
            Toast.makeText(this, "No hay", Toast.LENGTH_SHORT).show();
        }
    }


}
