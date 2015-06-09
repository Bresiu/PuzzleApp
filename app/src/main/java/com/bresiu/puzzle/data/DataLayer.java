package com.bresiu.puzzle.data;

import android.content.ContentResolver;

import com.bresiu.puzzle.network.RestRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by Bresiu on 09-06-2015
 */
public class DataLayer {
	private final RestRepository restRepository;
	private final GitHubRepositoryStore gitHubRepositoryStore;
	private final GitHubRepositorySearchStore gitHubRepositorySearchStore;
	private final UserSettingsStore userSettingsStore;

	public DataLayer(ContentResolver contentResolver) {
		this.restRepository = new RestRepository();
		gitHubRepositoryStore = new GitHubRepositoryStore(contentResolver);
		gitHubRepositorySearchStore = new GitHubRepositorySearchStore(contentResolver);
		userSettingsStore = new UserSettingsStore(contentResolver);
	}

	public Observable<GitHubRepositorySearch> getGitHubRepositorySearch(final String search) {
		Observable.<List<GitHubRepository>>create((subscriber) -> {
			try {
				Map<String, String> params = new HashMap<>();
				params.put("q", search);
				List<GitHubRepository> results = networkApi.search(params);
				subscriber.onNext(results);
				subscriber.onCompleted();
			} catch (Exception e) {
				subscriber.onError(e);
			}
		})
				.subscribeOn(Schedulers.computation())
				.map((repositories) -> {
					final List<Integer> repositoryIds = new ArrayList<>();
					for (GitHubRepository repository : repositories) {
						gitHubRepositoryStore.put(repository);
						repositoryIds.add(repository.getId());
					}
					return new GitHubRepositorySearch(search, repositoryIds);
				})
				.subscribe(gitHubRepositorySearchStore::put);
		return gitHubRepositorySearchStore.getStream(search);
	}

	public Observable<GitHubRepository> getGitHubRepository(Integer repositoryId) {
		return gitHubRepositoryStore.getStream(repositoryId);
	}

	public Observable<GitHubRepository> fetchAndGetGitHubRepository(Integer repositoryId) {
		fetchGitHubRepository(repositoryId);
		return getGitHubRepository(repositoryId);
	}

	private void fetchGitHubRepository(Integer repositoryId) {
		Observable.<GitHubRepository>create(subscriber -> {
			try {
				GitHubRepository repository = networkApi.getRepository(repositoryId);
				subscriber.onNext(repository);
				subscriber.onCompleted();
			} catch (Exception e) {
				subscriber.onError(e);
			}
		})
				.subscribeOn(Schedulers.computation())
				.subscribe(gitHubRepositoryStore::put);
	}

	public Observable<UserSettings> getUserSettings() {
		return userSettingsStore.getStream(UserSettingsStore.DEFAULT_USER_ID);
	}

	public void setUserSettings(UserSettings userSettings) {
		userSettingsStore.insertOrUpdate(userSettings);
	}

	public interface GetUserSettings {
		Observable<UserSettings> call();
	}

	public interface SetUserSettings {
		void call(UserSettings userSettings);
	}

	public interface GetGitHubRepository {
		Observable<GitHubRepository> call(int repositoryId);
	}

	public interface FetchAndGetGitHubRepository extends GetGitHubRepository {

	}

	public interface GetGitHubRepositorySearch {
		Observable<GitHubRepositorySearch> call(String search);
	}
}
