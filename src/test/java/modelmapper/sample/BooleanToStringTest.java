package modelmapper.sample;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BooleanToStringTest {

	@Test
	public void trueの場合は文字列trueに変換() {
		SrcBooleanToString src = new SrcBooleanToString(true);
		DestBooleanToString dest = BooleanToString.convert(src);
		assertThat(dest.getFlag(), is("true"));
	}

	@Test
	public void falseの場合は文字列falseに変換() {
		SrcBooleanToString src = new SrcBooleanToString(false);
		DestBooleanToString dest = BooleanToString.convert(src);
		assertThat(dest.getFlag(), is("false"));
	}
	
	@Test
	public void nullの場合はnullのまま() {
		SrcBooleanToString src = new SrcBooleanToString(null);
		DestBooleanToString dest = BooleanToString.convert(src);
		assertNull(dest.getFlag());
	}
}
