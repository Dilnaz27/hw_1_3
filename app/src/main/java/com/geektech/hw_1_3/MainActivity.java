package com.geektech.hw_1_3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private EditText email;
    private EditText theme;
    private EditText text;
    private MaterialButton button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initView() {
        email = findViewById(R.id.et_email);
        theme = findViewById(R.id.et_theme);
        text = findViewById(R.id.et_text);
        button= findViewById(R.id.btn_send);
    }

    private void initListener() {
        button.setOnClickListener(view -> {
            final Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("plain/text");

            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email.getText().toString()});

            intent.putExtra(Intent.EXTRA_SUBJECT, theme.getText().toString());

            intent.putExtra(Intent.EXTRA_TEXT, text.getText().toString());
            startActivity(intent);
        });
    }
}