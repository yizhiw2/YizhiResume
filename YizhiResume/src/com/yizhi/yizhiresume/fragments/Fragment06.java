package com.yizhi.yizhiresume.fragments;

import com.yizhi.yizhiresume.R;

import android.R.integer;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

@SuppressLint("NewApi")
public class Fragment06 extends Fragment 
{
	@SuppressLint("NewApi")
	public static final String NUMBER = "number";
	Callbacks callbacks;
	private Button call;
	private Button message;
	private Button email;
	private Button saveto;
	
	 //fragment 创建时调用   ，判断有没继承接口
    public void onAttach(Activity activity) {
    	super.onAttach(activity);
	    	try {
	            callbacks = (Callbacks) activity;
	        } catch (ClassCastException e) {
	            	throw new ClassCastException(activity.toString() + 
	            		" must implements OnArticleSelectedListener");
	        }
	    }
    
	//实现与activity通信的借口
	public interface Callbacks {
	      	public void onButtonClick(View v);
	}
	
	/*@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
	       
	       
	       buttons = getActivity()
	    		   .getResources().getStringArray(R.array.btns);
//	       listView = (ListView)rootView.findViewById(R.id.);
	       this.setListAdapter(new ArrayAdapter<String>(
	    		   getActivity(),
	    		   android.R.layout.simple_list_item_1,
	    		   buttons));
		
	}*/
	
	@SuppressLint("NewApi")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
		   Bundle savedInstanceState) {
	       View rootView = inflater.inflate(
	    		   R.layout.fragment06,
	    		   container, 
	    		   false);
	       int i = getArguments().getInt(NUMBER);
	       String title = getResources().getStringArray(R.array.mTitles)[i];
	       getActivity().setTitle(title);
	       
	       call = (Button)rootView.findViewById(R.id.call);
	       message = (Button)rootView.findViewById(R.id.message);
	       email = (Button)rootView.findViewById(R.id.email);
	       saveto = (Button)rootView.findViewById(R.id.saveto);
	       
	       OnMyClickListener listener = new OnMyClickListener();
	       
	       call.setOnClickListener(listener);
	       message.setOnClickListener(listener);
	       email.setOnClickListener(listener);
	       saveto.setOnClickListener(listener);
	       
	       return rootView;
    }
	
	class OnMyClickListener implements OnClickListener
	{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			callbacks.onButtonClick(v);
		}
		
	}
/*  
	public void onDetach()
	{
		super.onDetach();
		callbacks = null;
	}
	*/
	/*public void onListItemClick(ListView listView,
			View view, int position, long id)
	{
		super.onListItemClick(listView, view, position, id);
		//callbacks.onItemSelected(position);
	}*/
	 
}