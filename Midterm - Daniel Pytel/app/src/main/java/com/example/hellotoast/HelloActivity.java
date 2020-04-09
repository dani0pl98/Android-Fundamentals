package com.example.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HelloActivity extends AppCompatActivity {
private String mcount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);

        Intent intent = getIntent();
        mcount = intent.getStringExtra("message_key");
        TextView textView = findViewById(R.id.text_count);
        textView.setText(mcount);

    }

    public void doubleCount(View view) {
        int doubled = Integer.parseInt(mcount);
        int result = doubled * 2;
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("newCount", Integer.toString(result));
        setResult(RESULT_OK, intent);
        finish();

    }
}
