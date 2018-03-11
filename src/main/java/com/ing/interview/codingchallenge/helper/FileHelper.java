package com.ing.interview.codingchallenge.helper;

import java.util.Date;

public class FileHelper {

	public static String getLogFileName()
	{
		return "StatusLog_" + new Date().getTime();
	}
}
