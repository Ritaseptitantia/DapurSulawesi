package com.dapursulawesi.dapursulawesi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "resep.db";
    private static final int DATABASE_VERSION = 1;
    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        String sql = "create table resep(no integer primary key, nama text null, asal text null, bahan text null, cara text null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);

        sql = "INSERT INTO resep (no, nama, asal, bahan, cara) VALUES('8','Golla Kambu','Sulawesi Barat','150 gram beras ketan, diamkan 1 jam.\n" +
                "150 gram gula merah.\n" +
                "150 ml air 100 gram kelapa parut kasar.\n" +
                "70 ml air ¼ sendok teh garam.\n" +
                "50 gram kacang tanah kupas, disangrai, dicincang kasar.\n" +
                "Daun pisang kering untuk membungkus','1. Kukus beras ketan selama 30 menit.\n" +
                "2. Masak 70 ml air. Masukkan beras ketan dan garam. Aduk hingga meresap, sisihkan.\n" +
                "3. Rebus gula merah hingga larut. Saring. \n" +
                "4. Masak lagi hingga mendidih. \n" +
                "5. Masukkan beras ketan dan kelapa. \n" +
                "6. Aduk rata hingga meresap. \n" +
                "7. Tambahkan kacang. \n" +
                "8. Aduk sebentar lalu angkat.');";

        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub

    }

}
