package com.example.yu_k.myapplication;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by yu_k on 2017/7/15.
 */

public class ContentFragment extends Fragment{

    private EditText mEditText;

    private Button mButton;

    public OnSendMessageClickCallback mCallBack;

    public interface OnSendMessageClickCallback{
        public void showString(String string);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.wechat_content,container,false);
        initView(view);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            mCallBack = (OnSendMessageClickCallback) context;
        }catch (Exception e){
            //
        }
    }

    public void initView(View view){
        mEditText = (EditText) view.findViewById(R.id.wechat_content_tv);
        mButton = (Button) view.findViewById(R.id.fragment1_btn);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String editContent = mEditText.getText().toString();
                mCallBack.showString(editContent);
            }
        });
    }
}
