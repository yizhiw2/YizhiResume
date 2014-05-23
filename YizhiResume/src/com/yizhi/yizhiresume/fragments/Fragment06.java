package com.yizhi.yizhiresume.fragments;

/*
 * 联系我
 * 
 * 在fragment设置接口，
 * 让activity去继承，
 * 然后实现操作方法
 * 
 * */

import com.yizhi.yizhiresume.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

@SuppressLint("NewApi")
public class Fragment06 extends Fragment 
{
	@SuppressLint("NewApi")
	public static final String NUMBER = "number";
	//
	Callback06 callback06;
	private Button call;
	private Button message;
	private Button email;
	private Button saveto;
	
	 //fragment 创建时调用   ，判断有没继承接口
    public void onAttach(Activity activity) {
    	super.onAttach(activity);
	    	try {
	            callback06 = (Callback06) activity;
	        } catch (ClassCastException e) {
	            	throw new ClassCastException(activity.toString() + 
	            		" must implements OnArticleSelectedListener");
	        }
	    }
    
	//实现与activity通信的借口
	public interface Callback06 {
	      	public void onButtonClick(View v);
	}
	
	@SuppressLint("NewApi")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
		   Bundle savedInstanceState) {
	       View rootView = inflater.inflate(
	    		   R.layout.fragment06,
	    		   container, 
	    		   false);
	       int i = getArguments().getInt(NUMBER);
	       String title = getResources().getStringArray(R.array.mTitles)[i];
	       getActivity().setTitle(title);
	       
	       //四个按钮
	       call = (Button)rootView.findViewById(R.id.call);
	       message = (Button)rootView.findViewById(R.id.message);
	       email = (Button)rootView.findViewById(R.id.email);
	       saveto = (Button)rootView.findViewById(R.id.saveto);
	       
	       OnMyClickListener listener = new OnMyClickListener();
	       
	       call.setOnClickListener(listener);
	       message.setOnClickListener(listener);
	       email.setOnClickListener(listener);
	       saveto.setOnClickListener(listener);
	       
	       return rootView;
    }
	
	//监听各个按钮
	class OnMyClickListener implements OnClickListener
	{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			callback06.onButtonClick(v);
		}
		
	}
}