package com.vann.oschina.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vann.oschina.R;
import com.vann.oschina.constant.CommonConstant;

/**
 * @Author: wenlong.bian 2015-09-07
 * @E-mail: bxl049@163.com
 */
public class NewsChildFragment extends Fragment{

    private View view;
    private String mTitle;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_content,container,false);
        TextView content = (TextView) view.findViewById(R.id.content);
        Bundle bd= getArguments();
        if(bd != null ){
            content.setText(bd.getString(CommonConstant.TABPAGE_TEXT));
        }
        return view;
    }

    public static NewsChildFragment newInstance(String title){
        Bundle bd = new Bundle();
        bd.putString(CommonConstant.TABPAGE_TEXT, title);
        NewsChildFragment fragment = new NewsChildFragment();
        fragment.setArguments(bd);
        return fragment;
    }
}
