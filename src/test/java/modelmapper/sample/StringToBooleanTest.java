package modelmapper.sample;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.modelmapper.MappingException;

public class StringToBooleanTest {

	SrcStringToBoolean src;
	DestStringToBoolean dest;

	@Before
	public void init() {
		src = null;
		dest = null;
	}

	@Test
	public void 結果がtrueになるパターン() {
		// TRUE
		src = new SrcStringToBoolean("TRUE");
		dest = StringToBoolean.convert(src);
		assertTrue(dest.getFlag());

		// true
		src = new SrcStringToBoolean("true");
		dest = StringToBoolean.convert(src);
		assertTrue(dest.getFlag());

		// 1
		src = new SrcStringToBoolean("1");
		dest = StringToBoolean.convert(src);
		assertTrue(dest.getFlag());

		// on
		src = new SrcStringToBoolean("on");
		dest = StringToBoolean.convert(src);
		assertTrue(dest.getFlag());

		// oN (大文字小文字は関係ない)
		src = new SrcStringToBoolean("oN");
		dest = StringToBoolean.convert(src);
		assertTrue(dest.getFlag());
		
		// yes
		src = new SrcStringToBoolean("yes");
		dest = StringToBoolean.convert(src);
		assertTrue(dest.getFlag());
	}

	@Test
	public void 結果がfalseになるパターン() {
		// FALSE
		src = new SrcStringToBoolean("FALSE");
		dest = StringToBoolean.convert(src);
		assertFalse(dest.getFlag());

		// FalsE (大文字小文字は関係ない)
		src = new SrcStringToBoolean("FalsE");
		dest = StringToBoolean.convert(src);
		assertFalse(dest.getFlag());

		// 0
		src = new SrcStringToBoolean("0");
		dest = StringToBoolean.convert(src);
		assertFalse(dest.getFlag());

		// off
		src = new SrcStringToBoolean("off");
		dest = StringToBoolean.convert(src);
		assertFalse(dest.getFlag());

		// ofF (大文字小文字は関係ない)
		src = new SrcStringToBoolean("ofF");
		dest = StringToBoolean.convert(src);
		assertFalse(dest.getFlag());

		// no
		src = new SrcStringToBoolean("no");
		dest = StringToBoolean.convert(src);
		assertFalse(dest.getFlag());
	}

	@Test
	public void 結果がnullになるパターン() {
		// null
		src = new SrcStringToBoolean(null);
		dest = StringToBoolean.convert(src);
		assertNull(dest.getFlag());

		// 空文字
		src = new SrcStringToBoolean(null);
		dest = StringToBoolean.convert(src);
		assertNull(dest.getFlag());
	}

	@Test(expected = MappingException.class)
	public void 数字は0と1以外は変換できない() {
		src = new SrcStringToBoolean("2");
		dest = StringToBoolean.convert(src);
	}

	@Test(expected = MappingException.class)
	public void 浮動小数点型は変換できない() {
		src = new SrcStringToBoolean("0.0");
		dest = StringToBoolean.convert(src);
		assertFalse(dest.getFlag());
	}

	@Test(expected = MappingException.class)
	public void 文字列OKは変換できない() {
		src = new SrcStringToBoolean("OK");
		dest = StringToBoolean.convert(src);
		assertTrue(dest.getFlag());
	}
	
	@Test(expected = MappingException.class)
	public void 文字列NGは変換できない() {
		src = new SrcStringToBoolean("NG");
		dest = StringToBoolean.convert(src);
		assertTrue(dest.getFlag());
	}

}
