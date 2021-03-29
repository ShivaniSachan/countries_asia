package com.example.countries_asia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.ReferenceQueue;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

   private static final String URL_DATA ="https://restcountries.eu/rest/v2/all";
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView= (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();

        loadRecyclerViewData();

}

      private  void loadRecyclerViewData(){
          ProgressDialog progressDialog = new ProgressDialog(this);
          progressDialog.setMessage("Loading data......");
          progressDialog.show();

          RequestQueue requestQueue = Volley.newRequestQueue(this);
          JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL_DATA,
                  new Response.Listener<JSONArray>() {
                      @Override
                      public void onResponse(JSONArray response) {
                          for (int i = 0; i < response.length(); i++) {
                              try {
                                  JSONObject obj = response.getJSONObject(i);
                                  String region = obj.getString("region");
                                  if(region.equals("Asia")){
                                      String co = obj.getString("name");
                                      String capital = obj.getString("capital");
                                      String subregion = obj.getString("subregion");
                                      String population = obj.getString("population");
                                      String borders = obj.getString("borders");
                                      String languages = obj.getString("languages");



                                      String flag = obj.getString("flag");
                                      Log.d("country", flag);
                                      ListItem item = new ListItem(
                                              co,
                                              capital,
                                              subregion,
                                              population,
                                              borders,
                                              languages,
                                              flag
                                      );

                                      listItems.add(item);

                                  }
                                  progressDialog.dismiss();
                                  adapter= new MyAdapter(listItems,getApplicationContext());
                                  recyclerView.setAdapter(adapter);

                              } catch (JSONException e) {
                                  e.printStackTrace();
                              }
                          }
                      }
                  },
                  new Response.ErrorListener()
                  {
                      @Override
                      public void onErrorResponse(VolleyError error) {
                          // error
                          Log.d("country", error.getMessage());
                      }
                  }
                  );
          requestQueue.add(jsonArrayRequest);

                      /*
          StringRequest stringRequest = new StringRequest(Request.Method.GET,
                  URL_DATA,
                  new Response.Listener<String>() {
                      @Override
                      public void onResponse(String s) {
                          progressDialog.dismiss();
                          try {
                              JSONObject jsonObject = new JSONObject(s);
                              JSONArray array = jsonObject.getJSONArray("");

                              for(int i=0;i<s.length();i++){
                                 String s1 =s.getJSONObject(i).getJSONObject("line").getJSONObject("translation").getJSONObject("english");
                              }

                              for (int i = 0 ; i<array.length(); i++){

                                  JSONObject o = array.getJSONObject(i);
                                  ListItem item = new ListItem(
                                          o.getString("name"),
                                          o.getString("capital"),
                                          o.getString("flag")
                                  );

                                  listItems.add(item);
                              }
                              adapter= new MyAdapter(listItems,getApplicationContext());
                              recyclerView.setAdapter(adapter);

                          } catch (JSONException e) {
                              e.printStackTrace();
                          }

                      }
                  },
                  new Response.ErrorListener() {
                      @Override
                      public void onErrorResponse(VolleyError error) {
                          progressDialog.dismiss();
                          Toast.makeText(getApplicationContext(),error.getMessage(), Toast.LENGTH_LONG).show();

                      }

      });

                       */





}}