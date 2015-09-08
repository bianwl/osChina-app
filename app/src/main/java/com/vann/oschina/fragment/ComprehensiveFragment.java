package com.vann.oschina.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vann.oschina.R;
import com.vann.oschina.widget.PageIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wenlong.bian 2015-09-06
 * @E-mail: bxl049@163.com
 */
public class ComprehensiveFragment extends Fragment {

    private View view;
    private PageIndicator mPageindicator;
    private ViewPager mViewpager;
    private PagerAdapter mPageAdapter;
    private String[] mTitles;
    private List<Fragment> childFragments;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_comprehensive,container,false);
        initView();
        initData();
        return view;
    }

    private void initData() {
        mTitles = view.getResources().getStringArray(R.array.comprehensive_arrays);
        childFragments  = new ArrayList<Fragment>();
        childFragments.add(NewsChildFragment.newInstance(mTitles[0]));
        childFragments.add(HotChildFragment.newInstance(mTitles[1]));
        childFragments.add(BlogChildFragment.newInstance(mTitles[2]));
        childFragments.add(ReCommandChildFragment.newInstance(mTitles[3]));
        mPageAdapter = new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return childFragments.get(position);
            }

            @Override
            public int getCount() {
                return childFragments.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mTitles[position];
            }
        };
        mViewpager.setAdapter(mPageAdapter);
        mPageindicator.setViewPager(mViewpager);

    }

    private void initView() {
        mPageindicator = (PageIndicator) view.findViewById(R.id.id_pageindicator);
        mViewpager = (ViewPager) view.findViewById(R.id.id_viewpager);

    }
}
