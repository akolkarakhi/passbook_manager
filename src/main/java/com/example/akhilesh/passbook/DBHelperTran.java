package com.example.akhilesh.passbook;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.akhilesh.passbook.DatabaseHelper.DATABASE_NAME;

import static com.example.akhilesh.passbook.DatabaseHelper.DATABASE_NAME;

/**
 * Created by Akhilesh on 4/16/2017.
 */

public class DBHelperTran extends SQLiteOpenHelper {
    DatabaseHelper db;

    public static final String TRANSACTION="Transaction";
    public static final String COL_1="Accout";
    public static final String COL_2="Deposite/Withdraw";
    public static final String COL_3="Amount";
    public static final String COL_4="Cash/Cheque/Draft";
    public static final String COL_5="Rem";
    public static final String COL_6="Date";

    DBHelperTran(Context context) {
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table "+TRANSACTION+"(Account TEXT,DeWi TEXT,Amount TEXT,Cash/Cheque/Draft TEXT,Remark TEXT,Date TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST "+TRANSACTION);
    }


        public boolean InsertDataTra(String Acc,String depowith,String amount,String CCD,String REM,String date){
            SQLiteDatabase db=this.getWritableDatabase();
            ContentValues contentvalues=new ContentValues();
            contentvalues.put(COL_1,Acc);
            contentvalues.put(COL_2,depowith);
            contentvalues.put(COL_3,amount);
            contentvalues.put(COL_4,CCD);
            contentvalues.put(COL_5,REM);
            contentvalues.put(COL_6,date);
            long result = db.insert(TRANSACTION,null,contentvalues);
            if(result == -1)
            {
                return false;
            }
            else
            {
                return true;
            }
        }

    }


