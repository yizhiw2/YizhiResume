package com.yizhi.yizhiresume;

/*
 * 程序启动活动播放动画
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
		
		//为图片设置动画
		Animation startAnimation = AnimationUtils.
				loadAnimation(MainActivity.this, R.anim.start);
		LinearInterpolator line = new LinearInterpolator();
		startAnimation.setInterpolator(line);
		
		if(startAnimation != null)
		{
			//设置并开始
			photo.setAnimation(startAnimation);
			photo.startAnimation(startAnimation);
		}
		
		startAnimation.setAnimationListener(new AnimationListener() {
			//动画开始时
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			//动画重复时
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			//动画结束时
			public void onAnimationEnd(Animation animation) {
				
				photo.clearAnimation();
				//启动新活动并结束当前活动
				Intent intent = new Intent(MainActivity.this, MainResumePlus.class);
				startActivity(intent);
				finish();
			}
		});
	}
}
