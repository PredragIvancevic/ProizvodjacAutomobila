package com.example.proizvodjac_automobila;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Model extends AppCompatActivity  {
    private static final int request_code=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model);

        (findViewById(R.id.Prosledi)).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        RadioGroup RG1 = (RadioGroup) findViewById(R.id.RG1);
        RadioGroup RG2=(RadioGroup)findViewById(R.id.RG2);
        int RadioId=RG1.getCheckedRadioButtonId();
        int RadioId1=RG2.getCheckedRadioButtonId();
       Button radioButton=(Button)findViewById(RadioId);
       Button radioButton1=(Button)findViewById(RadioId1);
       String text=radioButton.getText().toString();
       String text1=radioButton1.getText().toString();
        CheckBox CB1=(CheckBox)findViewById(R.id.CB1);
        CheckBox CB2=(CheckBox)findViewById(R.id.CB2);
       switch(text){
           case "A5":
               Intent i=new Intent(Model.this,A5.class);
               Bundle extra1=new Bundle();
               StringBuffer rezultat=new StringBuffer();
               if(CB1.isChecked()){
                   rezultat.append(CB1.getText().toString()+" ");
               }
               if(CB2.isChecked()){
                   rezultat.append(CB2.getText().toString());
               }
               extra1.putString("AUDI",text);
               extra1.putString("GORIVO",text1);
               extra1.putString("OPREMA",rezultat.toString());
               i.putExtras(extra1);
               startActivity(i);
               break;
           case "A4":
                   Intent intent=new Intent(Model.this,A4.class);
                   Bundle extra=new Bundle();
                   StringBuffer result=new StringBuffer();
                   if(CB1.isChecked()){
                       result.append(CB1.getText().toString()+" ");
                   }
                   if(CB2.isChecked()){
                       result.append(CB2.getText().toString());
                   }
                   extra.putString("AUDI",text);
                   extra.putString("GORIVO",text1);
                   extra.putString("OPREMA",result.toString());
                   intent.putExtras(extra);
                   startActivity(intent);
                   break;

           }
       }
    }
);
        Bundle extras=getIntent().getExtras();
        if(extras!=null){
        String extra=extras.getString("MODEL");
        if(!extra.isEmpty()){
        TextView labela=(TextView)findViewById(R.id.nova);
        labela.setText(extra);
            RadioGroup RG1 = (RadioGroup) findViewById(R.id.RG1);
        switch (labela.getText().toString()) {
            case "A5":
            RG1.check(R.id.rb2);
            break;
            case "A4":
                RG1.check(R.id.rb1);
                break;
            case "Nova narudzbina-A4":
                RG1.check(R.id.rb1);
                break;
            case "Nova narudzbina-A5":
                RG1.check(R.id.rb2);
                break;
            case "Nova narudžbina-A5":
                RG1.check(R.id.rb2);
                break;
            case "Nova narudžbina-A4":
                RG1.check(R.id.rb1);
                break;


        }
            }
        }
            }

        }





