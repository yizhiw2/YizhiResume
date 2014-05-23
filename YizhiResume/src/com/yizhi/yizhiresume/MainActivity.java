package com.yizhi.yizhiresume;

/*
 * ������������Ŷ���
 * 
 * 
 * */
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
        setContentView(R.layout.activity_main);
		
		photo = (ImageView)findViewById(R.id.myPhoto);
		
		//ΪͼƬ���ö���
		Animation startAnimation = AnimationUtils.
				loadAnimation(MainActivity.this, R.anim.start);
		LinearInterpolator line = new LinearInterpolator();
		startAnimation.setInterpolator(line);
		
		if(startAnimation != null)
		{
			//���ò���ʼ
			photo.setAnimation(startAnimation);
			photo.startAnimation(startAnimation);
		}
		
		startAnimation.setAnimationListener(new AnimationListener() {
			//������ʼʱ
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			//�����ظ�ʱ
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			//��������ʱ
			public void onAnimationEnd(Animation animation) {
				
				photo.clearAnimation();
				//�����»��������ǰ�
				Intent intent = new Intent(MainActivity.this, MainResumePlus.class);
				startActivity(intent);
				finish();
			}
		});
	}
}
