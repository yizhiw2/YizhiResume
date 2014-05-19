package com.yizhi.yizhiresume.fragments;

import com.yizhi.yizhiresume.R;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

@SuppressLint("NewApi")
public class Fragment00 extends Fragment {
   @SuppressLint("NewApi")
   public static final String NUMBER = "number";
	    
    @SuppressLint("NewApi")
	@Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container,
		   Bundle savedInstanceState) {
	       View rootView = inflater.inflate(
	    		   R.layout.fragment00,
	    		   container, 
	    		   false);
	       int i = getArguments().getInt(NUMBER);
	       String title = getResources().getStringArray(R.array.mTitles)[i];
	       getActivity().setTitle(title);
	       return rootView;
    }
}


