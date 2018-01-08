package com.tttdevs.nanobrowser;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText txtDireccion;
    Button btnIr;
    WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Asocio objetos con sus Views correspondientes
        txtDireccion    = findViewById(R.id.editText);
        btnIr           = findViewById(R.id.button);
        webView         = findViewById(R.id.webview);

        // Creo objeto WebSettings para habilitar Javascript
        WebSettings wSettings = webView.getSettings();
        wSettings.setJavaScriptEnabled(true);

        // Evento "on click" del botón
        btnIr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String urlIngresada = String.valueOf(txtDireccion.getText());
                webView.loadUrl(urlIngresada);
            }
        });

    } // Fin onCreate

    // Este método se llama cuando se detecta un click en el botón "volver"
    // La acción por defecto es simplemente cerrar la aplicación, pero si se
    // hace override, se puede definir un nuevo comportamiento.
    // En este caso, determinamos si el navegador tiene páginas en el histórico,
    // si las hay, entonces volver atrás, y cuando no quedan más páginas a las que
    // volver, entonces mostramos un diálogo de confirmación si/no para salir de
    // la app.
    @Override
    public void onBackPressed() {
        // Determino si existe un "atrás" al que volver en el WebView.
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            // Creo un nuevo AlertDialog Builder
            AlertDialog.Builder aDialog = new AlertDialog.Builder(this);

            // Defino propiedades del diálogo
            aDialog.setMessage("¿Salir de Nano Browser?");
            aDialog.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            aDialog.setNegativeButton("No", null);

            // Muestro el diálogo
            aDialog.show();

        } // Fin else

    } // Fin onBackPressed

} // Fin MainActivity
