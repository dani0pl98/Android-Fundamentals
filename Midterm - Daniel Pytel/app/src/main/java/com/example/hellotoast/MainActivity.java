package com.example.hellotoast;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = findViewById(R.id.show_count);
        Log.d("tag", "onCreate");

    }

    public void launchSecondActivity(View view) {
        Intent intent = new Intent(this, HelloActivity.class);

        intent.putExtra("message_key", Integer.toString(mCount));
        startActivityForResult(intent, 1);
    }

    public void countUp(View view) {
        mCount++;
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
        }
        Log.d("info", "Counting Up");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("info", "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("info", "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("info", "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("info", "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("info", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("info", "onDestroy");
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String newNum = data.getStringExtra("newCount");
                mCount = Integer.parseInt(newNum);
                mShowCount.setText(Integer.toString(mCount));
            }
        }
    }
}
