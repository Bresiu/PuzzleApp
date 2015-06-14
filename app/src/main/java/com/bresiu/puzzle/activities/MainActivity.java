package com.bresiu.puzzle.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bresiu.puzzle.R;
import com.bresiu.puzzle.fragments.JobsSearchFragment;

/**
 * Created by Bresiu on 09-06-2015
 */
public class MainActivity extends AppCompatActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new JobsSearchFragment())
					.commit();
		}
	}
}
