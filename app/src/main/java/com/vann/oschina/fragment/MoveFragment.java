package com.vann.oschina.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vann.oschina.R;
import com.vann.oschina.widget.TabPageIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wenlong.bian 2015-09-06
 * @E-mail: bxl049@163.com
 */
public class MoveFragment  extends Fragment{

    private View view;
    private TabPageIndicator mTabIndicator;
    private ViewPager mViewPager;
    private PagerAdapter mPageAdapter;
    private String[] mTitles;
    private List<Fragment> mFragments;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.fragment_move,container,false);
        initView();
        initData();
        return view;
    }

    private void initData() {
        mTitles = view.getResources().getStringArray(R.array.move_arrays);
        mFragments = new ArrayList<>();
        mFragments.add(LastMoveFrament.newInstance(mTitles[0]));
        mFragments.add(HotMoveFragment.newInstance(mTitles[1]));
        mFragments.add(MyMoveFragment.newInstance(mTitles[2]));
        mPageAdapter = new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mTitles[position];
            }
        };
        mViewPager.setAdapter(mPageAdapter);
        mTabIndicator.setViewPager(mViewPager);
    }

    private void initView() {
        mTabIndicator = (TabPageIndicator) view.findViewById(R.id.id_move_pageindicator);
        mViewPager = (ViewPager) view.findViewById(R.id.id_move_viewpager);
    }
}
