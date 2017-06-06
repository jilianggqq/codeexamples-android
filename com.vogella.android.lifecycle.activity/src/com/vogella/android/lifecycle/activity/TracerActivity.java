package com.vogella.android.lifecycle.activity;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.util.Log;

public class TracerActivity extends Activity {
	String tag = this.getClass().getSimpleName();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(tag, "onCreate");
		notify("onCreate");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.d(tag, "onPause");
		notify("onPause");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.d(tag, "onResume");
		notify("onResume");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.d(tag, "onStop");
		notify("onStop");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d(tag, "onDestroy");
		notify("onDestroy");
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		Log.d(tag, "onRestoreInstanceState");
		notify("onRestoreInstanceState");
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		Log.d(tag, "onSaveInstanceState");
		notify("onSaveInstanceState");
	}

	private void notify(String methodName) {
		String name = this.getClass().getName();
		String[] strings = name.split("\\.");
		Notification noti = new Notification.Builder(this)
				.setContentTitle(methodName + " " + strings[strings.length - 1])
				.setAutoCancel(true).setSmallIcon(R.drawable.ic_launcher)
				.setContentText(name).build();
		NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		notificationManager.notify((int) System.currentTimeMillis(), noti);
	}

}
