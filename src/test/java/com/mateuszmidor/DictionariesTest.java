package com.mateuszmidor;

import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import java.util.LinkedList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class DictionariesTest {

	private TextFileReader reader;

	@Before
	public void setUp() throws Exception {
		List<String> words = new LinkedList<>();
		words.add("jabłko");
		words.add("gruszka");
		words.add("pomarańcza");

		reader = createNiceMock(TextFileReader.class);
		expect(reader.asMultiLine()).andReturn(words);
		replay(reader);
	}

	@Test
	public void test() {

		Dictionary dict = Dictionaries.fromFile(reader);
		Assert.assertTrue(dict.containsWord("jabłko"));
		Assert.assertTrue(dict.containsWord("pomarańcza"));
		Assert.assertTrue(dict.containsWord("gruszka"));

		verify(reader);
	}

}
