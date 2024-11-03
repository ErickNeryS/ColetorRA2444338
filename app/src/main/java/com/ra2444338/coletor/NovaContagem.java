package com.ra2444338.coletor;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.journeyapps.barcodescanner.BarcodeResult;
import com.journeyapps.barcodescanner.CaptureActivity;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;


class NovaContagemActivity extends CaptureActivity {

    private DecoratedBarcodeView barcodeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_nova_contagem);

        barcodeView = findViewById(com.google.zxing.client.android.R.id.zxing_barcode_scanner);
    }

    @Override
    protected void onResume() {
        super.onResume();
        barcodeView.resume();
        super.onResume();
        try {
            barcodeView.resume();
        } catch (Exception e) {
            // Tratar a exceção, por exemplo, exibir uma mensagem de erro para o usuário
            Log.e("NovaContagemActivity", "Erro ao iniciar a câmera: " + e.getMessage());
            Toast.makeText(this, "Ocorreu um erro ao iniciar a câmera. Tente novamente.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        barcodeView.pause();
    }


    public void handleResult(BarcodeResult result) {
        String barcodeResult = result.getText();
        // Faça algo com o resultado, por exemplo, exiba em um Toast
        Toast.makeText(this, "Código de barras: " + barcodeResult, Toast.LENGTH_SHORT).show();
        finish();
    }

}