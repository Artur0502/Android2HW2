package com.example.hw6;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.dz_6_ms_2.R;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private TextView tvLogIn;
    private EditText etEmail, etPassword;
    private MaterialButton btnLogIn;
    private ConstraintLayout cl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvLogIn = findViewById(R.id.tv_login);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        btnLogIn = findViewById(R.id.btn_log_in);
        cl = findViewById(R.id.cl);
        etEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (etEmail.getText().toString().length() >= 1 && etPassword.getText().toString().length() >= 1) {
                    btnLogIn.setBackgroundColor(Color.parseColor("#E89020"));
                } else {
                    btnLogIn.setBackgroundColor(Color.parseColor("#E9838080"));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (etPassword.getText().toString().length() >= 1 && etEmail.getText().toString().length() >= 1) {
                    btnLogIn.setBackgroundColor(Color.parseColor("#E89020"));
                } else {
                    btnLogIn.setBackgroundColor(Color.parseColor("#E9838080"));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etEmail.getText().toString().equals("admin") && etPassword.getText().toString().equals("admin")) {
                    Toast.makeText(MainActivity.this, "Вы успешно вошли!", Toast.LENGTH_SHORT).show();
                    cl.setVisibility(View.INVISIBLE);
                    tvLogIn.setVisibility(View.INVISIBLE);
                } else {
                    Toast.makeText(MainActivity.this, "Неверный логин или пароль!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}