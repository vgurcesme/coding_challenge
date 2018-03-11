package com.ing.interview.codingchallenge;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ing.interview.codingchallenge.helper.FileHelper;
import com.ing.interview.codingchallenge.mock.StatusMock;
import com.ing.interview.codingchallenge.mock.UserMock;
import com.ing.interview.codingchallenge.output.Output;
import com.ing.interview.codingchallenge.output.OutputFactory;
import com.ing.interview.codingchallenge.output.OutputTypes;

import junit.framework.TestCase;
import twitter4j.Status;

public class OutputTest extends TestCase {

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

		String content = new StatusPresenter().getContent(statuses);

		String fileName=FileHelper.getLogFileName();
		// Record the output
		OutputFactory outputFactory = new OutputFactory();
		Output output = outputFactory.getOutput(OutputTypes.FILE);
		output.save(content,fileName);

		File file = new File(fileName);
		
		assertTrue(file.exists());
		
		String fileContent=new String(Files.readAllBytes(Paths.get(fileName)));
		
		assertTrue(fileContent.equals(content));
	}

}
