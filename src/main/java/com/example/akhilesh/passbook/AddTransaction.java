package com.example.akhilesh.passbook;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;


public class AddTransaction extends AppCompatActivity {
    DBHelperTran mydb;
    EditText Acc,Date,Amou,Rem,CCD,DeWi;
    Button Addtra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transaction);
        mydb=new DBHelperTran(this);

        Acc = (EditText) findViewById(R.id.Acc);
        CCD =(EditText)findViewById(R.id.CCD);
        Date = (EditText) findViewById(R.id.Date);
        Amou = (EditText) findViewById(R.id.Amou);
        DeWi= (EditText) findViewById(R.id.DeWi);
        Rem = (EditText) findViewById(R.id.Rem);


        Addtra=(Button)findViewById(R.id.AddTra);

        Addtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // values are going to added into the transaction table

                    boolean isInserted;
                isInserted = mydb.InsertDataTra(Acc.getText().toString(), DeWi.getText().toString(), Amou.getText().toString(), CCD.getText().toString(), Rem.getText().toString(), Date.getText().toString());
                //toast message after adding transaction
                    if(isInserted) {
                        Toast.makeText(getApplicationContext(), "Transaction Added Successfully", LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Unable Add Transaction", LENGTH_LONG).show();
                    }
                Intent Main = new Intent(AddTransaction.this,MainActivity.class);
                AddTransaction.this.startActivity(Main);

            }
        });

    }
}
