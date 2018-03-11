package com.ing.interview.codingchallenge.helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropsHelper {

	public static String getPropValue(String propFile, String key) {
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream(propFile);

			// load a properties file
			prop.load(input);

			return prop.getProperty(key);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
