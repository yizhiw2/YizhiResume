package com.yizhi.yizhiresume.fragments;

public class Fragment03 extends ExpandableListViewFragment {


	@Override
	String[] getGroupStrings() {
		String[] grouptmp= new String[]
		{
			"C" ,"Java","Android","Other"	
		};
		return grouptmp;
	}
	@Override
	String[][] getDetails() {
		String[][] details = new String[][]
		{
				{
					"熟悉基本语法","掌握指针操作","掌握基本数据结构与算法"
				},
				{
					"熟悉基本语法","理解面向对象编程思想","了解图形界面开发",
					"了解多线程处理"
				},
				{
					"熟悉系统架构","掌握Eclipse进行Android开发","了解数据库开发"
				},
				{
					"了解XML","了解Matlab","了解设计模式","了解git基本操作"
				}
				
		
		};
		return details;
	}
	@Override
	void setBackground() {
		
	}
}
