package com.mateuszmidor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TextFileReader {
	private static Logger logger = LoggerFactory.getLogger(TextFileReader.class);
	private String filename;

	public TextFileReader(String filename) {
		this.filename = filename;
	}
	public String asSingleLine() {
		try (Scanner s = new Scanner(new FileReader(filename))
				.useDelimiter("\\Z")) {

			return s.next();
		} catch (FileNotFoundException e) {

			logger.error(e.getMessage());
			return new String();
		}
	}

	public List<String> asMultiLine() {
		try (Scanner s = new Scanner(new File(filename)).useDelimiter("\\r\\n")) {

			List<String> result = new LinkedList<>();
			while (s.hasNext()) {
				result.add(s.next());
			}

			return result;
		} catch (IOException e) {

			logger.error(e.getMessage());
			return Collections.emptyList();
		}
	}

}