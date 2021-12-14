package com.example.proizvodjac_automobila;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        (findViewById(R.id.imageButton)).setOnClickListener(this);
        (findViewById(R.id.Naruci)).setOnClickListener(this);
    }
    public void openActivity2(){
        Intent intent=new Intent(this,Model.class);
        startActivity(intent);
    }

    @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.imageButton:
                    String url="http://www.audi.rs/ ";
                    Intent i=new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                    break;
                case R.id.Naruci:
                    openActivity2();
                    break;

            }
    }
}
