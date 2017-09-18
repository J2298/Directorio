package com.job.directorio;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.file.DirectoryIteratorException;
import java.util.ArrayList;
import java.util.List;

import static com.job.directorio.R.id.nombre;
import static com.job.directorio.R.id.telefono;
import static com.job.directorio.R.layout.custom_dialog;

public class MainActivity extends AppCompatActivity {

    private static final int REGISTER_FORM_REQUEST = 100;
    private ListView list;
    private List<Directorio> directorios = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.lista_contactos);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        list.setAdapter(adapter);

        adapter = (ArrayAdapter<String>) list.getAdapter();

        adapter.clear();

        Directorio d1 = new Directorio("Paul Flores", "paul.flores@gmail.com", "SP123", 965856234);
        Directorio d2 = new Directorio("Raul Armas", "raul.armas@gmail.com", "PE123", 985475865);
        Directorio d3 = new Directorio("Jimena Ponce", "jimena.ponce@gmail.com", "DF123", 978569632);
        Directorio d4 = new Directorio("Sofia Ramos", "sofia.ramos@gmail.com", "RT123", 978457856);
        Directorio d5 = new Directorio("Claudia Quispe", "claudia.quispe@gmail.com", "SD123", 978569963);

        directorios.add(d1);
        directorios.add(d2);
        directorios.add(d3);
        directorios.add(d4);
        directorios.add(d5);

        //Directorio directorio = Directorio();

        //List<Directorio> directorios = List<> Directorio;

        for (Directorio directorio : directorios) {
            adapter.add(directorio.getNombre());

        }
        adapter.notifyDataSetChanged();

        list.setOnItemClickListener(new OnItemClickListener() {

            String nom;
            String cor;
            String ofi;
            int tele;

            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                for (Directorio directorio : directorios) {
                    Object listItem = list.getItemAtPosition(position);
                    if (listItem == directorio.getNombre()) {
                        nom = directorio.getNombre();
                        cor = directorio.getCorreo();
                        ofi = directorio.getOficina();
                        tele = directorio.getTelefono();
                    }
                }
                //Toast.makeText(MainActivity.this, "as" + cor, Toast.LENGTH_SHORT).show();
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(custom_dialog);
                // Custom Android Allert Dialog Title
                dialog.setTitle("Inf. Contacto");

                Button dialogllamar = (Button) dialog.findViewById(R.id.llamar);
                Button dialogmensaje = (Button) dialog.findViewById(R.id.mensaje);
                TextView nombrei = (TextView) dialog.findViewById(R.id.nombre);
                TextView correoi = (TextView) dialog.findViewById(R.id.correo);
                TextView oficinai = (TextView) dialog.findViewById(R.id.oficina);
                TextView telefonoi = (TextView) dialog.findViewById(R.id.telefono);

                nombrei.setText("" + nom);
                correoi.setText("" + cor);
                oficinai.setText("" + ofi);
                telefonoi.setText("" + tele);

                dialogllamar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Toast.makeText(getApplicationContext(), "Cancel process!", Toast.LENGTH_SHORT).show();
                        /*Intent intent = new Intent(Intent.ACTION_CALL);
                        intent.setData(Uri.parse(""+telefonoi));
                        startActivity(intent);*/
                        Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                        dialIntent.setData(Uri.parse("tel:" + tele));
                        startActivity(dialIntent);
                        dialog.dismiss();
                    }
                });

                // Your android custom dialog ok action
                // Action for custom dialog ok button click
                dialogmensaje.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        //Toast.makeText(getApplicationContext(), "Success process!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_SEND);

                        intent.putExtra(Intent.EXTRA_TEXT, "numero: "+tele);
                        intent.setType("text/plain");

                        startActivity(intent);
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }
}

/*
    */

//Toast.makeText(MainActivity.this, "as" + list.getSelectedItem(), Toast.LENGTH_SHORT).show();
//Object listItem = list.getItemAtPosition();
//String strName = directorioslis.getItem(which);
//Object listItem = adapter.getItem(nombre, View view);
//Toast.makeText(MainActivity.this, "as" + listItem, Toast.LENGTH_SHORT).show();
//String value = (String)adapter.getItemAtPosition(nombre);
//Toast.makeText(MainActivity.this, "as" + value, Toast.LENGTH_SHORT).show();