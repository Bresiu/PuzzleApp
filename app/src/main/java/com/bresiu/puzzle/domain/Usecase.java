package com.bresiu.puzzle.domain;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Bresiu on 30-05-2015
 */
public interface Usecase {
	Subscription execute(Subscriber subscriber);
}
