package com.example.uasmobiledevice;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class ProfilActivity extends AppCompatActivity {
    private Button btnPendidikan, btnKeahlian, btnPengalaman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        btnPendidikan = findViewById(R.id.btnPendidikan);
        btnKeahlian = findViewById(R.id.btnKeahlian);
        btnPengalaman = findViewById(R.id.btnPengalaman);

        btnPendidikan.setOnClickListener(view -> {
            FragmentManager frManager = getSupportFragmentManager();
            FragmentTransaction frTransaction = frManager.beginTransaction();
            frTransaction.replace(R.id.container, new PendidikanFragment());
            frTransaction.commit();
        });

        btnKeahlian.setOnClickListener(view -> {
            FragmentManager frManager = getSupportFragmentManager();
            FragmentTransaction frTransaction = frManager.beginTransaction();
            frTransaction.replace(R.id.container, new KeahlianFragment());
            frTransaction.commit();
        });

        btnPengalaman.setOnClickListener(view -> {
            FragmentManager frManager = getSupportFragmentManager();
            FragmentTransaction frTransaction = frManager.beginTransaction();
            frTransaction.replace(R.id.container, new PengalamanFragment());
            frTransaction.commit();
        });
    }
}


