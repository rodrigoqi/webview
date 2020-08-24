package com.example.appwebview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    WebView wbvPagina;
    EditText edtTexto;
    RadioButton rdbOrigemPt, rdbOrigemEn, rdbOrigemEs, rdbDestinoPt, rdbDestinoEn, rdbDestinoEs;
    Button btnTraduzir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtTexto = findViewById(R.id.edtTexto);
        rdbOrigemPt = findViewById(R.id.rdbOrigemPt);
        rdbOrigemEn = findViewById(R.id.rdbOrigemEn);
        rdbOrigemEs = findViewById(R.id.rdbOrigemEs);
        rdbDestinoPt = findViewById(R.id.rdbDestinoPt);
        rdbDestinoEn = findViewById(R.id.rdbDestinoEn);
        rdbDestinoEs = findViewById(R.id.rdbDestinoEs);
        btnTraduzir = findViewById(R.id.btnTraduzir);

        wbvPagina = findViewById(R.id.wbvPagina);


        btnTraduzir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = gerarUrl();
                wbvPagina.loadUrl(url);
            }
        });
    }

    private String gerarUrl(){
        String url = "https://www.linguee.com.br/";
        //Montando o parâmetro de lingua de origem
        if(rdbOrigemPt.isChecked()) url += "portugues";
        if(rdbOrigemEn.isChecked()) url += "ingles";
        if(rdbOrigemEs.isChecked()) url += "espanhol";
        //Montando o parâmetro de lingua de destino
        if(rdbDestinoPt.isChecked()) url += "-portugues";
        if(rdbDestinoEn.isChecked()) url += "-ingles";
        if(rdbDestinoEs.isChecked()) url += "-espanhol";
        //Inserindo na url o texto a ser traduzido
        url += "/search?source=auto&query=" + edtTexto.getText().toString();

        return url;
    }
}