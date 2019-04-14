package com.example.shafi.apimanage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.shafi.apimanage.Adapter.Custom;
import com.example.shafi.apimanage.Network.StudentList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ShowData extends AppCompatActivity {

    private static String URL = "https://api.github.com/users";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
    }

    @Override
    protected void onStart() {
        super.onStart();

        final RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        StringRequest stringRequest = new StringRequest(URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.d("tag",String.valueOf(response) );

                GsonBuilder gsonBuilder =new GsonBuilder();
                Gson gson = gsonBuilder.create();
                StudentList[] studentList =  gson.fromJson(response, StudentList[].class);

                recyclerView.setAdapter(new Custom(ShowData.this, studentList));

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequest);


    }
}
