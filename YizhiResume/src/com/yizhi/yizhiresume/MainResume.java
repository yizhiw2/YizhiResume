package com.yizhi.yizhiresume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yizhi.yizhiresume.fragments.Fragment01;
import com.yizhi.yizhiresume.fragments.Fragment02;
import com.yizhi.yizhiresume.fragments.Fragment03;
import com.yizhi.yizhiresume.fragments.Fragment04;
import com.yizhi.yizhiresume.fragments.Fragment05;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

@SuppressLint("NewApi")
public class MainResume extends Activity
{
	private String[] mTitles;
	private ListView mDrawerlist;
	private DrawerLayout mDrawerLayout;
	
	private String[] titles = new String[]
			{"求职意向","教育经历","编程技能","个人项目","读过的书"};
	private int[] imageIds = new int[]
			{
				R.drawable.target_2,
				R.drawable.office_2,
				R.drawable.android_2,
				R.drawable.lab_2,
				R.drawable.book_2
			};
	
	
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_resume);
		
		
		mTitles = getResources().getStringArray(R.array.mTitles);
		mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
		mDrawerlist = (ListView)findViewById(R.id.left_drawer);
		
		List<Map<String, Object>> listItems = 
				new ArrayList<Map<String,Object>>();
		
		for(int i = 0; i < titles.length; i++)
		{
			Map<String, Object> listItem = new HashMap<String,Object>();
			listItem.put("image",imageIds[i]);
			listItem.put("title", titles[i]);
			listItems.add(listItem);
		}
		
		//选择adapter设置抽屉栏内容
		mDrawerlist.setAdapter(new SimpleAdapter(
				MainResume.this,
				listItems, 
				R.layout.drawer_listview, 
				new String[] {"image","title"},
				new int[] {R.id.image, R.id.title}
				));
		mDrawerlist.setOnItemClickListener(new DrawerItemClickListener());
		
	}	
	
	
	class DrawerItemClickListener implements ListView.OnItemClickListener {
	    @Override
	    public void onItemClick(AdapterView parent,
	    		View view, int position, long id) {
	        selectItem(position);
	    }
	}
	
	/** Swaps fragments in the main content view */
	private void selectItem(int position) {
	    // Create a new fragment and specify the planet to show based on position
	    Fragment fragment = null;
	    Bundle args = new Bundle();
	    
	    switch (position) {
		case 0:
			fragment = new Fragment01();
			args.putInt(Fragment01.NUMBER, position);
			break;
			
		case 1:
			fragment = new Fragment02();
			args.putInt(Fragment02.NUMBER, position);
			break;
			
		case 2:
			fragment = new Fragment03();
			args.putInt(Fragment03.NUMBER, position);
			break;
		case 3:
			fragment = new Fragment04();
			args.putInt(Fragment04.NUMBER, position);
			break;
		case 4:
			fragment = new Fragment05();
			args.putInt(Fragment05.NUMBER, position);
			break;
		default:
			break;
		}
	   
	    fragment.setArguments(args);

	    // Insert the fragment by replacing any existing fragment
	    android.app.FragmentManager fragmentManager = getFragmentManager();
	    fragmentManager.beginTransaction()
	                   .replace(R.id.content_frame, fragment)
	                   .commit();

	    // Highlight the selected item, update the title, and close the drawer
	    mDrawerlist.setItemChecked(position, true);
	    setTitle(mTitles[position]);
	    mDrawerLayout.closeDrawer(mDrawerlist);
	}

	
	
}
