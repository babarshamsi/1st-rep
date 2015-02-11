package com.teasingsounds;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class second_layout extends Activity  {
	ImageButton music;
	MediaPlayer firstsong,secondsong,thirdsong;
	 String song1;
	String temp;
	 private CountDownTimer countDownTimer;
	 private boolean timerHasStarted = false;
	 private Button startB;
	 public static TextView timerTextView;
	 private final long startTime = 10 * 1000;
	 private final long interval = 1 * 1000;
	 private int timercount=30;
	 TimerTask timerTask;
	  
	
	
	 /*TextView timerTextView;
	    long startTime = 0;

	    //runs without a timer by reposting this handler at the end of the runnable
	    Handler timerHandler = new Handler();
	    Runnable timerRunnable = new Runnable() {

	        @Override
	        public void run() {
	            long millis = System.currentTimeMillis() - startTime;
	            int seconds = (int) (millis / 1000);
	            int minutes = seconds / 60;
	            seconds = seconds % 60;

	            timerTextView.setText(String.format("%d:%02d", minutes, seconds));

	            timerHandler.postDelayed(this, 500);
	        }
	    };*/
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second_layout);
		 
		
		Intent intent = getIntent();
		if(intent.getExtras() != null)
		{
			
			song1 = intent.getExtras().getString("1stsong");
			if(song1==null)
			song1= intent.getExtras().getString("2ndsong");
			if(song1==null)
			song1= intent.getExtras().getString("3rdsong");
			
		
		}
		 startB = (Button) this.findViewById(R.id.button);
		// startB.setOnClickListener(this);
		  // startB.setOnClickListener((android.view.View.OnClickListener) this);
		   timerTextView = (TextView) this.findViewById(R.id.timerTextView);
		   
		 //  countDownTimer = new MyCountDownTimer(startTime, interval);
		//   countDownTimer.onTick(30000);
		   
		   timerTextView.setText( String.valueOf(startTime));
		   Button b = (Button) findViewById(R.id.button);
	       //  b.setText("start");
	         startB.setOnClickListener(new View.OnClickListener(){
		   @Override
		   
		    public void onClick(View v) {
		  try{ 
			  final Handler handler = new Handler();
			  final Timer timer = new Timer(false);
			  timerTask = new TimerTask() {
				    @Override
				    public void run() {
				        handler.post(new Runnable() {
				            @Override
				            public void run() {
				            	// firstsong.start();
				                // Do whatever you want
				            	if(timercount!=0)
				            	{
				            		timercount--;
				            		timerTextView.setText(Integer.toString(timercount));
				            		handler.postDelayed(this, 1000);
				            	//	timer.schedule(timerTask, 1000);
				            		//timer.
				            	}
				            	else
				            	{
				            		firstsong.start();
				            	}
				            }
				        });
				    }
				};
				timer.schedule(timerTask, 1000); // 10
		    /* if (!timerHasStarted) {
		   
		      countDownTimer.start();
		      timerHasStarted = true;
		      startB.setText("STOP");
		     } else {
		   		      countDownTimer.cancel();
		   		      timerHasStarted = false;
		   		      startB.setText("RESTART");
		   }*/}
		  catch(Exception ex)
		  {String error=ex.getMessage();}
		     }
	         });
		   
		   
		
		 /*timerTextView = (TextView) findViewById(R.id.timerTextView);

         Button b = (Button) findViewById(R.id.button);
         b.setText("start");
         b.setOnClickListener(new View.OnClickListener() {

             @Override
             public void onClick(View v) {
                 Button b = (Button) v;
                 if (b.getText().equals("stop")) {
                     timerHandler.removeCallbacks(timerRunnable);
                     b.setText("start");
                 } else {
                     startTime = System.currentTimeMillis();
                     timerHandler.postDelayed(timerRunnable, 0);
                     b.setText("stop");
                 }
             }
         });
     */
		
		
		firstsong=MediaPlayer.create(this, R.raw.tumhiho);
		  secondsong=MediaPlayer.create(this, R.raw.naamewafa);
		  thirdsong=MediaPlayer.create(this, R.raw.hamdard);
		  
		button();
	
		
	}
	
		
      public void button()
      {
    	 
    	 music=(ImageButton) findViewById(R.id.musicButton1);
    	 if(song1.equals("1"))
    	 {
    	 Drawable drawable= getResources().getDrawable(R.drawable.images);
    	 music.setImageDrawable(drawable);
    	 }
    	 else if(song1.equals("2"))
    	 {
    		 Drawable drawable= getResources().getDrawable(R.drawable.housefly);
        	 music.setImageDrawable(drawable); 
    	 }
    	 else if(song1.equals("3"))
    	 {
    		 Drawable drawable= getResources().getDrawable(R.drawable.bumble_bee);
        	 music.setImageDrawable(drawable); 
    	 }
    	 
    	// music=(ImageButton) findViewById(R.drawable.images);
    	 // firstsong=MediaPlayer.create(this, R.raw.tumhiho);
    	  music.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				if(song1.equals("1"))
				{
					
					 if(firstsong.isPlaying())
						 firstsong.pause();
					 else
						 firstsong.start();
					}
				else if (song1.equals("2"))
				{
					if(secondsong.isPlaying())
						secondsong.pause();
					 else
						 secondsong.start();
					}
				else if(song1.equals("3"))
				{
					if(thirdsong.isPlaying())
						thirdsong.pause();
					 else
						 thirdsong.start();
						}
				
				
			}

		
		});
    	  }
     
      @Override
		public void onBackPressed() {
    	  if(firstsong.isPlaying())
    	  firstsong.stop();
    	  else if(secondsong.isPlaying())
    		  secondsong.stop();
    	  else if(thirdsong.isPlaying())
    		  thirdsong.stop();
    	   super.onBackPressed(); 
 }
     /* @Override
      public void onPause() {
          super.onPause();
          timerHandler.removeCallbacks(timerRunnable);
          Button b = (Button)findViewById(R.id.button);
          b.setText("start");
      } */
    
}
      
      
      
      
	

