package com.ing.interview.codingchallenge.output;

import java.io.PrintWriter;
import java.util.Date;

public class FileOutput implements Output {

	@Override
	public void save(String content,String fileName) {
		try {
			PrintWriter writer = new PrintWriter(fileName);
			writer.print(content);
			writer.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
