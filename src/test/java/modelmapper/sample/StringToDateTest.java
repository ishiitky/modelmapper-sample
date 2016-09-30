package modelmapper.sample;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringToDateTest {

	SrcStringToDate src;
	DestStringToDate dest;

	@Before
	public void init() {
		src = null;
		dest = null;
	}
	
	@Test
	public void 結果がtrueになるパターン() {
		// TRUE
		src = new SrcStringToDate("2016/01/01 00:00:00");
		dest = StringToDate.convert(src);
		System.out.println(dest.getDate());
		//assertTrue(dest.getFlag());
	}

}
