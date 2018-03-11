package com.ing.interview.codingchallenge;

import java.util.Comparator;

import twitter4j.Status;

public class StatusComparator implements Comparator<Status> {

	// Users sorted chronologically, ascending
	// The messages per user should also be sorted chronologically,
	// ascending
	public int compare(Status a, Status b) {
		int userComparison = Long.compare(a.getUser().getCreatedAt().getTime(), b.getUser().getCreatedAt().getTime());
		return userComparison == 0 ? Long.compare(a.getCreatedAt().getTime(), b.getCreatedAt().getTime())
				: userComparison;
	}
}