package co.box.app.ru.www.manipulate;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;



public class AdapterNote extends ArrayAdapter<StrucNote> {
    public AdapterNote (ArrayList<StrucNote> array){
        super(G.context,R.layout.adapter_note,array);
    }

    public static class ViewHolder {
        TextView txtTitle;
        TextView txtDescription;
        Button btnDlete;
        LinearLayout layoutC;
        public ViewHolder (View view){
            txtTitle       = (TextView)view.findViewById(R.id.txtTitle);
            txtDescription = (TextView)view.findViewById(R.id.txtDescription);
            btnDlete = (Button)view.findViewById(R.id.btnDelete);
            layoutC = (LinearLayout)view.findViewById(R.id.layoutC);
        }

        public void fill(final ArrayAdapter<StrucNote> adapter, final StrucNote item, int position){

            txtTitle.setText(item.getTitle());
            txtDescription.setText(item.getDescription());
            layoutC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(G.activity,ActivityEdit.class);

                    intent.putExtra("title",item.getTitle());
                    intent.putExtra("desc",item.getDescription());
                    intent.putExtra("id",item.getId());

                    G.activity.startActivity(intent);
                }
            });
            btnDlete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String title = item.getTitle();
                    String url = ("http://192.168.0.13/onebox/delete?title="+title).replace(" ","%20");

//                    =============================================

                    RequestQueue rQueue = Volley.newRequestQueue(G.context);
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

//                    =============================================
                    adapter.remove(item);
                }
            });

        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        StrucNote item = getItem(position);
        if (convertView == null) {
            convertView = G.inflater.inflate(R.layout.adapter_note,parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }
        holder.fill(this,item,position);
        return convertView;
    }



}

