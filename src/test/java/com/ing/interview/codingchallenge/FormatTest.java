package com.ing.interview.codingchallenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.ing.interview.codingchallenge.mock.StatusMock;
import com.ing.interview.codingchallenge.mock.UserMock;

import junit.framework.TestCase;
import twitter4j.Status;

public class FormatTest extends TestCase {

	// users sorted chronologically, ascending
	// messages should also be sorted chronologically, ascending
	public void testSortStatuses() throws Exception {
		// S U
		// 1 2
		// 2 1
		// 1 1

		List<Status> statuses = new ArrayList<Status>();
		Date date1 = new Date();
		Date date2 = new Date();

		date1.setTime(1);
		date2.setTime(2);

		StatusMock status1 = new StatusMock();
		status1.setCreatedAt(date1);
		UserMock user1 = new UserMock();
		user1.setCreatedAt(date2);
		status1.setUser(user1);
		statuses.add(status1);

		StatusMock status2 = new StatusMock();
		status2.setCreatedAt(date2);
		UserMock user2 = new UserMock();
		user2.setCreatedAt(date1);
		status2.setUser(user2);
		statuses.add(status2);

		StatusMock status3 = new StatusMock();
		status3.setCreatedAt(date1);
		UserMock user3 = new UserMock();
		user3.setCreatedAt(date1);
		status3.setUser(user3);
		statuses.add(status3);

		Collections.sort(statuses, new StatusComparator());

		assertTrue(statuses.get(0).getCreatedAt().getTime() == 1);
		assertTrue(statuses.get(0).getUser().getCreatedAt().getTime() == 1);
	}

	
	public void testStatusContent() throws Exception {
		

		List<Status> statuses = new ArrayList<Status>();
		Date date1 = new Date();
		Date date2 = new Date();

		date1.setTime(1);
		date2.setTime(2);

		StatusMock status1 = new StatusMock();
		status1.setCreatedAt(date1);
		status1.setId(10);
		status1.setText("text");
		UserMock user1 = new UserMock();
		user1.setCreatedAt(date2);
		user1.setId(10);
		user1.setName("UserName");
		user1.setScreenName("UserScreenName");
		status1.setUser(user1);
		statuses.add(status1);

		

		assertTrue(new StatusPresenter().getContent(statuses).equals("10\t2\tUserName\tUserScreenName\t10\t1\ttext\n"));
	}
}
