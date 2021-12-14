package com.example.proizvodjac_automobila;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class A4 extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a4);
        Bundle extras = getIntent().getExtras();
        String text=extras.getString("AUDI");
        String text1=extras.getString("GORIVO");
        TextView Model=(TextView)findViewById(R.id.textView1);
        TextView DodatnaOprema=(TextView)findViewById(R.id.textView2);
        String oprema=extras.getString("OPREMA");
        Model.setText(" "+getString(R.string.model)+" " + text+" " + text1);
        DodatnaOprema.setText(" "+getString(R.string.oprema)+" "+oprema);
        (findViewById(R.id.Posalji1)).setOnClickListener(this);
        (findViewById(R.id.VratiSe)).setOnClickListener(this);
        (findViewById(R.id.Zavrsi)).setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Posalji1:
                RadioGroup RG4=(RadioGroup)findViewById(R.id.RG4);
                int RadioId=RG4.getCheckedRadioButtonId();
                Button RadioButton=(Button)findViewById(RadioId);
                String text=RadioButton.getText().toString();
                Toast.makeText(A4.this,getString(R.string.Toast1)+" " + text + " "+getString(R.string.Toast2),Toast.LENGTH_LONG).show();
                break;
            case R.id.VratiSe:
                EditText izborModela=(EditText)findViewById(R.id.NoviModel);
                String model=izborModela.getText().toString();

                    Intent intent = new Intent(A4.this, Model.class);
                    Bundle extra = new Bundle();
                    extra.putString("MODEL", model);
                    intent.putExtras(extra);
                    startActivity(intent);
                    break;

            case R.id.Zavrsi:
                Intent i = new Intent(Intent.ACTION_MAIN);
                i.addCategory(Intent.CATEGORY_HOME);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                break;
        }
    }
}
