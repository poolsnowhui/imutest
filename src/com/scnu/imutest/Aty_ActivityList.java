package com.scnu.imutest;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class Aty_ActivityList extends Activity implements OnItemClickListener {

	private ListView lv;
	private ArrayAdapter<ListCellData> adapter;
	private int numTouch=1;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_list);

		lv=(ListView) findViewById(R.id.listView1);
		adapter=new ArrayAdapter<ListCellData>(this, android.R.layout.simple_list_item_1);
		findViewById(R.id.btnAdd).setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				adapter.add(new ListCellData(Aty_ActivityList.this, "����"+numTouch+"\n",new Intent(Aty_ActivityList.this, Aty_EditAssignment.class)));
				numTouch++;				
			}
		});

		lv.setAdapter(adapter);
		lv.setOnItemClickListener(this);


	}


//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}
//
//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//
//		int id = item.getItemId();
//		if (id == R.id.action_settings) {
//			return true;
//		}
//		return super.onOptionsItemSelected(item);
//	}


	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		ListCellData data=adapter.getItem(position);
		data.StarActivity();

	}
}
