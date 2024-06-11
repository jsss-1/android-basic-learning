package com.example.helloworld.anim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.helloworld.R;

public class ObjectAnimActivity extends AppCompatActivity {

    private TextView tvTest;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_anim);

        tvTest = (TextView) findViewById(R.id.tv);

        //Y方向平移
//        tvTest.animate().translationYBy(500).setDuration(2000).start();

        //背景由黑变白
//        tvTest.animate().alpha(0).setDuration(2000).start();

//        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 100);
//        valueAnimator.setDuration(2000);
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(@NonNull ValueAnimator animation) {
//                //valueAnimator 实际的值
//                Log.d("aaaa", animation.getAnimatedValue() + "");
//                //动画的进度0-1
//                Log.d("aaaa", animation.getAnimatedFraction() + "");
//            }
//        });
//        valueAnimator.start();

        //沿Y方向从0到500到200再到800
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(tvTest, "translationY", 0, 500,200,800);
        objectAnimator.setDuration(2000);
        objectAnimator.start();
    }
}