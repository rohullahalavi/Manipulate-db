package co.box.app.ru.www.manipulate;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public  class ConnectNet  {



    public void readData(String url){


        RequestQueue connection = Volley.newRequestQueue(G.context);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(final String response) {

                        try {
                            JSONArray jArray = new JSONArray(response);
                            ActivityMain.notes.clear();
                            for (int i=0;i<jArray.length();i++) {
                                StrucNote note = new StrucNote();
                                JSONObject object = jArray.getJSONObject(i);
                                note.setTitle(object.getString("title"));
                                note.setDescription(object.getString("desc"));
                                note.setId(object.getInt("id"));
                                ActivityMain.notes.add(note);
                            }
                            ActivityMain.adapter.notifyDataSetChanged();


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }



                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        connection.add(stringRequest);

    }




}
