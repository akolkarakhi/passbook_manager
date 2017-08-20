package com.example.akhilesh.passbook;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ListAccount extends AppCompatActivity {
        DatabaseHelper mydb;
        Button acc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_account);
        mydb=new DatabaseHelper(this);
        acc=(Button)findViewById(R.id.acc);

             ShowData();




    }

    private void ShowData() {
        acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor res= mydb.getAccountName();
                if(res.getCount()==0){
                    showMessage("ERROR","CANT SHOW THE ACCOUNTS");
                }

                StringBuffer Buffer=new StringBuffer();
                while (res.moveToNext()){
                    Buffer.append(""+res.getString(0)+"\n");

                }
                showMessage("Data",Buffer.toString());

            }
        });


    }
    public  void showMessage(String Title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(Title);
        builder.setMessage(Message);
        builder.show();
    }
}
