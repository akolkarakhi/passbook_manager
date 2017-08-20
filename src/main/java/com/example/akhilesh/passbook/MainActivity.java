package com.example.akhilesh.passbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button addtra,addacc,sertra,listacc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addacc= (Button)findViewById(R.id.addac);
        Button addtra=(Button)findViewById(R.id.addtra);
        Button sertra=(Button)findViewById(R.id.sertra);
        Button listacc=(Button)findViewById(R.id.Listacc);

        addacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addacc = new Intent(MainActivity.this, AddAcount.class);
                MainActivity.this.startActivity(addacc);
            }
        });

        addtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addtra = new Intent(MainActivity.this, AddTransaction.class);
                MainActivity.this.startActivity(addtra);

            }
        });

        sertra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sertra = new Intent(MainActivity.this, SearchTransaction.class);
                MainActivity.this.startActivity(sertra);
            }
        });

        listacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listacc = new Intent(MainActivity.this, ListAccount.class);
                MainActivity.this.startActivity(listacc);

            }
        });


    }
}
