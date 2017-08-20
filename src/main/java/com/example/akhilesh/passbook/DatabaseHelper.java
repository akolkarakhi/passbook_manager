package com.example.akhilesh.passbook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.StringBuilderPrinter;


public class DatabaseHelper extends SQLiteOpenHelper {


   public static final String DATABASE_NAME="Accounts";//database name
    public static final String ACCOUNTS="Accounts";//Table name
    public static final String COL_1="AccountName";
    public static final String COL_2="CustomerName";
    public static final String COL_3="AccountHolder";
    public static final String COL_4="BankName";
    public static final String COL_5="BranchName";
    public static final String COL_6="BranchAddress";
    public static final String COL_7="Ifsc";
    public static final String COL_8="Micr";
    public static final String COL_9="CurrentBalance";
    public static final String COL_10="Remark";



    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table "+ACCOUNTS+" (AccountName TEXT,CustomerName TEXT,AccountHolder TEXT,BankName TEXT,BranchName TEXT,BranchAddress TEXT,Ifsc TEXT,Micr TEXT,CurrentBalance TEXT,Remark TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST "+ACCOUNTS);

        onCreate(db);
    }

    public boolean insertDataAcc(String AN,String CN,String AH,String BN,String BRN,String BRA,String If,String Mi,String CB,String REM){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentvalues=new ContentValues();
        contentvalues.put(COL_1,AN);
        contentvalues.put(COL_2,CN);
        contentvalues.put(COL_3,AH);
        contentvalues.put(COL_4,BN);
        contentvalues.put(COL_5,BRN);
        contentvalues.put(COL_6,BRA);
        contentvalues.put(COL_7,If);
        contentvalues.put(COL_8,Mi);
        contentvalues.put(COL_9,CB);
        contentvalues.put(COL_10,REM);
            long result = db.insert(ACCOUNTS,null,contentvalues);
        if(result == -1)
        {
            return false;
        }
        else {
            return true;
        }
    }
    public Cursor getAccountName()
    {
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor res=db.rawQuery("Select AccountName from "+ACCOUNTS,null);
        return res;
    }





}
