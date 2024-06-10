package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.helloworld.datastorage.DataStorageActivity;

public class MainActivity extends AppCompatActivity {

    private Button mBtnUI;
    private Button mBtnEvent;
    private Button mBtnData;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnUI = (Button) findViewById(R.id.btn_ui);
        mBtnEvent = (Button) findViewById(R.id.btn_event);
        mBtnData = (Button) findViewById(R.id.btn_data);
        OnClick onClick = new OnClick();
        mBtnUI.setOnClickListener(onClick);
        mBtnEvent.setOnClickListener(onClick);
        mBtnData.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = null;
            switch (view.getId()) {
                case R.id.btn_ui:
                    intent=new Intent(MainActivity.this, UIActivity.class);
                    break;
                case R.id.btn_event:
                    intent=new Intent(MainActivity.this, EventActivity.class);
                    break;
                case R.id.btn_data:
                    intent=new Intent(MainActivity.this, DataStorageActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}