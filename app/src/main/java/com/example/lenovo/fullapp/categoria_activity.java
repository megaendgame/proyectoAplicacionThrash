package com.example.lenovo.fullapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

public class categoria_activity extends AppCompatActivity {

    ListView lista;
    Button mLogOutBtn;

    //matriz bidimensional
    String [][] datos={
            {"Accept","heavyMetal","21:00","10","Accept es una banda alemana de heavy metal fundada en Solingen en 1976, por el vocalista Udo Dirkschneider y el guitarrista Wolf Hoffmann. Luego de algunos cambios en su alineación, en el que ingresó el bajista Peter Baltes, debutaron con Accept en 1979, a través de Brain Records. Durante la primera parte de los años 1980 obtuvieron un importante reconocimiento en los mercados europeos, Estados Unidos y Japón, gracias a las producciones Breaker (1981), Restless and Wild (1982), Balls to the Wall (1983) y Metal Heart (1985). En 1987, tras la gira promocional de Russian Roulette de 1986, Udo renunció a la banda para iniciar una carrera como solista con su propia agrupación U.D.O. Para sustituirlo contrataron al estadounidense David Reece para la grabación de Eat the Heat de 1989, pero debido a las malas críticas y a la poca recepción de sus fanáticos, la banda optó por separarse a fines del mismo año."},
            {"Bulldozer","heavyMetal","20:30","3","Bulldozer fue una banda de Thrash/speed metal fundada en Milán el año 1980, separada en 1981 y refundada en 1984, vuelta a separar en 1990 y reunida de nuevo en 2008. Es considerada como uno de los grupos de Metal originarios de Italia más importantes junto con Stranna Officina, Vanadium, Sabotage, Necrodeath y Death SS."},
            {"destruction","Metal","21:00","9","Destruction se formó como \"Knight of Demon\" en Lörrach, Alemania en 1982. En la línea original destacó el vocalista y bajista Schmier, el baterista Tommy Sandmann, y el guitarrista Mike Sifinger. Pronto se cambió su nombre por el de \"Destruction\" y dio a conocer un demo titulado \"Bestial Invasion Of Hell\" en 1984. Después de esto el grupo firmó con Steamhammer Records y reveló un EP titulado Sentence Of Death más tarde ese año."},
            {"Exodus","ThrashMetal","21:00","8","Exodus es una banda estadounidense de thrash metal formada en 1979 en la bahía de San Francisco, California, fundada por Kirk Hammett (actual guitarrista de Metallica) Tim Agnello, como segunda guitarra reemplazado más tarde por Gary Holt, el bajista Carlton Nelson, reemplazado más tarde por Geof Andrews, y el baterista/ vocalista Tom Hunting, para luego reclutar a Paul Baloff como vocalista oficial. Exodus es una de las primeras bandas de thrash metal con una carrera que abarca más de 30 años, pasando por numerosos cambios de formación, además de dos extensas separaciones y que ha visto la muerte de dos de sus miembros originales. Con 10 álbumes de estudio, dos álbumes en vivo y dos compilaciones, Exodus ha publicado un total de 14 álbumes desde su debut en 1985. Gary Holt sigue siendo el único miembro permanente de la banda, apareciendo en todos sus discos. Aunque el baterista Tom Hunting es uno de los fundadores de la banda, ha tenido dos salidas de Exodus, pero actualmente sigue siendo el baterista de la banda. En el año 2014 Rob Dukes sale de Exodus regresando a la banda Steve \"Zetro\" Souza para grabar el nuevo álbum llamado Blood In, Blood Out que salió a la venta el 14 de octubre de ese mismo año."},
            {"titulo","director","21:00","2","descripcion"},
            {"Muse","pop","16:45","4","descripcion"},
            //{"titulo","director","15:00","9","descripcion"},
            //{"Rhapsody","Speed","21:45","7","descripcion"},
            //{"Vader","HeavyMetal","22:00","8","descripcion"},
            //{"Steve Wilson","Rock","22:00","10","descripcion"},

    };

    int [] datosImg = {R.drawable.accept , R.drawable.booldozer, R.drawable.destruction, R.drawable.exodus, R.drawable.metal,
            R.drawable.muse };
    // R.drawable.rancagua, R.drawable.rhapsody, R.drawable.vader, R.drawable.wilson




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria_activity);

        lista = (ListView) findViewById(R.id.lvLista);

        lista.setAdapter(new Adaptador(this, datos,datosImg));

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent visorDetalles = new Intent(view.getContext(), DetallesPelicula.class);
                visorDetalles.putExtra("TIT", datos[position][0]);
                visorDetalles.putExtra("DET", datos[position][4]);
                startActivity(visorDetalles);

        //salir de la sesion
          mLogOutBtn = (Button) findViewById(R.id.logout);

                mLogOutBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        FirebaseAuth.getInstance().signOut();
                        startActivity(new Intent(categoria_activity.this, MainActivity.class));
                    }
                });
            }
        });


    }
}
