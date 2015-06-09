package com.bresiu.puzzle.views.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bresiu.puzzle.R;
import com.bresiu.puzzle.views.activities.fragments.JobsSearchFragment;


/**
 * Created by Bresiu on 29-05-2015
 */
public class MainActivity extends AppCompatActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.job_search_activity);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new JobsSearchFragment())
					.commit();
		}
	}
}