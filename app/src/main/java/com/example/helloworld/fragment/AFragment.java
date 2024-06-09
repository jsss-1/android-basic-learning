package com.example.helloworld.fragment;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.example.helloworld.R;

public class AFragment extends Fragment {

    private TextView mTvTitle;
    private Button mBtnChange, mBtnReset;
    private BFragment bFragment;


    //    private Activity mActivity;
    public static AFragment newInstance(String title) {
        AFragment fragment = new AFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        Log.d("AFragment", "----onCreateView----");
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //
        mTvTitle = view.findViewById(R.id.tv_title);
        mBtnChange = (Button) view.findViewById(R.id.btn_change);
        mBtnReset = (Button) view.findViewById(R.id.btn_reset);
        mBtnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bFragment == null) {
                    bFragment = new BFragment();
                }
//                getParentFragmentManager().beginTransaction().replace(R.id.fl_container, bFragment).commitAllowingStateLoss();
//                getParentFragmentManager().beginTransaction().replace(R.id.fl_container, bFragment).addToBackStack(null).commitAllowingStateLoss();
                Fragment fragment = getParentFragmentManager().findFragmentByTag("a");
                if (fragment != null) {
                    getParentFragmentManager().beginTransaction().hide(fragment).add(R.id.fl_container, bFragment).addToBackStack(null).commitAllowingStateLoss();
                } else {
                    getParentFragmentManager().beginTransaction().replace(R.id.fl_container, bFragment).addToBackStack(null).commitAllowingStateLoss();
                }
            }
        });
        mBtnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTvTitle.setText("我是新文字");
            }
        });
        if (getArguments() != null) {
            mTvTitle.setText(getArguments().getString("title"));
        }

//        if (getActivity()!=null){
//            //TODO
//        }else {
//
//        }
    }

//    @Override
//    public void onAttach(@NonNull Context context) {
//        super.onAttach(context);
////        mActivity = (Activity) context;
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        //取消异步
//    }
}
