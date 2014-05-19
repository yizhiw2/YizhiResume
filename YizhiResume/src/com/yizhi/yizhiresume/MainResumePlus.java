package com.yizhi.yizhiresume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yizhi.yizhiresume.MainResume.DrawerItemClickListener;
import com.yizhi.yizhiresume.fragments.Fragment00;
import com.yizhi.yizhiresume.fragments.Fragment01;
import com.yizhi.yizhiresume.fragments.Fragment02;
import com.yizhi.yizhiresume.fragments.Fragment03;
import com.yizhi.yizhiresume.fragments.Fragment04;
import com.yizhi.yizhiresume.fragments.Fragment05;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainResumePlus extends Activity
	implements OnItemClickListener
	{
	
	private CharSequence mTitle;
	private CharSequence mDrawerTitle;
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	//private NavDrawerListAdapter mAdapter;
	private ActionBarDrawerToggle mDrawerToggle;
	private String[] mTitles;
	
	/*
	private String[] titles = new String[]
			{"个人信息","求职意向","教育经历","编程技能","个人项目","读过的书"};
			*/
	private int[] imageIds = new int[]
			{
				R.drawable.user_2,
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
		
		//初始化抽屉
		findView();
		
		
		if(savedInstanceState == null)
		{
			selectItem(0);
		}
	}

	

	@SuppressLint("NewApi")
	private void findView() {
		
		// TODO Auto-generated method stub
		mTitle = mDrawerTitle = getTitle();
		mTitles = getResources().getStringArray(R.array.mTitles);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
	    mDrawerList = (ListView) findViewById(R.id.left_drawer);
	 // set a custom shadow that overlays the main content when the drawer opens
        mDrawerLayout.setDrawerShadow(
        		R.drawable.drawer_shadow, GravityCompat.START);
        
        List<Map<String, Object>> listItems = 
				new ArrayList<Map<String,Object>>();
		
		for(int i = 0; i < mTitles.length; i++)
		{
			Map<String, Object> listItem = new HashMap<String,Object>();
			listItem.put("image", imageIds[i]);
			listItem.put("title", mTitles[i]);
			listItems.add(listItem);
		}
		
		//选择adapter设置抽屉栏内容
		mDrawerList.setAdapter(new SimpleAdapter(
				MainResumePlus.this,
				listItems, 
				R.layout.drawer_listview, 
				new String[] {"image", "title"},
				new int[] {R.id.image, R.id.title}
				));
		mDrawerList.setOnItemClickListener(MainResumePlus.this);
		
		
		
		// ActionBarDrawerToggle ties together the the proper interactions
        // between the sliding drawer and the action bar app icon
        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                R.drawable.drawer,  /* nav drawer image to replace 'Up' caret */
                R.string.drawer_open,  /* "open drawer" description for accessibility */
                R.string.drawer_close  /* "close drawer" description for accessibility */
                ) {
            public void onDrawerClosed(View view) {
                getActionBar().setTitle(mTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            public void onDrawerOpened(View drawerView) {
                getActionBar().setTitle(mDrawerTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        
        // enable ActionBar app icon to behave as action to toggle nav drawer
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
	}
	
	@Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
    }
    
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	/* Called whenever we call invalidateOptionsMenu() */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // If the nav drawer is open, hide action items related to the content view
        //boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        //menu.findItem(R.id.action_refresh).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
         // The action bar home/up action should open or close the drawer.
         // ActionBarDrawerToggle will take care of this.
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        /*
        // Handle action buttons
        switch(item.getItemId()) {
        
        case R.id.action_search:
            
             Toast.makeText(this, R.string.action_search, Toast.LENGTH_SHORT).show();
            
            return true;
        case R.id.action_refresh:
        	
        	Toast.makeText(this, R.string.action_refresh, Toast.LENGTH_SHORT).show();
        	
        	return true;
        default:
            return super.onOptionsItemSelected(item);
            
        }
        */
        return super.onOptionsItemSelected(item);
    }
    
    
    
    
    
    
	public void onItemClick(AdapterView<?> parent, 
			View view, int position, long id) {	
		selectItem(position);
	}
	
	private void selectItem(int position) {
		// TODO Auto-generated method stub
		 Fragment fragment = null;
		 Bundle args = new Bundle();
		    
		    switch (position) {
			case 0:
				fragment = new Fragment00();
				args.putInt(Fragment00.NUMBER, position);
				break;
				
			case 1:
				fragment = new Fragment01();
				args.putInt(Fragment01.NUMBER, position);
				break;
				
			case 2:
				fragment = new Fragment02();
				args.putInt(Fragment02.NUMBER, position);
				break;
			case 3:
				fragment = new Fragment03();
				args.putInt(Fragment03.NUMBER, position);
				break;
			case 4:
				fragment = new Fragment04();
				args.putInt(Fragment04.NUMBER, position);
				break;
			case 5:
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
		    mDrawerList.setItemChecked(position, true);
		    setTitle(mTitles[position]);
		    mDrawerLayout.closeDrawer(mDrawerList);
	}
	
	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}
}
