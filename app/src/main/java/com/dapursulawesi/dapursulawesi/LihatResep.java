package com.dapursulawesi.dapursulawesi;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;



public class LihatResep extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    TextView textViewNo, textViewNama, textViewAsal, textViewBahan, textViewCara;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_resep);

        dbHelper = new DataHelper(this);
        textViewNo = (TextView) findViewById(R.id.textViewNo);
        textViewNama = (TextView) findViewById(R.id.textViewNama);
        textViewAsal = (TextView) findViewById(R.id.textViewAsal);
        textViewBahan = (TextView) findViewById(R.id.textViewBahan);
        textViewCara = (TextView) findViewById(R.id.textViewCara);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM resep WHERE nama = '" +
                getIntent().getStringExtra("nama") + "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            textViewNo.setText(cursor.getString(0).toString());
            textViewNama.setText(cursor.getString(1).toString());
            textViewAsal.setText(cursor.getString(2).toString());
            textViewBahan.setText(cursor.getString(3).toString());
            textViewCara.setText(cursor.getString(4).toString());
        }

    }


}
