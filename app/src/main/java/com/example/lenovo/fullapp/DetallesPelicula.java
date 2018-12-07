package com.example.lenovo.fullapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetallesPelicula extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_pelicula);

        TextView titulo = (TextView) findViewById(R.id.tvTituloDescripcion);
        TextView detalles = (TextView) findViewById(R.id.tvdetalles);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        if (b!=null){
            titulo.setText(b.getString("TIT"));
            detalles.setText(b.getString("DET"));

            //link website
            findViewById(R.id.btnTicket).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clicked_btn("https://www.ticketek.cl/");
                }
            });


        }
    }

    /*public void browser1(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ticketek.cl/"));
        startActivity(browserIntent);
    }*/

    public void clicked_btn(String url)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

}
