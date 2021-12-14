package com.example.proizvodjac_automobila;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class A5 extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a5);
        Bundle extra = getIntent().getExtras();
        String text = extra.getString("AUDI");
        String text1 = extra.getString("GORIVO");
        TextView Model = (TextView) findViewById(R.id.textView11);
        TextView DodatnaOprema = (TextView) findViewById(R.id.textView22);
        String oprema = extra.getString("OPREMA");
        Model.setText(" " + getString(R.string.model) + " " + text + " " + text1);
        DodatnaOprema.setText(" " + getString(R.string.oprema) + " " + oprema);
        (findViewById(R.id.Posalji2)).setOnClickListener(this);
        (findViewById(R.id.VratiSe1)).setOnClickListener(this);
        (findViewById(R.id.Zavrsi1)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.Posalji2:
                RadioGroup RG5 = (RadioGroup) findViewById(R.id.RG5);
                int RadioId = RG5.getCheckedRadioButtonId();
                Button RadioButton = (Button) findViewById(RadioId);
                String text = RadioButton.getText().toString();
                Toast.makeText(A5.this, getString(R.string.Toast1)+" " + text + " "+getString(R.string.Toast2), Toast.LENGTH_LONG).show();
                break;


            case R.id.VratiSe1:
                EditText izborModela1 = (EditText) findViewById(R.id.izborModela1);
                String model =izborModela1.getText().toString();
                Intent intent = new Intent(A5.this, Model.class);
                Bundle extra = new Bundle();
                extra.putString("MODEL", model);
                intent.putExtras(extra);
                startActivity(intent);
                break;

            case R.id.Zavrsi1:
                Intent i = new Intent(Intent.ACTION_MAIN);
                i.addCategory(Intent.CATEGORY_HOME);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                break;

        }
    }
}
