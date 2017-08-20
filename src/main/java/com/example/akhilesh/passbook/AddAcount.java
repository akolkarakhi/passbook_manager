package com.example.akhilesh.passbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

public class AddAcount extends AppCompatActivity {
    DatabaseHelper mydb;
    Button AddBt;
    EditText AccName,CustName,AccHold,BankName,BraName,BraAdd,Ifsc,Micr,CurrBal,Rem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_acount);

        mydb=new DatabaseHelper(this);

        AccName = (EditText) findViewById(R.id.AccName);
        CustName = (EditText) findViewById(R.id.CustName);
        AccHold = (EditText) findViewById(R.id.AccHold);
        BankName = (EditText) findViewById(R.id.BankName);
        BraName = (EditText) findViewById(R.id.BraName);
        BraAdd = (EditText) findViewById(R.id.BraAdd);
        Ifsc = (EditText) findViewById(R.id.Ifsc);
        Micr = (EditText) findViewById(R.id.Micr);
        CurrBal = (EditText) findViewById(R.id.CurrBal);
        Rem = (EditText) findViewById(R.id.Rem);

        AddBt = (Button) findViewById(R.id.AddBt);

                    AddBt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //values are going to insert into tables
                Boolean isInserted= mydb.insertDataAcc(AccName.getText().toString(),CustName.getText().toString(),AccHold.getText().toString(),BankName.getText().toString(),BraName.getText().toString(),BraAdd.getText().toString(),Ifsc.getText().toString(),Micr.getText().toString(),CurrBal.getText().toString(),Rem.getText().toString());

                //toast message after adding account
                if(isInserted) {
                    Toast.makeText(getApplicationContext(), "Account Added Successfully", LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Unable Add Account", LENGTH_LONG).show();
                }

                Intent Main = new Intent(AddAcount.this,MainActivity.class);
                AddAcount.this.startActivity(Main);
            }
        });
    }
}
