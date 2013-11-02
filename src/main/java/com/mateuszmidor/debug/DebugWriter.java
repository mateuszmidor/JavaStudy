package com.mateuszmidor.debug;

import java.io.PrintWriter;

class DebugWriter {
	private PrintWriter writer;

	public DebugWriter(PrintWriter raw_out) {
		writer = raw_out;
	}

	private void debug(String s) {
		System.out.println(s);
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