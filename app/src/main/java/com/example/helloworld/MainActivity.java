package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.helloworld.broadcast.BroadActivity;
import com.example.helloworld.datastorage.DataStorageActivity;

public class MainActivity extends AppCompatActivity {

    private Button mBtnUI;
    private Button mBtnEvent;
    private Button mBtnData;
    private Button mBtnBroad;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnUI = (Button) findViewById(R.id.btn_ui);
        mBtnEvent = (Button) findViewById(R.id.btn_event);
        mBtnData = (Button) findViewById(R.id.btn_data);
        mBtnBroad = (Button) findViewById(R.id.btn_broad);
        OnClick onClick = new OnClick();
        mBtnUI.setOnClickListener(onClick);
        mBtnEvent.setOnClickListener(onClick);
        mBtnData.setOnClickListener(onClick);
        mBtnBroad.setOnClickListener(onClick);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
    }

    class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = null;
            switch (view.getId()) {
                case R.id.btn_ui:
                    intent = new Intent(MainActivity.this, UIActivity.class);
                    break;
                case R.id.btn_event:
                    intent = new Intent(MainActivity.this, EventActivity.class);
                    break;
                case R.id.btn_data:
                    intent = new Intent(MainActivity.this, DataStorageActivity.class);
                    break;
                case R.id.btn_broad:
                    intent = new Intent(MainActivity.this, BroadActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}