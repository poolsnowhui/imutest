package com.scnu.imutest;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class Aty_PeopleArrange extends Activity implements OnItemClickListener {

	private ListView lv;
	private ArrayAdapter<ListCellData2> adapter;
//	private TextView tvTaskTheme;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println(1);
        setContentView(R.layout.activity_people_arrange);
        System.out.println(2);
        adapter = new ArrayAdapter<ListCellData2>(this, R.layout.list_cell_people_arrange);
        System.out.println(3);
      
        lv = (ListView) findViewById(R.id.lvPeople);
        System.out.println(4);
        lv.setAdapter(adapter);
        System.out.println(5);
        
//        tvTaskTheme = (TextView) findViewById(R.id.tvTaskTheme);
        System.out.println(6);
//        String taskTheme = this.getIntent().getBundleExtra("task").getString("taskTheme");
        System.out.println(7);
//        tvTaskTheme.setText(taskTheme);
        System.out.println(8);
        lv.setOnItemClickListener(this);
        System.out.println(9);
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//        if (id == R.id.action_settings) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }


	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		ListCellData2 data = adapter.getItem(position);
		
		Toast.makeText(this, String.format("����:%s ְλ:%s ����:%s ����:%s", data.getName(),data.getPosition(),data.getDepartment(),data.getClub()), Toast.LENGTH_SHORT).show();
	}
	
	public void startListPeople(View view){
		Intent intent = new Intent(this, Aty_PersonnelList.class);
		adapter.clear();
		startActivityForResult(intent, 0);
	}
	
	public ArrayList<ListCellData2> data=new ArrayList<ListCellData2>();
	@Override
	protected void onActivityResult(int arg0, int arg1, Intent arg2) {
		
		if(arg1==1)return;
		data = arg2.getExtras().getParcelableArrayList("list");
		for(ListCellData2 d:data){
			adapter.add(d);
		}
		lv.setAdapter(adapter);
		
		super.onActivityResult(arg0, arg1, arg2);
	}
	
	
	public void returnLast(View view){
		Intent intent = new Intent(this, Aty_EditAssignment.class);
		startActivity(intent);
		
	}
	
	public void btnRelease(View view){
		
		Toast.makeText(this, "�˹��ܴ�����", Toast.LENGTH_SHORT).show();

	}
}
