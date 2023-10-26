package com.example.miumg.db.contract;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
   public static final int DATABASE_VERSION = 1;
   public static  final String DATABASES_NAME = "miumg.db";
   public static SQLiteDatabase.CursorFactory factory = null;

    public DbHelper(Context context){
        super(context, DATABASES_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            db.execSQL(DatosContract.SQL_CREATE_ENTRIES);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(DatosContract.SQL_DELETE_ETRIES);
        onCreate(db);
    }
}
