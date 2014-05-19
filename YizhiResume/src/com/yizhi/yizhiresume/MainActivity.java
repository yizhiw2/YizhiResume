package com.yizhi.yizhiresume;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;

import android.widget.ImageView;


public class MainActivity extends Activity {
	
	ImageView photo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		/*
		// ���ر�����  
        requestWindowFeature(Window.FEATURE_NO_TITLE);  
        // ����״̬��  
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,  
                WindowManager.LayoutParams.FLAG_FULLSCREEN); 
        */
        setContentView(R.layout.activity_main);
		
		
		photo = (ImageView)findViewById(R.id.myPhoto);
		
		//ΪͼƬ���ö���
		Animation startAnimation = AnimationUtils.
				loadAnimation(MainActivity.this, R.anim.start);
		LinearInterpolator line = new LinearInterpolator();
		startAnimation.setInterpolator(line);
		
		if(startAnimation != null)
		{
			photo.setAnimation(startAnimation);
		}
		
		startAnimation.setAnimationListener(new AnimationListener() {
			
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			public void onAnimationEnd(Animation animation) {
				
				photo.clearAnimation();
				//�����»
				Intent intent = new Intent(MainActivity.this, MainResumePlus.class);
				startActivity(intent);
				finish();
			}
		});
		
		
	}
	
	
}
