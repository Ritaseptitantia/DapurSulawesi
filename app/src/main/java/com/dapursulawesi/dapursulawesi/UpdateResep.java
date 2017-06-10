package com.dapursulawesi.dapursulawesi;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateResep extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button btnUpdate;
    EditText editTextNo, editTextNama, editTextAsal, editTextBahan, editTextCara;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_resep);

        dbHelper = new DataHelper(this);
        editTextNo = (EditText) findViewById(R.id.editTextNo);
        editTextNama = (EditText) findViewById(R.id.editTextNama);
        editTextAsal = (EditText) findViewById(R.id.editTextAsal);
        editTextBahan = (EditText) findViewById(R.id.editTextBahan);
        editTextCara = (EditText) findViewById(R.id.editTextCara);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM resep WHERE nama = '" +
                getIntent().getStringExtra("nama") + "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            editTextNo.setText(cursor.getString(0).toString());
            editTextNama.setText(cursor.getString(1).toString());
            editTextAsal.setText(cursor.getString(2).toString());
            editTextBahan.setText(cursor.getString(3).toString());
            editTextCara.setText(cursor.getString(4).toString());
        }
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        // daftarkan even onClick pada btnSimpan
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("update resep set nama='"+
                        editTextNama.getText().toString() +"', asal='" +
                        editTextAsal.getText().toString() +"', bahan='" +
                        editTextBahan.getText().toString()+"', cara='"+
                        editTextCara.getText().toString() +"' where no='" +
                        editTextNo.getText().toString()+"'");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                MainActivity.ma.RefreshList();
                finish();
            }
        });

    }

}