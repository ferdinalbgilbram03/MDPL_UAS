package com.example.uasmobiledevice;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ActivityResultLauncher<Intent> runLogin = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                TextView txtStatusLogin = findViewById(R.id.etEmail);
                txtStatusLogin.setText(result.toString());
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent intenDataHasil = result.getData();
                    txtStatusLogin.setText(intenDataHasil.getStringExtra("parStatusLogin"));
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void verifikasi(View view) {
        EditText txtEmail = (EditText) findViewById(R.id.etEmail);
        EditText txtPassword = (EditText) findViewById(R.id.etPassword);

        Intent intenPeriksaLogin = new Intent(this, VerifikasiSigninActivity.class);
        intenPeriksaLogin.putExtra("parEmail", txtEmail.getText().toString());
        intenPeriksaLogin.putExtra("parPassword", txtPassword.getText().toString());
        runLogin.launch(intenPeriksaLogin);
    }
}