package com.bresiu.puzzle.data;

import android.content.ContentResolver;

import com.bresiu.puzzle.PuzzleApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Bresiu on 09-06-2015
 */
@Module
public final class DataStoreModule {

	@Provides
	public DataLayer.GetUserSettings provideGetUserSettings(DataLayer dataLayer) {
		return dataLayer::getUserSettings;
	}

	@Provides
	public DataLayer.SetUserSettings provideSetUserSettings(DataLayer dataLayer) {
		return dataLayer::setUserSettings;
	}

	@Provides
	public DataLayer.FetchAndGetGitHubRepository provideFetchAndGetGitHubRepository(DataLayer dataLayer) {
		return dataLayer::fetchAndGetGitHubRepository;
	}

	@Provides
	public DataLayer.GetGitHubRepositorySearch provideGetGitHubRepositorySearch(DataLayer dataLayer) {
		return dataLayer::getGitHubRepositorySearch;
	}

	@Provides
	public DataLayer.GetGitHubRepository provideGetGitHubRepository(DataLayer dataLayer) {
		return dataLayer::getGitHubRepository;
	}

	@Provides
	public ContentResolver contentResolver() {
		return PuzzleApplication.getInstance().getContentResolver();
	}

	@Provides
	@Singleton
	public DataLayer provideDataStoreModule(ContentResolver contentResolver) {
		return new DataLayer(contentResolver);
	}

}