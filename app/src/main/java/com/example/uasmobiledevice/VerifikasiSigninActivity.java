package com.example.uasmobiledevice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class VerifikasiSigninActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifikasi_signin);

        Intent intenAmbilData = getIntent();

        String strEmail = intenAmbilData.getStringExtra("parEmail");
        String strPassword = intenAmbilData.getStringExtra("parPassword");
        if(strEmail.equals("ferdinal@gmail.com")) {
            if(strPassword.equals("03062003")) {
                Intent intenHasilLogin = new Intent(VerifikasiSigninActivity.this, ProfilActivity.class);
                intenHasilLogin.putExtra("parStatusLogin", "");
                setResult(RESULT_OK,intenHasilLogin);
                startActivity(intenHasilLogin);
            }
            else {
                // Menampilkan toast jika password login salah
                Toast.makeText(getApplicationContext(), "Password SALAH!", Toast.LENGTH_SHORT).show();
                Intent intenHasilLogin = new Intent();
                intenHasilLogin.putExtra("parStatusLogin", "");
                setResult(RESULT_OK, intenHasilLogin);
                finish();
            }
        }
        else {
            // Menampilkan toast jika login tidak diisi
            Toast.makeText(getApplicationContext(), "Input KOSONG!", Toast.LENGTH_SHORT).show();
            Intent intenHasilLogin = new Intent();
            intenHasilLogin.putExtra("parStatusLogin", "");
            setResult(RESULT_OK, intenHasilLogin);
            finish();
        }
    }
}