package com.bresiu.puzzle.views.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bresiu.puzzle.R;
import com.bresiu.puzzle.viewmodels.JobsSearchViewModel;

/**
 * Created by Bresiu on 09-06-2015
 */
public class JobsSearchFragment extends Fragment {
	private JobsSearchViewModel jobsSearchViewModel;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.jobsSearchViewModel = new JobsSearchViewModel();
		//this.jobsSearchViewModel.getSelectRepository()
		//		.subscribe(repository -> ((ChooseRepositoryActivity) getActivity()).chooseRepository(repository.getId()));
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.repositories_fragment, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		repositoriesView = (RepositoriesView) view.findViewById(R.id.repositories_view);
		this.jobsSearchViewModel.subscribeToDataStore();
	}

	@Override
	public void onResume() {
		super.onResume();
		repositoriesView.setViewModel(this.jobsSearchViewModel);
	}

	@Override
	public void onPause() {
		super.onPause();
		repositoriesView.setViewModel(null);
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		this.jobsSearchViewModel.unsubscribeFromDataStore();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		this.jobsSearchViewModel.dispose();
		this.jobsSearchViewModel = null;
	}
}
