package com.ing.interview.codingchallenge;

import twitter4j.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.ing.interview.codingchallenge.helper.FileHelper;
import com.ing.interview.codingchallenge.helper.PropsHelper;
import com.ing.interview.codingchallenge.output.Output;
import com.ing.interview.codingchallenge.output.OutputFactory;
import com.ing.interview.codingchallenge.output.OutputTypes;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) throws TwitterException {

		if (args.length < 1) {
            System.out.println("Usage: java com.ing.interview.codingchallenge.app [track keyword]");
            System.exit(-1);
        }
		
		//Get config for Retrieve the incoming messages for X seconds
		int maximumRecords = Integer
				.parseInt(PropsHelper.getPropValue("codingchallenge.properties", "http.stream.maximumrecords"));

		Date timeLimit = new Date();
		Calendar calendar = Calendar.getInstance();
		//Get config for Retrieve the incoming messages up to X messages
		calendar.add(Calendar.SECOND,
				Integer.parseInt(PropsHelper.getPropValue("codingchallenge.properties", "http.stream.timelimit")));
		timeLimit = calendar.getTime();

		TwitterFilterStream stream = new TwitterFilterStream();
		List<Status> statuses = stream.execute(timeLimit,maximumRecords,args[0]);

		// Users sorted chronologically, ascending
		// The messages per user should also be sorted chronologically,
		// ascending
		Collections.sort(statuses, new StatusComparator());

		// Get the content per format
		String content = new StatusPresenter().getContent(statuses);
		// Record the output
		OutputFactory outputFactory = new OutputFactory();
		Output output = outputFactory.getOutput(OutputTypes.FILE);
		output.save(content,FileHelper.getLogFileName());

	}

}
