package com.yizhi.yizhiresume.fragments;

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
					{"接触了面向对象编程的思想，学习了java图形界面开发的流程"},
					{"学习了使用Eclipse开发Android应用的流程，"
							+ "学习了与用户交互的，学习了简单数据库的开发"},
					{"学习了制作精美的界面"}
				};
		return details;
	}

	@Override
	void setBackground() {
		//ll.setBackground(R.color.background_dark);	
	}
	
}
