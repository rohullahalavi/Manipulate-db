package co.box.app.ru.www.manipulate;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


public class ActivityMain extends AllExtends {
    public static final String URL = "http://192.168.185.2/onebox/";
    public static final String TAG = ActivityMain.class.getCanonicalName();
    public static  Handler handler;
    String jsonObject = "Ru-Null (jsonObject)";

    public static ArrayList<StrucNote> notes = new ArrayList<StrucNote>();
    public static ArrayAdapter<StrucNote> adapter = new AdapterNote(notes);

    ConnectNet net = new ConnectNet();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_main);
        Button btnRequest = (Button)findViewById(R.id.btnRequest);

        ListView lstContent = (ListView)findViewById(R.id.lstContent);

        lstContent.setAdapter(adapter);


        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                net.readData(URL);
                Log.i("LOG-iran",notes.size()+"");

            }
        });


        findViewById(R.id.btnNewTask).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActivityMain.this,ActivityEdit.class));
            }
        });



    }



    @Override
    protected void onResume() {
        super.onResume();
        net.readData(URL);
        G.activity=this;
    }





}
