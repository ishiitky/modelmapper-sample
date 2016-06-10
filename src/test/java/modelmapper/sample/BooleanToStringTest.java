package modelmapper.sample;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BooleanToStringTest {

	@Test
	public void 真の場合は文字列trueに変換() {
		SrcBooleanToString src = new SrcBooleanToString(true);
		DestBooleanToString dest = BooleanToString.convert(src);
		assertThat(dest.getFlag(), is("true"));
	}

	@Test
	public void 偽の場合は文字列falseに変換() {
		SrcBooleanToString src = new SrcBooleanToString(false);
		DestBooleanToString dest = BooleanToString.convert(src);
		assertThat(dest.getFlag(), is("false"));
	}
}
