package com.example.helloworld.jump;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.helloworld.R;
import com.example.helloworld.util.ToastUtil;

public class AActivity extends AppCompatActivity {

    private Button mBtnJump;
    private Button mBtnJump2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        Log.d("AActivity", "----onCreate----");
        Log.d("AActivity", "taskid:" + getTaskId() + " ,hash:" + hashCode());
        logtaskName();
        mBtnJump = (Button) findViewById(R.id.jump);
        mBtnJump2 = (Button) findViewById(R.id.jump_2);
        mBtnJump2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AActivity.this, AActivity.class);
                startActivity(intent);
            }
        });
        mBtnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //显示1
                Intent intent = new Intent(AActivity.this, BActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", "安卓");
                bundle.putInt("number", 88);
                intent.putExtras(bundle);
                startActivity(intent);
//                startActivityForResult(intent,0);

                //显示2
//                Intent intent=new Intent();
//                intent.setClass(AActivity.this,BActivity.class);
//                startActivity(intent);

                //显示3
//                Intent intent = new Intent();
//                intent.setClassName(AActivity.this,"com.example.helloworld.jump.BActivity");
//                startActivity(intent);

                //显示4
//                Intent intent = new Intent();
//                intent.setComponent(new ComponentName(AActivity.this, "com.example.helloworld.jump.BActivity"));
//                startActivity(intent);

                //隐式
//                Intent intent = new Intent();
//                intent.setAction("com.example.test.BActivity");//要设置intent-filter
//                startActivity(intent);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(AActivity.this, data.getExtras().getString("title"), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("AActivity", "----onNewIntent----");
        Log.d("AActivity", "taskid:" + getTaskId() + " ,hash:" + hashCode());
        logtaskName();
    }

    private void logtaskName(){
        try {
            ActivityInfo info =getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Log.d("AActivity",info.taskAffinity);
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
