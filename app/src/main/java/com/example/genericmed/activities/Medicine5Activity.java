package com.example.genericmed.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.genericmed.R;
import com.example.genericmed.adapters.RecyclerViewAdapter;
import com.example.genericmed.model.Med;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Medicine5Activity extends AppCompatActivity {

    public final String JSON_URL = "https://api.myjson.com/bins/c6b58" ;
    public JsonArrayRequest request ;
    public RequestQueue requestQueue ;
    private List<Med> lstMed;
    private RecyclerView recyclerView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine5);

        lstMed = new ArrayList<>() ;
        recyclerView = findViewById(R.id.recyclerviewid);
        jsonrequest();
    }

    private void jsonrequest() {

        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject  = null ;

                for (int i = 0 ; i < response.length(); i++ ) {

                    try {
                        jsonObject = response.getJSONObject(i) ;
                        Med med = new Med() ;
                        med.setName(jsonObject.getString("name"));
                        med.setDescription(jsonObject.getString("description"));
                        med.setRating(jsonObject.getString("rating"));
                        med.setCompany(jsonObject.getString("company"));
                        med.setPrice(jsonObject.getString("price"));
                        med.setImage_url(jsonObject.getString("img"));
                        lstMed.add(med);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

                setuprecyclerview(lstMed);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue = Volley.newRequestQueue(Medicine5Activity.this);
        requestQueue.add(request) ;
    }

    private void setuprecyclerview(List<Med> lstMed) {

        RecyclerViewAdapter myadapter = new RecyclerViewAdapter(this,lstMed) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myadapter);

    }
}
