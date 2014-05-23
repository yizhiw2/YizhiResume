package com.yizhi.yizhiresume.fragments;

/*
 * Fragment03 和 fragment04 的父类
 * 
 * 实现ExpandableListview
 * 
 * */
import com.yizhi.yizhiresume.R;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;

@SuppressLint({ "NewApi", "ResourceAsColor" })
abstract class ExpandableListViewFragment extends Fragment {

	ExpandableListView expandableListView;
	static LinearLayout ll;

	@SuppressLint("NewApi")
	public static final String NUMBER = "number";
	int current = 0;

	@SuppressLint("NewApi")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.expandablelistview_fragment,
				container, false);

		// 提供以设置背景
		ll = new LinearLayout(getActivity());
		ll = (LinearLayout) rootView.findViewById(R.id.expandable_ll);
		setBackground();

		int i = getArguments().getInt(NUMBER);
		String title = getResources().getStringArray(R.array.mTitles)[i];
		getActivity().setTitle(title);

		expandableListView = (ExpandableListView) rootView
				.findViewById(R.id.expandableListView);

		// 创建adapter
		ExpandableListAdapter adapter = new ExpandableListAdapter() {

			private String[] group = getGroupStrings();
			private String[][] details = getDetails();

			@Override
			public void unregisterDataSetObserver(DataSetObserver observer) {
				// TODO Auto-generated method stub

			}

			@Override
			public void registerDataSetObserver(DataSetObserver observer) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onGroupExpanded(int groupPosition) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onGroupCollapsed(int groupPosition) {
				// TODO Auto-generated method stub

			}

			@Override
			public boolean isEmpty() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean isChildSelectable(int groupPosition,
					int childPosition) {
				// TODO Auto-generated method stub
				return true;
			}

			@Override
			public boolean hasStableIds() {
				// TODO Auto-generated method stub
				return true;
			}

			@Override
			public View getGroupView(int groupPosition, boolean isExpanded,
					View convertView, ViewGroup parent) {
				// 线性布局
				LinearLayout ll = new LinearLayout(getActivity());
				ll.setOrientation(0);
				TextView textView = getTextView();
				textView.setText(getGroup(groupPosition).toString());
				ll.addView(textView);
				return ll;
			}

			@Override
			public long getGroupId(int groupPosition) {
				// TODO Auto-generated method stub
				return groupPosition;
			}

			@Override
			public int getGroupCount() {
				// TODO Auto-generated method stub
				return group.length;
			}

			@Override
			public Object getGroup(int groupPosition) {
				// TODO Auto-generated method stub
				return group[groupPosition];
			}

			@Override
			public long getCombinedGroupId(long groupId) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public long getCombinedChildId(long groupId, long childId) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public int getChildrenCount(int groupPosition) {
				// TODO Auto-generated method stub
				return details[groupPosition].length;
			}

			@Override
			public View getChildView(int groupPosition, int childPosition,
					boolean isLastChild, View convertView, ViewGroup parent) {
				// 设置展开栏内容属性
				TextView textView = new TextView(getActivity());
				textView.setTextSize(20);
				textView.setTextColor(R.color.color_text_01);
				textView.setPadding(40, 10, 10, 10);
				textView.setText(getChild(groupPosition, childPosition)
						.toString());
				return textView;
			}

			@Override
			public long getChildId(int groupPosition, int childPosition) {
				// TODO Auto-generated method stub
				return childPosition;
			}

			@Override
			public Object getChild(int groupPosition, int childPosition) {
				// TODO Auto-generated method stub
				return details[groupPosition][childPosition];
			}

			@Override
			public boolean areAllItemsEnabled() {
				// TODO Auto-generated method stub
				return false;
			}

			private TextView getTextView() {
				AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
						ViewGroup.LayoutParams.MATCH_PARENT, 128);
				TextView textView = new TextView(getActivity());
				textView.setLayoutParams(lp);
				textView.setTextSize(22);
				textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
				textView.setPadding(100, 20, 0, 20);
				return textView;
			}
		};
		// 设置适配器
		expandableListView.setAdapter(adapter);

		return rootView;
	}

	// 三个抽象方法
	abstract String[] getGroupStrings();

	abstract String[][] getDetails();

	abstract void setBackground();
}
