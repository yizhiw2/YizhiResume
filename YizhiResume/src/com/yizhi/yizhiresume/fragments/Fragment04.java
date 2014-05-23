package com.yizhi.yizhiresume.fragments;

/*
 * 个人项目
 * 
 * 继承ExpandableListViewFragment
 * 
 * */


public class Fragment04 extends ExpandableListViewFragment
{

	@Override
	String[] getGroupStrings() {
		String[] grouptmp = new String[]
				{
					"Java:售货统计管理小软件",
					"Android:简易记账应用",
					"Android:简历应用"
				};
		return grouptmp;
	}

	@Override
	String[][] getDetails() {
		String[][] details = new String[][]
				{
					{"接触了面向对象编程的思想；学习了java图形界面开发的流程"},
					{"学习了使用Eclipse开发Android应用的流程；"
							+ "学习了与用户交互的；学习了简单数据库的开发"},
					{"学习了实现一些较为复杂的控件，如 抽屉、动画等；"
							+ "学习了屏幕适配的一些技巧"}
				};
		return details;
	}

	//未实现
	@Override
	void setBackground() {
		//ll.setBackground(R.color.background_dark);	
	}
	
}
