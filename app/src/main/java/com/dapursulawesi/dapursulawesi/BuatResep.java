package com.dapursulawesi.dapursulawesi;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class BuatResep extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button btnSimpan;
    EditText editTextNo, editTextNama, editTextAsal, editTextBahan, editTextCara;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_resep2);

        dbHelper = new DataHelper(this);
        editTextNo = (EditText) findViewById(R.id.editTextNo);
        editTextNama = (EditText) findViewById(R.id.editTextNama);
        editTextAsal = (EditText) findViewById(R.id.editTextAsal);
        editTextBahan = (EditText) findViewById(R.id.editTextBahan);
        editTextCara = (EditText) findViewById(R.id.editTextCara);
        btnSimpan = (Button) findViewById(R.id.btnSimpan);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into resep (no, nama, asal, bahan, cara) values('" +
                        editTextNo.getText().toString()+"','"+
                        editTextNama.getText().toString() +"','" +
                        editTextAsal.getText().toString()+"','"+
                        editTextBahan.getText().toString() +"','" +
                        editTextCara.getText().toString() + "')");
                Toast.makeText(getApplicationContext(), "Berhasil",
                        Toast.LENGTH_LONG).show();
                MainActivity.ma.RefreshList();
                finish();
            }
        });

    }


}
