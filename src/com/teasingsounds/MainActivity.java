package com.teasingsounds;

import android.support.v4.widget.SimpleCursorAdapter.ViewBinder;
import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;


public class MainActivity extends Activity implements View.OnClickListener{
	
	 ImageButton Firstimage;
     ImageButton Secondimage;
	 ImageButton Thirdimage;
	 TextView Firsttextview;
	 TextView Secondtextview;
	 TextView Thirdtextview;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
       // Intent newActivity = new Intent(MainActivity.this,second_layout.class);
/*        startActivity(newActivity);
*/        
        Firstimage=(ImageButton) findViewById(R.id.imageButton1);
        Secondimage=(ImageButton) findViewById(R.id.imageButton2);
        Thirdimage=(ImageButton) findViewById(R.id.imageButton3);
        
        Firstimage.setOnClickListener(this);
        Secondimage.setOnClickListener(this);
        Thirdimage.setOnClickListener(this);
        
    }
       /* Firstimage.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, second_layout.class);
				   
				   startActivity(intent);
				
			}
		});*/
    
    
    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.imageButton1:
            	Intent intent = new Intent(MainActivity.this, second_layout.class);
			    intent.putExtra("1stsong", "1");
			    
            	startActivity(intent);
            break;
            case R.id.imageButton2:
            Intent intent1 = new Intent(MainActivity.this, second_layout.class);
            intent1.putExtra("2ndsong", "2");
          //  intent1.putextra
		    startActivity(intent1);
            break;
            case R.id.imageButton3:
            	Intent intent2 = new Intent(MainActivity.this, second_layout.class);
            	intent2.putExtra("3rdsong", "3");
				    startActivity(intent2);

     
        
    }  
    
    }
}
        
    

   
    /*
    public void addListenerOnButton()
    {
    	Firstimage=findViewById(R.id.i)
    			  Firsttextview=findViewById(R.id.t)
    }

}
   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}*/
