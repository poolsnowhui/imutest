package com.scnu.imutest;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Aty_EditAssignment extends Activity {
	
	//定义
		private TextView theme;      //定义主题文本框变量
		private TextView time;        //定义截止时间文本框变量
		private TextView message;    //定义内容文本框变量
		private EditText m_theme;    //定义主题输入框变量
		private EditText m_time;     //定义截止时间输入框变量
		private EditText m_message;  //定义内容输入框变量
		private String s_department;  //社团字符串
		private String s_theme;          //主题字符串
		private String s_time;            //截止时间字符串
		private String s_message;     //内容字符串
		private Bundle bundle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_assignment);
		/*获得TextView对象*/
		theme=(TextView)findViewById(R.id.theme);
		time=(TextView)findViewById(R.id.time);
		message=(TextView)findViewById(R.id.message);
		/*获得EditText对象*/
		m_theme=(EditText)findViewById(R.id.T_Text);
		m_time=(EditText)findViewById(R.id.Time);
		m_message=(EditText)findViewById(R.id.Message);
		
		//receiveMessage();
		
		/*设置EditText显示的文字*/
		m_theme.setHint("请输入活动主题");
		m_time.setHint("请输入截止时间");
		m_message.setHint("请输入任务内容");
		/*获得Button对象*/
		final Button back=(Button)findViewById(R.id.back);
		final Button save=(Button)findViewById(R.id.save);
		final Button next=(Button)findViewById(R.id.next);
		
		/*设置事件监听*/
		back.setOnClickListener(backOnClick);
		save.setOnClickListener(saveOnClick);
		next.setOnClickListener(nextOnClick);
	}
	
	/*获取前一个Activity传递过来的数据*/
	private void receiveMessage()
	{
		Bundle bundle=this.getIntent().getExtras();
		
		s_department=bundle.getString("KEY_DEPARTMENT");
		s_theme=bundle.getString("KEY_THEME");
		s_time=bundle.getString("S_TIME");
		s_message=bundle.getString("KEY_MESSAGE");
		
		m_theme.setText(s_theme);
		m_time.setText(s_time);
		m_message.setText(s_message);
	}
	
	/*将Activity的数据打包并传递到下一个Activity*/
	public void getMessage()
	{
		s_theme=m_theme.getText().toString();
		s_time=m_time.getText().toString();
		s_message=m_message.getText().toString();
		
		bundle=new Bundle();
		bundle.putString("KEY_DEPARTMENT",s_department);
		bundle.putString("KEY_THEME",s_theme);
		bundle.putString("KEY_TIME",s_time);
		bundle.putString("KEY_MESSAGE",s_message);
	}
	
	public void DisplayToast(String str)
	{
		Toast toast=Toast.makeText(this,str,Toast.LENGTH_SHORT);
		toast.setGravity(Gravity. TOP, 0,220);
		toast.show();
	}
	
	//返回按钮响应函数
	private Button.OnClickListener backOnClick=new Button.OnClickListener()
	{
		public void onClick(View u)
		{
			finish();
		}
	};
	
	//保存按钮响应函数
	private Button.OnClickListener saveOnClick=new Button.OnClickListener()
	{
		public void onClick(View v)
		{
			Intent intent=new Intent();
			getMessage();
		    intent.putExtras(bundle);
		    setResult(RESULT_OK,intent);
			DisplayToast("保存任务信息成功");
		}
	};
	
	//人员分配按钮响应函数
	private Button.OnClickListener nextOnClick=new Button.OnClickListener()
	{
		public void onClick(View w)
		{
			AlertDialog.Builder nextDlg=new AlertDialog.Builder(Aty_EditAssignment.this);
			nextDlg.setTitle("提醒");
			nextDlg.setMessage("是否跳转到人员分配界面？");
			nextDlg.setIcon(android.R.drawable.ic_dialog_info);
			nextDlg.setCancelable(false);
			nextDlg.setPositiveButton("否",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
						}
					});
			nextDlg.setNegativeButton("是", 
					new DialogInterface.OnClickListener() {	
						@Override
						public void onClick(DialogInterface dialog, int which) {
							Intent it=new Intent();
							it.setClass(Aty_EditAssignment.this,Aty_PeopleArrange.class);
							getMessage();
							it.putExtras(bundle);
							startActivity(it);	
						}
					});
			nextDlg.show();
		}
	};

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}
//
//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//		// Handle action bar item clicks here. The action bar will
//		// automatically handle clicks on the Home/Up button, so long
//		// as you specify a parent activity in AndroidManifest.xml.
//		int id = item.getItemId();
//		if (id == R.id.action_settings) {
//			return true;
//		}
//		return super.onOptionsItemSelected(item);
//	}
}
