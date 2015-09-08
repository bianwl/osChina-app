package com.vann.oschina.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.vann.oschina.R;

/**
 * @Author: wenlong.bian 2015-09-06
 * @E-mail: bxl049@163.com
 */
public class Topbar extends RelativeLayout {

    private Button mLeftBtn;
    private String leftText;
    private Drawable mDrawLeft;
    private float leftTextSize;
    private int leftTextColor;

    private Button mRightBtn;
    private float mRightWidth;
    private float mRightHeight;
    private Drawable mRightBackground;
    private RelativeLayout.LayoutParams mLeftParams,mRightParams;

    private TopbarClickedListener mListener;

    public Topbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs,R.styleable.topbar);
        leftText = ta.getString(R.styleable.topbar_lefttext);
        mDrawLeft = ta.getDrawable(R.styleable.topbar_leftdrawable);
        leftTextSize = ta.getDimension(R.styleable.topbar_lefttextsize, 0);
        leftTextColor = ta.getColor(R.styleable.topbar_lefttextcolor, 0);
        mRightBackground = ta.getDrawable(R.styleable.topbar_rightbackground);
        mRightWidth = ta.getDimension(R.styleable.topbar_rightwidth, 0);
        mRightHeight = ta.getDimension(R.styleable.topbar_rightheight,0);
        ta.recycle();
        mLeftBtn = new Button(context);
        mRightBtn= new Button(context);
        mLeftBtn.setText(leftText);
        mLeftBtn.setTextColor(leftTextColor);
        mLeftBtn.setBackgroundColor(Color.TRANSPARENT);
        mLeftBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(mDrawLeft, null, null, null);
        mLeftBtn.setTextSize(leftTextSize);
        mRightBtn.setBackground(mRightBackground);
        mRightBtn.setGravity(Gravity.CENTER_VERTICAL);
        setBackgroundResource(R.color.topbar_bg);

        mLeftParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mLeftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        addView(mLeftBtn, mLeftParams);

        mRightParams = new RelativeLayout.LayoutParams((int)mRightWidth, (int)mRightHeight);
        mRightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        mRightParams.addRule(RelativeLayout.CENTER_VERTICAL);
        addView(mRightBtn, mRightParams);
        mLeftBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.setLeftClickedListener();
            }
        });
        mRightBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.setRigthClickedListener();
            }
        });
    }

    public interface TopbarClickedListener{
        void setLeftClickedListener();
        void setRigthClickedListener();
    }

    public  void setOnTopbarClickedListener(TopbarClickedListener listener){
        this.mListener  = listener;
    }

    public void setDrawableLeft(int res){
        mLeftBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(res,0,0,0);
    }

    public void setRightBackground(int res){
        mRightBtn.setBackgroundResource(res);
    }
}
