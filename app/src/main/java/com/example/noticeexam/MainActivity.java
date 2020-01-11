package com.example.noticeexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {


    EditText tb_pass;
    EditText tb_username;
    Button btn_login;
    CheckBox chk_recuerdame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    //--------------------------------------------------------------------------------
         tb_pass =(EditText) this.findViewById(R.id.tb_pass);
         tb_username =(EditText) this.findViewById(R.id.tb_username);
         btn_login=(Button) findViewById(R.id.btn_login);
         chk_recuerdame=(CheckBox)findViewById(R.id.chk_recordar);
         btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(verify(tb_username.getText().toString(),tb_pass.getText().toString())){
                    Intent NoticeActivity=new Intent (v.getContext(), Notices.class);
                    startActivityForResult(NoticeActivity,0);
                }

            }
        });

    }

    private boolean verify(String username, String pass) {
        if(username.equalsIgnoreCase("Anonimo") && pass.equals("asdc"))
        {
            return true;
        }
        else{
            return false;
        }
    }

}
