package com.arielaguirre.apirestvolley;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.arielaguirre.apirestvolley.modelo.Cliente;
import com.arielaguirre.apirestvolley.modelo.Publicacion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView ;
    ArrayAdapter arrayAdapter;
    ArrayList<String> datos = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView= findViewById(R.id.lista);
        arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,datos);
        listView.setAdapter(arrayAdapter);
        ListaPublicaciones();
    }

    private void ListaPublicaciones(){
        //String url="https://jsonplaceholder.typicode.com/posts";
        String url="http://172.24.14.121:8080/api/cliente";
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                pasarJson(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
        Volley.newRequestQueue(this).add(jsonArrayRequest);
    }

  /*  private void pasarJson(JSONArray jsonArray){
        for(int i=0;i<jsonArray.length();i++){
            JSONObject json=null;
            Publicacion publicacion=new Publicacion();

            try{
                json=jsonArray.getJSONObject(i);
                publicacion.setUserId(json.getInt("userId"));
                publicacion.setId(json.getInt("id"));
                publicacion.setTitulo(json.getString("title"));
                publicacion.setCuerpo(json.getString("body"));
                datos.add(publicacion.getTitulo());

            }catch (JSONException e){
                e.printStackTrace();
            }

        }
        arrayAdapter.notifyDataSetChanged();
*/
        private void pasarJson(JSONArray jsonArray){
    for(int i=0;i<jsonArray.length();i++){
        JSONObject json=null;
        Cliente client=new Cliente();

        try{
            json=jsonArray.getJSONObject(i);
            client.setId(json.getInt("id"));
            client.setNombre(json.getString("nombre"));
            client.setAppellido(json.getString("apellido"));
            client.setEmail(json.getString("email"));
            datos.add(client.getNombre());

        }catch (JSONException e){
            e.printStackTrace();
        }

    }
    arrayAdapter.notifyDataSetChanged();



    }
    /*
    private void inicio_Cotrol(){
        botonCarga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/



}