package com.vann.oschina.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vann.oschina.R;

/**
 * @Author: wenlong.bian 2015-09-06
 * @E-mail: bxl049@163.com
 */
public class FoundFragment extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_found,container,false);
        return view;
    }
}
