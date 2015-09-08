package com.vann.oschina.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.Toast;

import com.vann.oschina.R;
import com.vann.oschina.fragment.ComprehensiveFragment;
import com.vann.oschina.fragment.FoundFragment;
import com.vann.oschina.fragment.MoveFragment;
import com.vann.oschina.fragment.MyFragment;
import com.vann.oschina.widget.Topbar;


public class MainActivity extends FragmentActivity {

    private RadioButton mComprehensive;
    private RadioButton mMove;
    private RadioButton mFound;
    private RadioButton mMe;

    private ComprehensiveFragment mComprehensiveFragment;
    private MoveFragment mMoveFragment;
    private FoundFragment mFoundFrament;
    private MyFragment mMyFragment;
    private Topbar mTopbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
        setSelection(0);

    }

    private void initView() {
        mComprehensive = (RadioButton) findViewById(R.id.rb_comprehensive);
        mMove = (RadioButton) findViewById(R.id.rb_move);
        mFound = (RadioButton) findViewById(R.id.rb_found);
        mMe = (RadioButton) findViewById(R.id.rb_me);
        mTopbar = (Topbar) findViewById(R.id.id_topbar);
        mTopbar.setOnTopbarClickedListener(new Topbar.TopbarClickedListener() {
            @Override
            public void setLeftClickedListener() {
                Toast.makeText(MainActivity.this,"Clicked the left Button",Toast.LENGTH_LONG).show();
            }

            @Override
            public void setRigthClickedListener() {
                Toast.makeText(MainActivity.this,"Clicked the right Button",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setSelection(int index){
        resetImg();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        hideFragments(ft);
        switch (index){
            case 0:
                mComprehensive.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.tab_comprehensive_pressed_icon, 0, 0);
                mComprehensive.setTextColor(mComprehensive.getResources().getColor(R.color.topbar_bg));
                if(mComprehensiveFragment== null){
                    mComprehensiveFragment = new ComprehensiveFragment();
                    ft.add(R.id.fg_content,mComprehensiveFragment);
                }else{
                    ft.show(mComprehensiveFragment);
                }
                break;
            case 1:
                mMove.setCompoundDrawablesRelativeWithIntrinsicBounds(0, R.mipmap.tab_move_pressed_icon, 0, 0);
                mMove.setTextColor(mMove.getResources().getColor(R.color.topbar_bg));
                if(mMoveFragment == null){
                    mMoveFragment = new MoveFragment();
                    ft.add(R.id.fg_content,mMoveFragment);
                }else{
                    ft.show(mMoveFragment);
                }
                break;
            case 2:
                mFound.setCompoundDrawablesRelativeWithIntrinsicBounds(0, R.mipmap.tab_found_pressed_icon, 0, 0);
                mFound.setTextColor(mFound.getResources().getColor(R.color.topbar_bg));
                if(mFoundFrament == null){
                    mFoundFrament  = new FoundFragment();
                    ft.add(R.id.fg_content,mFoundFrament);
                }
                ft.show(mFoundFrament);
                break;
            case 3:
                mMe.setCompoundDrawablesRelativeWithIntrinsicBounds(0, R.mipmap.tab_me_pressed_icon, 0, 0);
                mMe.setTextColor(mFound.getResources().getColor(R.color.topbar_bg));
                if(mMyFragment == null ){
                    mMyFragment = new MyFragment();
                    ft.add(R.id.fg_content,mMyFragment);
                }else{
                    ft.show(mMyFragment);
                }
                break;
        }
        ft.commit();
    }
    /**
     *  恢复默认图片
     */
    private void resetImg() {
        mComprehensive.setCompoundDrawablesRelativeWithIntrinsicBounds(0,
                R.mipmap.tab_comprehensive_icon, 0, 0);
        mComprehensive.setTextColor(mComprehensive.getResources().getColor(R.color.tab_text_bg));
        mMove.setCompoundDrawablesWithIntrinsicBounds(0,
                R.mipmap.tab_move_icon, 0, 0);
        mMove.setTextColor(mMove.getResources().getColor(R.color.tab_text_bg));
        mFound.setCompoundDrawablesRelativeWithIntrinsicBounds(0,
                R.mipmap.tab_found_icon, 0, 0);
        mFound.setTextColor(mFound.getResources().getColor(R.color.tab_text_bg));
        mMe.setCompoundDrawablesRelativeWithIntrinsicBounds(0,
                R.mipmap.tab_me_icon, 0, 0);
        mMe.setTextColor(mMe.getResources().getColor(R.color.tab_text_bg));
    }

    private void hideFragments(FragmentTransaction ft){
        if(mComprehensiveFragment != null){
            ft.hide(mComprehensiveFragment);
        }
        if(mMoveFragment !=null ){
            ft.hide(mMoveFragment);
        }
        if(mFoundFrament != null){
            ft.hide(mFoundFrament);
        }
        if(mMyFragment != null){
            ft.hide(mMyFragment);
        }
    }

    public void onComprehensiveClicked(View view){
        setSelection(0);
    }
    public void onMoveClicked(View view){
        setSelection(1);
    }
    public void onFoundClicked(View view){
        setSelection(2);
    }
    public void onMyClicked(View view){
        setSelection(3);
    }

}
