package com.example.practica_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.ArrayRow;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    Button button_get, button_post, button_update, button_delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //for(int i = 0; i < 100; i++){
            //viewText.setText(i);
            //for(int j = 0; j < 100000; j++){}
        //}
        button_get =(Button) findViewById(R.id.get);
        button_post =(Button) findViewById(R.id.post);
        button_update =(Button) findViewById(R.id.update);
        button_delete =(Button) findViewById(R.id.delete);

        button_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String URL = "https://api-actividades.herokuapp.com/api/users/getAllUsers";

                new AsyncHttpClient().get(URL, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        String str = new String(responseBody);
                        Context CONTEXT =   getApplicationContext();
                        CharSequence TEXT = str;
                        int duracion = Toast.LENGTH_LONG;

                        Toast toast = Toast.makeText(CONTEXT, TEXT, duracion);
                        toast.show();
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        Context CONTEXT =   getApplicationContext();
                        CharSequence TEXT = "Error al conectar GET";
                        int duracion = Toast.LENGTH_LONG;

                        Toast toast = Toast.makeText(CONTEXT, TEXT, duracion);
                        toast.show();
                    }
                });
            }
        });

        button_post.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                RequestParams params = new RequestParams();
                String URL = "https://api-actividades.herokuapp.com/api/users/register";
                params.put("name","lucas");
                params.put("email","lucas@gmail.com");
                params.put("password","12345");
                params.put("phone","9619238165");
                new AsyncHttpClient().post(URL, params, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        String str = new String(responseBody);
                        Context CONTEXT =   getApplicationContext();
                        CharSequence TEXT = str;
                        int duracion = Toast.LENGTH_LONG;

                        Toast toast = Toast.makeText(CONTEXT, TEXT, duracion);
                        toast.show();
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        Context CONTEXT =   getApplicationContext();
                        CharSequence TEXT = "Error al conectar POST";
                        int duracion = Toast.LENGTH_LONG;

                        Toast toast = Toast.makeText(CONTEXT, TEXT, duracion);
                        toast.show();
                    }
                });
            }
        });

        button_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestParams params = new RequestParams();
                String idUser = "20";
                String URL = "https://api-actividades.herokuapp.com/api/users/update/" + idUser;
                params.put("name","Samuel");
                params.put("email","samuel@gmail.com");
                params.put("password","12345");
                params.put("phone","9619373817");

                System.out.println(params);
                System.out.println(URL);

                new AsyncHttpClient().put(getApplicationContext() ,URL, params, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        String str = new String(responseBody);
                        Context CONTEXT =   getApplicationContext();
                        CharSequence TEXT = str;
                        int duracion = Toast.LENGTH_LONG;

                        Toast toast = Toast.makeText(CONTEXT, TEXT, duracion);
                        toast.show();
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        String str = new String(responseBody);
                        Context CONTEXT =   getApplicationContext();
                        CharSequence TEXT = "Error al conectar UPDATE";
                        int duracion = Toast.LENGTH_LONG;
                        System.out.println("error "+error);
                        System.out.println("response"+ str);
                        Toast toast = Toast.makeText(CONTEXT, TEXT, duracion);
                        toast.show();
                    }
                });
            }
        });

        button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestParams params = new RequestParams();
                String URL = "https://api-actividades.herokuapp.com/api/users/delete/";
                String idUser = "21";
                new AsyncHttpClient().delete(URL + idUser, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        String str = new String(responseBody);
                        Context CONTEXT =   getApplicationContext();
                        CharSequence TEXT = str;
                        int duracion = Toast.LENGTH_LONG;

                        Toast toast = Toast.makeText(CONTEXT, TEXT, duracion);
                        toast.show();
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        Context CONTEXT =   getApplicationContext();
                        CharSequence TEXT = "Error al conectar DELETE";
                        int duracion = Toast.LENGTH_LONG;

                        Toast toast = Toast.makeText(CONTEXT, TEXT, duracion);
                        toast.show();
                    }
                });
            }
        });

        Toast.makeText(this,"onCreate", Toast.LENGTH_SHORT).show();
    }

    @Override
    public  void startActivity(Intent intent){
        super.onStart();
        Toast.makeText(this,"onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume(){
        super.onResume();
        Toast.makeText(this,"onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPause(){
        super.onPause();
        Toast.makeText(this,"onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void finish() {
        super.finish();
        Toast.makeText(this,"finish", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Toast.makeText(this,"onDestroy", Toast.LENGTH_SHORT).show();
    }

}
