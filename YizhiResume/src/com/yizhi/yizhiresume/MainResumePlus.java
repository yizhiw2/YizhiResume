package com.yizhi.yizhiresume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yizhi.yizhiresume.fragments.Fragment00;
import com.yizhi.yizhiresume.fragments.Fragment01;
import com.yizhi.yizhiresume.fragments.Fragment02;
import com.yizhi.yizhiresume.fragments.Fragment03;
import com.yizhi.yizhiresume.fragments.Fragment04;
import com.yizhi.yizhiresume.fragments.Fragment05;
import com.yizhi.yizhiresume.fragments.Fragment06;

import android.R.integer;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.ListFragment;
import android.content.ContentProviderOperation;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.StructuredName;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

@SuppressLint("ShowToast")
public class MainResumePlus extends Activity
	implements OnItemClickListener,Fragment06.Callbacks
{
	boolean addSuccess = false;
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
				R.drawable.book_2,
				R.drawable.mobile_2,
				
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
			case 6:
				fragment = new Fragment06();
				args.putInt(Fragment06.NUMBER, position);
				break;
				
			default:
				break;
			}

		    fragment.setArguments(args);

			    // Insert the fragment by replacing any existing fragment
			android.app.FragmentManager fragmentManager = getFragmentManager();
			fragmentManager.beginTransaction()
			           	.replace(R.id.content_frame, fragment)
//			            .addToBackStack(null) //加入后退栈中
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



	@Override
	public void onButtonClick(View v) {
		// TODO Auto-generated method stub
		String phone_number = getResources()
				.getString(R.string.phone_number);
		String email_address = getResources()
				.getString(R.string.email_address);
		String email_subject = getResources()
				.getString(R.string.email_subject);
		String name = getResources()
				.getString(R.string.name);
		String qq_number = getResources()
				.getString(R.string.qq_number);
		
		Intent intent = null;
		switch (v.getId()) {
		case R.id.call:
			 intent = new Intent(Intent.ACTION_CALL,
					 Uri.parse("tel:"+phone_number));  
             startActivity(intent);  
			break;
		case R.id.message:
			intent = new Intent(Intent.ACTION_VIEW,
					Uri.parse("smsto:"+phone_number));
            startActivity(intent);  
			break;
		case R.id.email:
			intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(   
					"mailto", email_address, null));   
            intent.putExtra(Intent.EXTRA_SUBJECT,email_subject);  
			startActivity(intent);
			break;
		case R.id.saveto:
			addContact(MainResumePlus.this,
					name,
					qq_number,
					phone_number,
					email_address,
					"github.com/yizhiw2");
			if(addSuccess == true)
			Toast.makeText(MainResumePlus.this, 
					"已添加到联系人",
					1000)
					.show();
			break;
		default:
			break;
		}
	}

	//保存到联系人
	private void addContact(Context context, String name,
			String qq, String phone, String email, String website)
	{
		ArrayList<ContentProviderOperation> ops = 
				new ArrayList<ContentProviderOperation>();

		//在名片表插入一个新名片
		ops.add(ContentProviderOperation.newInsert(
				ContactsContract.RawContacts.CONTENT_URI)
		.withValue(ContactsContract.RawContacts.ACCOUNT_TYPE, null)
		//.withValue(ContactsContract.RawContacts._ID, 0) //
		.withValue(ContactsContract.RawContacts.ACCOUNT_NAME, null)
		.withValue(ContactsContract.RawContacts.AGGREGATION_MODE,
				ContactsContract.RawContacts.AGGREGATION_MODE_DISABLED)
				.build());
		Log.i("--add-new--","ok!!!!");
		// add name
		//添加一条新名字记录；对应RAW_CONTACT_ID为0的名片
		if (!name.equals("")) {
			ops.add(ContentProviderOperation.
					newInsert(ContactsContract.Data.CONTENT_URI)
					.withValueBackReference(ContactsContract
							.Data.RAW_CONTACT_ID, 0)
					.withValue(ContactsContract.Data.MIMETYPE,
							ContactsContract.CommonDataKinds
							.StructuredName.CONTENT_ITEM_TYPE)
							.withValue(ContactsContract.CommonDataKinds
									.StructuredName.DISPLAY_NAME,name)
									.build());
		
		}
		Log.i("--add-name--","ok!!!!");
		// add phone
		if (!phone.equals("")) {
		ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
		.withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, 0)
		.withValue(ContactsContract.Data.MIMETYPE,
		ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE).withValue(ContactsContract.CommonDataKinds.Phone.NUMBER,phone).withValue(ContactsContract.CommonDataKinds.Phone.TYPE,1).build());
		}
		Log.i("--add-phone--","ok!!!!");
		// add email
		if (!email.equals("")) {
		ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
		.withValueBackReference(
		ContactsContract.Data.RAW_CONTACT_ID, 0).withValue(
		ContactsContract.Data.MIMETYPE,ContactsContract.CommonDataKinds.Email.CONTENT_ITEM_TYPE).withValue(ContactsContract.CommonDataKinds.Email.DATA,email).withValue(ContactsContract.CommonDataKinds.Email.TYPE,1).build());
		}
		Log.i("--add-email-","ok!!!!");
		// add website
		if (!website.equals("")) {
		ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
		.withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, 0)
		.withValue(ContactsContract.Data.MIMETYPE,
		ContactsContract.CommonDataKinds.Website.CONTENT_ITEM_TYPE).withValue(
		ContactsContract.CommonDataKinds.Website.URL,website)
		.withValue(
		ContactsContract.CommonDataKinds.Website.TYPE,
		ContactsContract.CommonDataKinds.Website.TYPE_WORK).build());
		}
		Log.i("--add-website--","ok!!!!");
		
		// add qq
		
		ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference(
		ContactsContract.Data.RAW_CONTACT_ID, 0).withValue(
		ContactsContract.Data.MIMETYPE,
		ContactsContract.CommonDataKinds.Im.CONTENT_ITEM_TYPE).withValue(
		ContactsContract.CommonDataKinds.Im.DATA1,qq)
		.withValue(
		ContactsContract.CommonDataKinds.Im.PROTOCOL,
		ContactsContract.CommonDataKinds.Im.PROTOCOL_QQ).build());
		
		try {
			context.getContentResolver().applyBatch(
			ContactsContract.AUTHORITY, ops);
			addSuccess = true;
			} catch (Exception e){
				Log.i("---saveto---","添加失败");
		}
	}


	
}

