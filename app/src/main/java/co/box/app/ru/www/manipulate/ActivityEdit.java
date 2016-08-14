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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class ActivityEdit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_edit);
        final EditText edtTitle = (EditText)findViewById(R.id.edtTitle);
        final EditText edtDesc = (EditText)findViewById(R.id.edtDesc);
        Button btnRequest = (Button) findViewById(R.id.btnRequest);

        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = ("http://192.168.0.13/onebox/insert?"+"title="+edtTitle.getText().toString()+"&"+"desc=" + edtDesc.getText().toString()).replace(" ","%20");
                Log.i("LOG",url);
                connection(url);
                edtTitle.setText("");
                edtDesc.setText("");
            }
        });

    }
    private void connection(String url){

        RequestQueue rQueue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            Log.i("LOG ----- ",response);

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
