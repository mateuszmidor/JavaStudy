package com.mateuszmidor.debug;

import java.io.PrintWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class DebugWriter {
	private PrintWriter writer;
	private static final Logger LOGGER = LoggerFactory.getLogger(DebugWriter.class);
	public DebugWriter(PrintWriter outWriter) {
		writer = outWriter;
	}

	private void debug(String s) {
		LOGGER.debug(s);
	}

	public PrintWriter format(String format, Object... args) {
		debug(String.format(format, args));
		return writer.format(format, args);
	}

	public void print(String s) {
		debug(s);
		writer.print(s);
	}

	public void println() {
		debug("");
		writer.println();
	}

	public void println(String x) {
		debug(x);
		writer.println(x);
	}

	public void flush() {
		writer.flush();
	}

}