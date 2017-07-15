package com.example.yu_k.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by yu_k on 2017/7/15.
 */

public class ContentFragment2 extends Fragment{

    private TextView mTextView;

    private String mContent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.wechat_content_layout_v2,container,false);
        initView(view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mContent != null){
            mTextView.setText(mContent);
        }
    }

    private void initView(View view){
        mTextView = (TextView) view.findViewById(R.id.wechat_content_tv);
    }

    public void setData(String string){
        mContent = string;

    }

}
