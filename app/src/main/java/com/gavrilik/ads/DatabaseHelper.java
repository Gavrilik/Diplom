package com.gavrilik.ads;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "ads.db"; // название бд
    private static final int SCHEMA = 1; // версия базы данных
    static final String TABLE = "ads"; // название таблицы в бд
    // названия столбцов
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_SELLER_NAME = "seller_name";
    private static final String COLUMN_DESCRIPTION = "description";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE ads (" + COLUMN_ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_SELLER_NAME
                + " TEXT, " + COLUMN_DESCRIPTION + " TEXT);");
        // добавление начальных данных
        db.execSQL("INSERT INTO "+ TABLE +" (" + COLUMN_SELLER_NAME
                + ", " + COLUMN_DESCRIPTION  + ") VALUES ('Валерий', 'Изделия из кожи');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE);
        onCreate(db);
    }
}
