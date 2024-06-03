package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private Button mBtnTextView;
    private Button mBtnButton;
    private Button mBtnEditText;
    private Button mBtnRadioButton;
    private Button mBtnCheckBox;
    private Button mBtnImageView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnTextView=(Button) findViewById(R.id.btn_textview);
        mBtnButton=(Button) findViewById(R.id.btn_button);
        mBtnEditText=(Button) findViewById(R.id.btn_edittext);
        mBtnRadioButton=(Button) findViewById(R.id.btn_radiobutton);
        mBtnCheckBox=(Button) findViewById(R.id.btn_checkbox);
        mBtnImageView=(Button) findViewById(R.id.btn_imageview);

        setListeners();
    }


    private void setListeners(){
        OnClick onClick=new OnClick();
        mBtnTextView.setOnClickListener(onClick);
        mBtnButton.setOnClickListener(onClick);
        mBtnEditText.setOnClickListener(onClick);
        mBtnRadioButton.setOnClickListener(onClick);
        mBtnCheckBox.setOnClickListener(onClick);
        mBtnImageView.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Intent intent = null;
            switch (view.getId()){
                case R.id.btn_textview:
                    //跳转到TextView演示界面
                    intent=new Intent(MainActivity.this, TextViewActivity.class);
                    break;
                case R.id.btn_button:
                    //跳转到EditText演示界面
                    intent=new Intent(MainActivity.this, EditTextActivity.class);
                    break;
                case R.id.btn_edittext:
                    //跳转到EditText演示界面
                    intent=new Intent(MainActivity.this, EditTextActivity.class);
                    break;
                case R.id.btn_radiobutton:
                    //跳转到RadioButton演示界面
                    intent=new Intent(MainActivity.this, RadioButtonActivity.class);
                    break;
                case R.id.btn_checkbox:
                    //跳转到CheckBox演示界面
                    intent=new Intent(MainActivity.this, CheckBoxActivity.class);
                    break;
                case R.id.btn_imageview:
                    //跳转到ImageView演示界面
                    intent=new Intent(MainActivity.this, ImageViewActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}