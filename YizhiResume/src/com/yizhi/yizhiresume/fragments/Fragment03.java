package com.yizhi.yizhiresume.fragments;

/*
 * 编程技能
 * 
 * 继承ExpandableListViewFragment
 * 
 * */

public class Fragment03 extends ExpandableListViewFragment {


	@Override
	String[] getGroupStrings() {
		String[] grouptmp= new String[]
		{
//			未展开显示
			"C" ,"Java","Android","Other"	
		};
		return grouptmp;
	}
	@Override
	String[][] getDetails() {
		String[][] details = new String[][]
		{
//				展看后显示
				{
					"熟悉基本语法","掌握指针操作","掌握基本数据结构与算法"
				},
				{
					"熟悉基本语法","理解面向对象编程思想","了解图形界面开发",
					"了解多线程处理"
				},
				{
					"了解基本开发流程","了解SDK开发","了解数据库开发"
				},
				{
					"了解XML","了解Matlab","了解设计模式","了解git基本操作"
				}
				
		
		};
		return details;
	}
	//未实现
	@Override
	void setBackground() {
			
	}
}
