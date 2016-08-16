package co.box.app.ru.www.manipulate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class ActivityEdit extends AllExtends {
    public ConnectNet net = new ConnectNet();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_edit);
        final EditText edtTitle = (EditText)findViewById(R.id.edtTitle);
        final EditText edtDesc = (EditText)findViewById(R.id.edtDesc);
        Button btnMaker = (Button)findViewById(R.id.btnMaker);

        final Bundle bundle = getIntent().getExtras();

        final String webLink = "http://192.168.185.2/onebox/insert?";

        if (bundle!=null) {
            String title = bundle.getString("title");
            String desc = bundle.getString("desc");
            edtTitle.setText(title);
            edtDesc.setText(desc);

        }


        btnMaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = edtTitle.getText().toString();
                String description = edtDesc.getText().toString();

                if (bundle==null) {


                String url = (webLink+"title="+title+"&"+"desc="+description).replace(" ","%20");
                connection(url);
                edtTitle.setText("");
                edtDesc.setText("");
            }else {
                    int id = bundle.getInt("id");


                    String url = ("http://192.168.185.2/onebox/update?id="+id+"&title="+title+"&desc="+description).replace(" ","%20");

                    connection(url);
                }

            }
        });


    }


    private void connection(String url){

        RequestQueue rQueue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("LOG ----- ","EROOOOOOOOOOOOOOOOOR");
            }
        });
        rQueue.add(request);

    }





}