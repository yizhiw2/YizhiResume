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
					"��Ϥ�����﷨","����ָ�����","���ջ������ݽṹ���㷨"
				},
				{
					"��Ϥ�����﷨","������������˼��","�˽�ͼ�ν��濪��",
					"�˽���̴߳���"
				},
				{
					"��Ϥϵͳ�ܹ�","����Eclipse����Android����","�˽����ݿ⿪��"
				},
				{
					"�˽�XML","�˽�Matlab","�˽����ģʽ","�˽�git��������"
				}
				
		
		};
		return details;
	}
	@Override
	void setBackground() {
		
	}
}
