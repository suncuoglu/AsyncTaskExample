package com.texttospeech.example.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    TextView t_name,t_mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_layout);
        t_mail=findViewById(R.id.t_email);
        t_name=findViewById(R.id.t_name);
    ViewModel data = getIntent().getExtras().getParcelable("data");
    t_name.setText(data.getName());
    t_mail.setText(data.getMail());

        

    }
}
