package com.ing.interview.codingchallenge;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ing.interview.codingchallenge.helper.PropsHelper;
import com.ing.interview.codingchallenge.mock.StatusMock;
import com.ing.interview.codingchallenge.mock.UserMock;

import junit.framework.TestCase;
import twitter4j.FilterQuery;
import twitter4j.RateLimitStatus;
import twitter4j.RawStreamListener;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

public class StreamAPITest extends TestCase {
	public void testConnection() throws TwitterException {

		// Test method for connection an authorization.
		// Test is based on oath2 configuration
		// If test fails the props below at twitter4j.properties shold be
		// checked
		// oauth.consumerKey,oauth.consumerSecret,oauth.accessToken,oauth.accessTokenSecret

		Twitter twitter = new TwitterFactory().getInstance();

		Map<String, RateLimitStatus> rateLimitStatus = twitter.getRateLimitStatus("search");
		RateLimitStatus searchTweetsRateLimit = rateLimitStatus.get("/search/tweets");
		assertNotNull(searchTweetsRateLimit);
	}

	public void testNoListener() throws Exception {

		// Test for listener configuration
		TwitterStream twitterStream;
		twitterStream = new TwitterStreamFactory().getInstance();

		try {
			twitterStream.filter(new FilterQuery("twitter"));
			fail("expecting IllegalStateException");
		} catch (IllegalStateException ignored) {
		}

		twitterStream.addListener(new RawStreamListener() {
			@Override
			public void onMessage(String rawString) {
			}

			@Override
			public void onException(Exception ex) {
			}
		});

		twitterStream.filter(new FilterQuery("twitter"));
		twitterStream.cleanUp();
		twitterStream.shutdown();

	}

	// Test for filtering messages that track on X
	// Test for retrieve the incoming messages up to X messages
	public void testStreamXMessage() throws Exception {
		TwitterFilterStream stream = new TwitterFilterStream();
		List<Status> statuses = stream.execute(null, 1, "twitter");
		assertTrue(statuses.size() == 1);
	}

	// Test for filtering messages that track on X
	// Test for retrieve the incoming messages up to X messages
	public void testStreamXSecond() throws Exception {
		Date timeLimit = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.SECOND,30);
		timeLimit = calendar.getTime();
		//Set maximumRecords big for testing time limit
		TwitterFilterStream stream = new TwitterFilterStream();
		stream.execute(timeLimit, 1000000, "twitter");
		assertTrue(new Date().after(timeLimit));
	}
	


}
