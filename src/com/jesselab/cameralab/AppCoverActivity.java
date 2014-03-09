/**
 * 
 */
package com.jesselab.cameralab;

import com.jesselab.androidcameralab.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

/**
 * @author JesseAndAlice
 *
 */
public class AppCoverActivity extends Activity {
	private static long APP_COVER_MILLIS = 500;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		LayoutInflater inflater = LayoutInflater.from(this);
		RelativeLayout layout = (RelativeLayout)inflater.inflate(R.layout.app_cover, null, false);
		addContentView(layout, new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT));
/*		
		final Handler handler = new Handler();
		handler.postDelayed(new Runnable(){
			@Override
			public void run(){
				
			}
		}, APP_COVER_MILLIS);
*/		
	}
}
