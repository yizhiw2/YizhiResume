package com.yizhi.yizhiresume.fragments;

public class Fragment04 extends ExpandableListViewFragment
{

	@Override
	String[] getGroupStrings() {
		String[] grouptmp = new String[]
				{
					"Java:�ۻ�ͳ�ƹ���С���",
					"Android:���׼���Ӧ��",
					"Android:����Ӧ��"
				};
		return grouptmp;
	}

	@Override
	String[][] getDetails() {
		String[][] details = new String[][]
				{
					{"�Ӵ�����������̵�˼�룬ѧϰ��javaͼ�ν��濪��������"},
					{"ѧϰ��ʹ��Eclipse����AndroidӦ�õ����̣�"
							+ "ѧϰ�����û������ģ�ѧϰ�˼����ݿ�Ŀ���"},
					{"ѧϰ�����������Ľ���"}
				};
		return details;
	}

	@Override
	void setBackground() {
		//ll.setBackground(R.color.background_dark);	
	}
	
}
