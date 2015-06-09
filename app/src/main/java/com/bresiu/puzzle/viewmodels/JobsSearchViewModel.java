package com.bresiu.puzzle.viewmodels;

import android.util.Log;

import com.bresiu.puzzle.PuzzleApplication;
import com.bresiu.puzzle.data.DataLayer;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import rx.Observable;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Bresiu on 09-06-2015
 */
public class JobsSearchViewModel extends AbstractViewModel {
	private static final String TAG = JobsSearchViewModel.class.getSimpleName();

	private static final int MAX_REPOSITORIES_DISPLAYED = 5;

	@Inject
	DataLayer.GetGitHubRepositorySearch getGitHubRepositorySearch;

	@Inject
	DataLayer.GetGitHubRepository getGitHubRepository;

	private final PublishSubject<Observable<String>> searchString = PublishSubject.create();
	private final PublishSubject<GitHubRepository> selectRepository = PublishSubject.create();

	private final BehaviorSubject<List<GitHubRepository>> repositories
			= BehaviorSubject.create();

	public JobsSearchViewModel() {
		PuzzleApplication.getInstance().getGraph().inject(this);
		Log.v(TAG, "RepositoriesViewModel");
	}

	@Override
	protected void subscribeToDataStoreInternal(CompositeSubscription compositeSubscription) {
		Log.v(TAG, "subscribeToDataStoreInternal");

		compositeSubscription.add(
				Observable.switchOnNext(
						Observable.switchOnNext(searchString)
								.filter((string) -> string.length() > 2)
								.throttleLast(500, TimeUnit.MILLISECONDS)
								.map(getGitHubRepositorySearch::call))
						.flatMap((repositorySearch) -> {
							Log.d(TAG, "Found " + repositorySearch.getItems().size() +
									" repositories with search " + repositorySearch.getSearch());
							final List<Observable<GitHubRepository>> observables = new ArrayList<>();
							for (int repositoryId : repositorySearch.getItems()) {
								Log.v(TAG, "Process repositoryId: " + repositoryId);
								final Observable<GitHubRepository> observable =
										getGitHubRepository.call(repositoryId)
												.doOnNext((repository) ->
														Log.v(TAG, "Received repository " + repository.getId()));
								observables.add(observable);
								if (observables.size() >= MAX_REPOSITORIES_DISPLAYED) {
									break;
								}
							}
							return Observable.combineLatest(
									observables,
									(args) -> {
										Log.v(TAG, "Combine items into a list");
										final List<GitHubRepository> list = new ArrayList<>();
										for (Object repository : args) {
											list.add((GitHubRepository) repository);
										}
										return list;
									}
							);
						})
						.subscribe((repositories) -> {
							Log.d(TAG, "Publishing " + repositories.size() + " repositories from the ViewModel");
							RepositoriesViewModel.this.repositories.onNext(repositories);
						}));
	}

	public Observable<List<GitHubRepository>> getRepositories() {
		return repositories;
	}

	public void setSearchStringObservable(Observable<String> searchStringObservable) {
		this.searchString.onNext(searchStringObservable);
	}

	public void selectRepository(GitHubRepository repository) {
		this.selectRepository.onNext(repository);
	}

	public Observable<GitHubRepository> getSelectRepository() {
		return selectRepository;
	}
}
