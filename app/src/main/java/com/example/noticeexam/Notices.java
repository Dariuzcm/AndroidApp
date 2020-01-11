package com.example.noticeexam;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

public class Notices extends AppCompatActivity {

    Button btn_return;
    TextView lbl_Notice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notices);
        lbl_Notice=(TextView)findViewById(R.id.lbl_Noticetext);
        btn_return=(Button) findViewById(R.id.btn_return);
        btn_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MainActivity=new Intent (v.getContext(), MainActivity.class);
                startActivityForResult(MainActivity,0);

                JsonObjectRequest jsonReq = new JsonObjectRequest(Request.Method.GET,
                        "http://notigram.com/wp-json/wp/v2/posts?per_page=30&page=1&_embed",
                        new Response.Listener<JSONObject>(){
                            @Override
                            public void onResponse(JSONObject jsonObject) {
                                lbl_Notice.setText(jsonObject.toString());
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        onConnectionFailed(volleyError.toString());
                    }
                });

                addToQueue(request);
            }
        });
    }
}
