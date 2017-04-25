package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Thal Marc on 4/4/2017.
 */

public class PetDbHelper extends SQLiteOpenHelper {

    private final static String SQL_CREATE_PET_TABLES = "CREATE TABLE " + PetContract.PetEntry.TABLE_NAME + " ( " +
                                                        PetContract.PetEntry._ID + " INTEGER PRIMARY KEY, " +
                                                        PetContract.PetEntry.COLUMN_PET_NAME + " TEXT, " +
                                                        PetContract.PetEntry.COLUMN_PET_GENRE + " INTEGER, "+
                                                        PetContract.PetEntry.COLUMN_PET_BREED + " TEXT, " +
                                                        PetContract.PetEntry.COLUMN_PET_WEIGHT + " TEXT) ";

    private final static String SQL_DELETE_PET_TABLES = "DROP TABLE IF EXISTS" + PetContract.PetEntry.TABLE_NAME;

    public final static String DATABASE_NAME = "pet.db";
    public final static int DATABASE_VERSION = 1;

    public PetDbHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // When the DB is first create
        sqLiteDatabase.execSQL(SQL_CREATE_PET_TABLES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // When we need to update the DB
        sqLiteDatabase.execSQL(SQL_DELETE_PET_TABLES);
        onCreate(sqLiteDatabase);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }
}
