package com.scnu.imutest;

import android.content.Context;
import android.content.Intent;

public class ListCellData {
	private String ListName="";
	private Context context=null;
	private Intent RelatIntent=null;
	
	public ListCellData(Context context,String ListName,Intent RelatIntent) {
		this.context=context;
		this.ListName=ListName;
		this.RelatIntent=RelatIntent;
	}
	
	public String getListName() {
		return ListName;
	}
	
	public Context getContext() {
		return context;
	}
	
	public Intent getRelatIntent() {
		return RelatIntent;
	}
	

	
	public void StarActivity()
	{
		getContext().startActivity(getRelatIntent());
	}
	
	@Override
	public String toString() {
		return getListName();
	}

}
