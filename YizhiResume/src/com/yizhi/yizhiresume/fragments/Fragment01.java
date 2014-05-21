package com.yizhi.yizhiresume.fragments;

import com.yizhi.yizhiresume.R;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;




@SuppressLint("NewApi")
public class Fragment01 extends Fragment{
	@SuppressLint("NewApi")
	public static final String NUMBER = "number";
	private GridLayout gridLayout;

	
	

	@SuppressLint("NewApi")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		String[] strings = new String[] {
				getActivity().getResources().getString(R.string.text_android),
				getActivity().getResources().getString(R.string.text_client),
				getActivity().getResources().getString(R.string.text_develop),
				getActivity().getResources().getString(R.string.text_student) };
		Drawable[] backgrounds = new Drawable[] {
				getActivity().getResources().getDrawable(
						R.drawable.text_android_shape),
				getActivity().getResources().getDrawable(
						R.drawable.text_android_shape),
				getActivity().getResources().getDrawable(
						R.drawable.text_android_shape),
				getActivity().getResources().getDrawable(
						R.drawable.text_android_shape)

		};

		int[] anims = new int[] { R.anim.start, R.anim.start, R.anim.start,
				R.anim.start };
		
		// ��ȡ��Ļ�ĸ߿��õ�relativelayout�ĸ߿�
		Display display = getActivity().getWindowManager().getDefaultDisplay();
		@SuppressWarnings("deprecation")
		final int width = display.getWidth() / 2;
		@SuppressWarnings("deprecation")
		final int height = display.getHeight() / 2;
		
		View rootView = inflater.inflate(R.layout.fragment01, container, false);
		int i = getArguments().getInt(NUMBER);
		String title = getResources().getStringArray(R.array.mTitles)[i];
		getActivity().setTitle(title);
		
		Log.i("--grid--","for front");
		gridLayout = (GridLayout) rootView.findViewById(R.id.gridlayout_01);

		for (int j = 0; j < strings.length; j++) {
			RelativeLayout relativeLayout = new RelativeLayout(getActivity());
			
			RelativeLayout.LayoutParams params = 
					new RelativeLayout.LayoutParams(width, height);
			/*// ����layout�ĸ߶ȺͿ�ȣ��Ȼ�ȡ���޸�������
			RelativeLayout.LayoutParams params =  (RelativeLayout.LayoutParams)relativeLayout
					.getLayoutParams();
			params.height = height;
			params.width = width;
			relativeLayout.setLayoutParams(params);*/
			Log.i("--grid--","for inner");
			
			TextView text = new TextView(getActivity());
			
			text.setText(strings[j]);
			text.setTextSize(40);
			text.setGravity(Gravity.CENTER);
			text.setBackground(backgrounds[j]);
			
			Animation startAnimation = AnimationUtils.loadAnimation(getActivity(),
					anims[j]);
			LinearInterpolator line = new LinearInterpolator();
			startAnimation.setInterpolator(line);
			/*
			 * startAnimation.setAnimationListener(new AnimationListener() {
			 * 
			 * public void onAnimationStart(Animation animation) { // TODO
			 * Auto-generated method stub
			 * 
			 * }
			 * 
			 * public void onAnimationRepeat(Animation animation) { // TODO
			 * Auto-generated method stub
			 * 
			 * }
			 * 
			 * public void onAnimationEnd(Animation animation) {
			 * 
			 * } });
			 */
			if (startAnimation != null) {
				text.setAnimation(startAnimation);
			}

			relativeLayout.addView(text,params); //��Ҫ���˵ڶ�������������

			GridLayout.Spec rowSpec = GridLayout.spec(j / 2);
			GridLayout.Spec columeSpec = GridLayout.spec(j % 2);
			GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(
					rowSpec, columeSpec);
			//layoutParams.setGravity(Gravity.FILL);
			gridLayout.addView(relativeLayout, layoutParams);
			Log.i("--grid--","for over");
		}


		// text_android = (TextView)rootView.findViewById(R.id.text_android);
		// text_android.setBackground(getActivity().getResources().getDrawable(R.drawable.selector0));
		Log.i("--grid--","for out");
		return rootView;
	}
}
