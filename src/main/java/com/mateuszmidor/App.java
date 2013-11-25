package com.mateuszmidor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 * 
 */
public class App {
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
	public static void main(String[] args) {
		LOGGER.trace("This is trace!");
		LOGGER.debug("This is debug!");
		LOGGER.info("This is info!");
		LOGGER.warn("This is warn!");
		LOGGER.error("This is error!");
	}
}
