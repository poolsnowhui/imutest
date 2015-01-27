package com.scnu.imutest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Aty_PersonnelList extends Activity implements OnClickListener {


	@SuppressWarnings("unused")
	private LinearLayout.LayoutParams LP_MM=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
	private LinearLayout.LayoutParams LP_MW=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
	private String[] name={"逗比比-余湘如","逗比比-冼立志","逗比比-黄炫","逗比比-龙宇文"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_personnel_list);
		selectPersonnel(name);
		findViewById(R.id.btnYes).setOnClickListener(this);
	}

	private void selectPersonnel(String[] name) {
		for (int i = 0; i < name.length; i++) {
			LinearLayout lllist=(LinearLayout) findViewById(R.id.lllist);
			CheckBox cb=new CheckBox(this);
			System.out.println(2);
			cb.setLayoutParams(LP_MW);
			System.out.println(3);
			cb.setText(name[i]);
			System.out.println(4);
			lllist.addView(cb, LP_MW);
			System.out.println(5);
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnYes:
			finishPersonnelChoice();
			break;

		default:
			break;
		}
	}

	private void finishPersonnelChoice() {
		Toast.makeText(this, "跳转至人员安排", Toast.LENGTH_SHORT).show();
		Intent iPersonnelPlacement=new Intent(Aty_PersonnelList.this, Aty_PeopleArrange.class);
		startActivity(iPersonnelPlacement);
	}
}
