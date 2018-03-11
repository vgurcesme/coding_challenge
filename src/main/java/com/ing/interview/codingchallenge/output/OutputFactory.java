package com.ing.interview.codingchallenge.output;

public class OutputFactory {

	public Output getOutput(OutputTypes outputType) {
		if (outputType.equals(OutputTypes.FILE))
			return new FileOutput();
		return null;
	}
}