package com.yizhi.yizhiresume.fragments;

/*
 * ��ϵ��
 * 
 * ��fragment���ýӿڣ�
 * ��activityȥ�̳У�
 * Ȼ��ʵ�ֲ�������
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
	
	 //fragment ����ʱ����   ���ж���û�̳нӿ�
    public void onAttach(Activity activity) {
    	super.onAttach(activity);
	    	try {
	            callback06 = (Callback06) activity;
	        } catch (ClassCastException e) {
	            	throw new ClassCastException(activity.toString() + 
	            		" must implements OnArticleSelectedListener");
	        }
	    }
    
	//ʵ����activityͨ�ŵĽ��
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
	       
	       //�ĸ���ť
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
	
	//����������ť
	class OnMyClickListener implements OnClickListener
	{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			callback06.onButtonClick(v);
		}
		
	}
}