package com.yizhi.yizhiresume.fragments;

/*
 *求职意向
 * 
 */
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
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint({ "NewApi", "ShowToast" })
public class Fragment01 extends Fragment {
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
						R.drawable.text_client_shape),
				getActivity().getResources().getDrawable(
						R.drawable.text_develop_shape),
				getActivity().getResources().getDrawable(
						R.drawable.text_student_shape)

		};

		int[] anims = new int[] { R.anim.anim_text_android,
				R.anim.anim_text_client, R.anim.anim_text_develop,
				R.anim.anim_text_student };

		String[] toasts = new String[]
				{
					"点我没用","我也是","楼下能点","楼上骗你的"
				};
		View rootView = inflater.inflate(R.layout.fragment01, container, false);
		int i = getArguments().getInt(NUMBER);
		String title = getResources().getStringArray(R.array.mTitles)[i];
		getActivity().setTitle(title);

		// 获取container的高度
		final int width = container.getWidth() / 2;
		final int height = container.getHeight() / 2;

		Log.i("--width--", "" + width);
		Log.i("--height--", "" + height);

		Log.i("--grid--", "for front");
		gridLayout = (GridLayout) rootView.findViewById(R.id.gridlayout_01);

		for (int j = 0; j < strings.length; j++) {

			RelativeLayout relativeLayout = new RelativeLayout(getActivity());

			/*
			 * 此方法在此处无效，还不知为什么 // 设置layout的高度和宽度，先获取再修改再设置
			 * RelativeLayout.LayoutParams params =
			 * (RelativeLayout.LayoutParams)relativeLayout .getLayoutParams();
			 * params.height = height; params.width = width;
			 * relativeLayout.setLayoutParams(params);
			 */
			RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
					width, height);
			Log.i("--grid--", "for inner");

			TextView text = new TextView(getActivity());

			text.setText(strings[j]);
			text.setTextSize(30);
			text.setGravity(Gravity.CENTER);
			// text.setWidth();
			Log.i("text_width", "" + text.getWidth());
			Log.i("text_height", "" + text.getHeight());
			text.setBackground(backgrounds[j]);
			final String tmp = toasts[j];
			
			//点击效果
			text.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					Toast.makeText(getActivity(), tmp, 200).show();
				}
			});
			Animation startAnimation = AnimationUtils.loadAnimation(
					getActivity(), anims[j]);
			LinearInterpolator line = new LinearInterpolator();
			startAnimation.setInterpolator(line);

			if (startAnimation != null) {
				text.setAnimation(startAnimation);
				text.startAnimation(startAnimation);
			}

			relativeLayout.addView(text, params); // 不要忘了第二个参数！！！

			GridLayout.Spec rowSpec = GridLayout.spec(j / 2);
			GridLayout.Spec columeSpec = GridLayout.spec(j % 2);
			GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(
					rowSpec, columeSpec);
			// layoutParams.setGravity(Gravity.FILL);
			gridLayout.addView(relativeLayout, layoutParams);
			Log.i("--grid--", "for over");
		}

		// text_android = (TextView)rootView.findViewById(R.id.text_android);
		// text_android.setBackground(getActivity().getResources().getDrawable(R.drawable.selector0));
		Log.i("--grid--", "for out");
		return rootView;
	}
}
