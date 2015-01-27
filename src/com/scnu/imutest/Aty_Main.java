package com.scnu.imutest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class Aty_Main extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById(R.id.btnOrganiger).setOnClickListener(this);
		findViewById(R.id.btnPerformer).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnOrganiger:
			Intent iOrganiger=new Intent(Aty_Main.this, Aty_ActivityList.class);
			startActivity(iOrganiger);
			break;

		case R.id.btnPerformer:
			Intent iPerformer=new Intent(Aty_Main.this, Aty_PerformerAssignment.class);
			Bundle value=new Bundle();
			value.putString("id", "任务1");
			value.putString("context", "女生节搬桌子");
			value.putString("time", "2015年2月27日");
			iPerformer.putExtras(value);
			startActivity(iPerformer);
			break;
		default:
			break;
		}
		
	}
}
