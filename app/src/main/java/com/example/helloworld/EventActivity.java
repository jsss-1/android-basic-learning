package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.helloworld.util.ToastUtil;
import com.example.helloworld.widget.MyButton;

public class EventActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mBtnEvent;
    private MyButton btnMy;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        mBtnEvent=(Button) findViewById(R.id.btn_event);
        btnMy=(MyButton) findViewById(R.id.btn_my);
        btnMy.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        Log.d("Listener","---onTouch---");
                        break;
                }
                return false;
            }
        });
        //内部类实现
        mBtnEvent.setOnClickListener(new OnClick());
//        //匿名内部类
//        mBtnEvent.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d("匿名内部类","click");
//                ToastUtil.showMsg(EventActivity.this,"click...");
//            }
//        });
//        //通过事件源所在的类实现
//        mBtnEvent.setOnClickListener(EventActivity.this);
//        //通过外部类
//        mBtnEvent.setOnClickListener(new MyClickListener(EventActivity.this));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_event:
                ToastUtil.showMsg(EventActivity.this,"click...");
                break;
        }
    }

    class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_event:
                    Log.d("内部类","click");
                    ToastUtil.showMsg(EventActivity.this,"click...");
                    break;
            }
        }
    }

    //android:onClick="show"
    public void show(View v){
        switch (v.getId()){
            case R.id.btn_event:
                Log.d("布局","click");
                ToastUtil.showMsg(EventActivity.this,"click...");
                break;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d("Activity","---onTouchEvent---");
                break;
        }
        return false;
    }
}