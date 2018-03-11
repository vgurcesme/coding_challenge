package com.ing.interview.codingchallenge;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterException;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

public class TwitterFilterStream {
	private final Object lock = new Object();

	public List<Status> execute(Date timeLimit,int maximumRecords,String track) throws TwitterException {
		List<Status> statuses = new ArrayList<Status>();

		//Init twitter stream
		TwitterStream twitterStream = new TwitterStreamFactory().getInstance();

		StatusListener listener = new StatusListener() {
			public void onStatus(Status status) {

				statuses.add(status);
				//Retrieve the incoming messages for 30 seconds or up to 100 messages, whichever happens first.
				//If timelimit is null there is no time limit
				if (statuses.size() >= maximumRecords || (timeLimit!=null&&new Date().after(timeLimit))) {
					synchronized (lock) {
						lock.notify();
					}
				}

			}

			public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
				System.out.println("Got a status deletion notice id:" + statusDeletionNotice.getStatusId());
			}

			public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
				System.out.println("Got track limitation notice:" + numberOfLimitedStatuses);
			}

			public void onScrubGeo(long userId, long upToStatusId) {
				System.out.println("Got scrub_geo event userId:" + userId + " upToStatusId:" + upToStatusId);
			}

			public void onStallWarning(StallWarning warning) {
				System.out.println("Got stall warning:" + warning);
			}

			public void onException(Exception ex) {
				ex.printStackTrace();
			}
		};

		twitterStream.addListener(listener);

		//Set the track keyword
		twitterStream.filter(new FilterQuery(track));

		try {
			synchronized (lock) {
				lock.wait();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		twitterStream.shutdown();
		
		return statuses;
	}
}
