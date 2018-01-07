package com.tttdevs.nanobrowser;

import android.annotation.SuppressLint;
import android.os.Bundle;
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

        txtDireccion = findViewById(R.id.editText);
        btnIr = findViewById(R.id.button);
        webView = findViewById(R.id.webview);

        WebSettings wSettings = webView.getSettings();
        wSettings.setJavaScriptEnabled(true);

        btnIr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.loadUrl(String.valueOf(txtDireccion.getText()));
            }
        });
    }
}
