package com.rahu.saini.fragmenttest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class StartActivity extends FragmentActivity {

	private static final String TAG = "StartActivity";
	private Fragment newFragment;
	private Button b1, b2, b3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		try {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_start);

			Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();

			b1 = (Button) findViewById(R.id.button1);
			b2 = (Button) findViewById(R.id.button2);
			b3 = (Button) findViewById(R.id.button3);
			b1.setOnClickListener(buttonClickListener);
			b2.setOnClickListener(buttonClickListener);
			b3.setOnClickListener(buttonClickListener);

			FragmentManager fm = this.getSupportFragmentManager();
			FragmentTransaction ft = fm.beginTransaction();

			StartFragment startFragment = new StartFragment();
			ft.add(R.id.selectedfragment, startFragment);
			ft.commit();
		} catch (Exception e) {
			Log.e(TAG, e.toString());
		}

	}

/*	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);

		Toast.makeText(this, "onConfigurationChanged", Toast.LENGTH_SHORT).show();

		setContentView(R.layout.activity_start);
	}
*/
	private OnClickListener buttonClickListener = new OnClickListener() {
		@Override
		public void onClick(View view) {
			try {
				switch (view.getId()) {
				case R.id.button1:
					newFragment = new Fragment1();
					break;
				case R.id.button2:
					newFragment = new Fragment2();
					break;
				case R.id.button3:
					newFragment = new Fragment3();
					break;
				default:
					newFragment = new StartFragment();
					break;
				}

				FragmentManager fm = getSupportFragmentManager();
				FragmentTransaction ft = fm.beginTransaction();
				ft.replace(R.id.selectedfragment, newFragment);
				ft.addToBackStack(null);
				ft.commit();

			} catch (Exception e) {
				Log.e(TAG, e.toString());
			}
		}
	};
}
