package com.example.yu_k.myapplication;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by yu_k on 2017/7/15.
 */

public class BottomFragment extends Fragment{

    public OnBottomClickCallback mCallback;

    public interface OnBottomClickCallback{
        public int buttonClick(int position);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.wechat_bottom_layout,container,false);
        initview(view);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            mCallback = (OnBottomClickCallback) context;
        }catch (Exception e){
            Log.e("BottomFragment","exception");
        }
    }

    private void initview(View view){
        Button button1 = (Button)view.findViewById(R.id.button1);
        Button button2 = (Button)view.findViewById(R.id.button2);
        Button button3 = (Button)view.findViewById(R.id.button3);
        button1.setOnClickListener(clickListener);
        button2.setOnClickListener(clickListener);
        button3.setOnClickListener(clickListener);
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.button1){
                mCallback.buttonClick(1);
            }
            if (id == R.id.button2){
                mCallback.buttonClick(2);
            }
            if (id == R.id.button3){
                mCallback.buttonClick(3);
            }
        }
    };
}
