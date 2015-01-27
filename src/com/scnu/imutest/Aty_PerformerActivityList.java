package com.scnu.imutest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Aty_PerformerActivityList extends Activity {

	private TextView tvActivityContext,tvActivityTime,tvActivityID;
 	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_performer_activity_list);
		tvActivityID=(TextView) findViewById(R.id.tvActivityID);
		tvActivityTime=(TextView) findViewById(R.id.tvActivityTime);
		tvActivityContext=(TextView) findViewById(R.id.tvActivityContext);
		Bundle bundle=new Bundle();
		bundle=this.getIntent().getExtras();
		tvActivityID.setText(bundle.getString("id"));
		tvActivityContext.setText(bundle.getString("context"));
		tvActivityTime.setText(bundle.getString("time"));
		
		findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i=new Intent(Aty_PerformerActivityList.this, Aty_Main.class);
				
				startActivity(i);
			}
		});
	}
}
