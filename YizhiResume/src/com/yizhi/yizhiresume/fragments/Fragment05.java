package com.yizhi.yizhiresume.fragments;

/*
 * 读过的书
 * 
 * 运用Gridlayout实现九宫格
 * 再在上面布局relativelayout
 * 最后再把（textview）book 布局到relativelayout 上
 * 
 * */

import com.yizhi.yizhiresume.R;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

@SuppressLint({ "NewApi", "ShowToast", "ResourceAsColor" })
public class Fragment05 extends Fragment {
	@SuppressLint("NewApi")
	public static final String NUMBER = "number";
	GridLayout gridLayout;
	TextView book;

	@SuppressLint("NewApi")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.i("--Fragment05--", "beginning！！");

		// 书名
		String[] books = new String[] {
				getActivity().getResources().getString(R.string.book01),
				getActivity().getResources().getString(R.string.book02),
				getActivity().getResources().getString(R.string.book03),
				getActivity().getResources().getString(R.string.book04),
				getActivity().getResources().getString(R.string.book05),
				getActivity().getResources().getString(R.string.book06),
				getActivity().getResources().getString(R.string.book07),
				getActivity().getResources().getString(R.string.book08),
				getActivity().getResources().getString(R.string.book09) };

		// 每一个book的外形
		Drawable[] backgrounds = new Drawable[] {
				getActivity().getResources().getDrawable(
						R.drawable.book_shape_01),
				getActivity().getResources().getDrawable(
						R.drawable.book_shape_02),
				getActivity().getResources().getDrawable(
						R.drawable.book_shape_03),
				getActivity().getResources().getDrawable(
						R.drawable.book_shape_04),
				getActivity().getResources().getDrawable(
						R.drawable.book_shape_05),
				getActivity().getResources().getDrawable(
						R.drawable.book_shape_06),
				getActivity().getResources().getDrawable(
						R.drawable.book_shape_07),
				getActivity().getResources().getDrawable(
						R.drawable.book_shape_08),
				getActivity().getResources().getDrawable(
						R.drawable.book_shape_09), };

		View rootView = inflater.inflate(R.layout.fragment05, container, false);
		int i = getArguments().getInt(NUMBER);
		String title = getResources().getStringArray(R.array.mTitles)[i];
		getActivity().setTitle(title);

		gridLayout = (GridLayout) rootView.findViewById(R.id.gridlayout_05);
	
		// relativelayout 的 高与宽 （分成九宫格）
		final int width = container.getWidth() / 3;
		final int height = container.getHeight() / 3;

		Log.i("--width--", "" + width);
		Log.i("--height--", "" + height);

		Log.i("--grid--", "for front");
		gridLayout = (GridLayout) rootView.findViewById(R.id.gridlayout_05);
		Log.i("books.length", "" + books.length);

		//
		for (int j = 0; j < books.length; j++) {

			RelativeLayout relativeLayout = new RelativeLayout(getActivity());

			RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
					width, height);
			Log.i("--grid--", "for inner");

			book = new TextView(getActivity());
			book.setText(books[j]);

			// 最后一个是“等”字，所以跟其它不一样
			if (j == books.length - 1) {
				book.setTextSize(40);
				book.setTextColor(R.color.color_text_grey);
			} else {
				book.setTextSize(18);
			}

			book.setGravity(Gravity.CENTER);
			book.setBackground(backgrounds[j]);

			// 监听点击
			book.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Animation animation = AnimationUtils.loadAnimation(
							getActivity(), R.anim.anim_book);
					LinearInterpolator line = new LinearInterpolator();
					animation.setInterpolator(line);
					v.setAnimation(animation);
					v.startAnimation(animation);
					Log.i("--anim--", "此处应该有动画");

				}
			});

			// 长按时就消失
			book.setOnLongClickListener(new OnLongClickListener() {

				@Override
				public boolean onLongClick(View v) {
					// TODO Auto-generated method stub
					Animation animation = AnimationUtils.loadAnimation(
							getActivity(), R.anim.anim_book_long);
					animation.setFillAfter(true); // 保持最后状态
					LinearInterpolator line = new LinearInterpolator();
					animation.setInterpolator(line);
					v.setAnimation(animation);
					v.startAnimation(animation);
					return true; // return true 这样就不会触发onclick
				}
			});

			relativeLayout.addView(book, params); // 不要忘了第二个参数！！！

			GridLayout.Spec rowSpec = GridLayout.spec(j / 3);
			GridLayout.Spec columeSpec = GridLayout.spec(j % 3);
			GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(
					rowSpec, columeSpec);

			gridLayout.addView(relativeLayout, layoutParams);
			Log.i("--grid--", "for over");
		}

		Log.i("--grid--", "for out");
		Log.i("--Fragment05--", "end!!!!");
		return rootView;
	}
}
