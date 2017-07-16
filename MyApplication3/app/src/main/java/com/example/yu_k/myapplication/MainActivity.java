package com.example.yu_k.myapplication;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends Activity implements BottomFragment.OnBottomClickCallback,ContentFragment.OnSendMessageClickCallback{

    private ContentFragment2 mContentFragment2;

    private ContentFragment3 mContentFragment3;

    private FragmentManager mFragmentManager;
    
    private ContentFragment mContentFragment1;

    @Override
    public int buttonClick(int position) {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        removeAllFragment(fragmentTransaction);
        switch (position){
            case 1:
                mContentFragment1 = new ContentFragment();
                fragmentTransaction.replace(R.id.wechat_content_framelayout,mContentFragment1);
                fragmentTransaction.commit();
                break;
            case 2:
                mContentFragment2 = new ContentFragment2();
                fragmentTransaction.replace(R.id.wechat_content_framelayout,mContentFragment2);
                fragmentTransaction.commit();
                break;
            case 3:
                mContentFragment3 = new ContentFragment3();
                fragmentTransaction.replace(R.id.wechat_content_framelayout,mContentFragment3);
                fragmentTransaction.commit();
                break;
        }
        return 0;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wechat_main_layout);
        mFragmentManager = getFragmentManager();
    }

    private void removeAllFragment(FragmentTransaction fragmentTransaction){
        if (mContentFragment1 != null){
            fragmentTransaction.remove(mContentFragment1);
        }
        if (mContentFragment2 != null){
            fragmentTransaction.remove(mContentFragment2);
        }
        if (mContentFragment3 != null){
            fragmentTransaction.remove(mContentFragment3);
        }
    }

    @Override
    public void showString(String string) {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        removeAllFragment(fragmentTransaction);
        mContentFragment2 = new ContentFragment2();
        fragmentTransaction.replace(R.id.wechat_content_framelayout,mContentFragment2);
        fragmentTransaction.commit();
        mContentFragment2.setData(string);
    }
//merge origin/dev to master
}
