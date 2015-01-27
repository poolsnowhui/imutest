package com.scnu.imutest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class Aty_Welcome extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        
        
        new Thread(){
        	
        	
        	public void run() {
        		try {
					Thread.sleep(1000);
					Intent i=new Intent(Aty_Welcome.this,Aty_Main.class);
					startActivity(i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
        	};
        }.start();
        
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        if (id == R.id.action_settings) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}
