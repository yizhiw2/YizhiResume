package com.yizhi.yizhiresume.fragments;

/*
 * ��̼���
 * 
 * �̳�ExpandableListViewFragment
 * 
 * */

public class Fragment03 extends ExpandableListViewFragment {


	@Override
	String[] getGroupStrings() {
		String[] grouptmp= new String[]
		{
//			δչ����ʾ
			"C" ,"Java","Android","Other"	
		};
		return grouptmp;
	}
	@Override
	String[][] getDetails() {
		String[][] details = new String[][]
		{
//				չ������ʾ
				{
					"��Ϥ�����﷨","����ָ�����","���ջ������ݽṹ���㷨"
				},
				{
					"��Ϥ�����﷨","������������˼��","�˽�ͼ�ν��濪��",
					"�˽���̴߳���"
				},
				{
					"�˽������������","�˽�SDK����","�˽����ݿ⿪��"
				},
				{
					"�˽�XML","�˽�Matlab","�˽����ģʽ","�˽�git��������"
				}
				
		
		};
		return details;
	}
	//δʵ��
	@Override
	void setBackground() {
			
	}
}
